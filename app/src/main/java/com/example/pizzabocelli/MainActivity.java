package com.example.pizzabocelli;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzabocelli.adapter.PizzaAdapter;
import com.example.pizzabocelli.databinding.ActivityMainBinding;
import com.example.pizzabocelli.model.Food;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PizzaAdapter pizzaAdapter;
    private ArrayList<Food> pizzaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);

        setContentView(binding.getRoot());

        RecyclerView recyclerViewPizza = binding.RecyclerViewFood;
        recyclerViewPizza.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPizza.setHasFixedSize(true);

        pizzaAdapter = new PizzaAdapter(pizzaList, this);
        recyclerViewPizza.setAdapter(pizzaAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getPizza();
    }

    private void getPizza(){
        Food frangoCatupiry = new Food(
                R.drawable.pizza_frango,
                "Frango com Catupiry",
                "Frango desfiado com catupiry e queijo",
                "R$35,90"
        );
        pizzaList.add(frangoCatupiry);

        Food bacon = new Food(
                R.drawable.bacon,
                "Bacon",
                "Bacon fatiado com queijo, cebola e requeijão",
                "R$38,90"
        );
        pizzaList.add(bacon);

        Food saladaMix = new Food(
                R.drawable.salada,
                "SaladaMix",
                "Pizza com couve, agrião, cebola e tomate",
                "R$32,90"
        );
        pizzaList.add(saladaMix);

        Food italiano = new Food(
                R.drawable.salame_italiano,
                "Italiano",
                "Salame com queijo e cebola",
                "R$35,90"
        );
        pizzaList.add(italiano);
    }

    public void updateTotalPrice(double totalPrice) {
        binding.txtPrice.setText("R$" + String.format("%.2f", totalPrice).replace(".", ","));
    }

}