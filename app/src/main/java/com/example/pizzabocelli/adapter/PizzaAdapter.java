package com.example.pizzabocelli.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzabocelli.MainActivity;
import com.example.pizzabocelli.databinding.PizzaItemBinding;
import com.example.pizzabocelli.model.Food;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder> {

    private final ArrayList<Food> pizzaList;
    private final Context context;

    public PizzaAdapter(ArrayList<Food> pizzaList, Context context) {
        this.pizzaList = pizzaList;
        this.context = context;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PizzaItemBinding listItem = PizzaItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new PizzaViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder, int position) {
        Food food = pizzaList.get(position);

        holder.binding.imgFood.setBackgroundResource(food.getImgFood());
        holder.binding.txtPizzaName.setText(food.getFoodName());
        holder.binding.txtPizzaDescription.setText(food.getFoodDescription());
        holder.binding.txtPizzaPrice.setText(food.getPrice());

        // Atualiza o contador de quantidade com base no objeto Food
        holder.binding.txtAddRemove.setText(String.valueOf(food.getQuantity()));

        // Ação para o botão de adicionar
        holder.binding.btnAdd.setOnClickListener(v -> {
            int currentQuantity = food.getQuantity();
            currentQuantity++;
            food.setQuantity(currentQuantity);
            holder.binding.txtAddRemove.setText(String.valueOf(currentQuantity));

            // Atualiza o preço total na MainActivity
            ((MainActivity) context).updateTotalPrice(calculateTotalPrice());
        });

        // Ação para o botão de remover
        holder.binding.btnRemove.setOnClickListener(v -> {
            int currentQuantity = food.getQuantity();
            if (currentQuantity > 0) {
                currentQuantity--;
                food.setQuantity(currentQuantity);
                holder.binding.txtAddRemove.setText(String.valueOf(currentQuantity));

                // Atualiza o preço total na MainActivity
                ((MainActivity) context).updateTotalPrice(calculateTotalPrice());
            }
        });
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    // Método para calcular o preço total com base nas quantidades
    private double calculateTotalPrice() {
        double total = 0.0;
        for (Food food : pizzaList) {
            double price = Double.parseDouble(food.getPrice().replace("R$", "").replace(",", "."));
            total += price * food.getQuantity();
        }
        return total;
    }

    public static class PizzaViewHolder extends RecyclerView.ViewHolder{

        PizzaItemBinding binding;

        public PizzaViewHolder(PizzaItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
