package com.bayesa.citiescultures;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bayesa.citiescultures.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CitiesHolder> {

    static ArrayList<CitiesInformation> citiesInformationArrayList2;

    public CitiesAdapter(ArrayList<CitiesInformation> citiesInformationArrayList, MainActivity mainActivity) {
        this.citiesInformationArrayList2 = citiesInformationArrayList;
    }

    @NonNull
    @Override
    public CitiesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // xml bağlama işini burada yapacağız
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CitiesHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesHolder holder, int position) {
            // layout içerisindeki hangi verileri göstermek istersek burada göstereceğiz.
        holder.binding.recyclerViewTextView.setText(citiesInformationArrayList2.get(position).cities_name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(holder.itemView.getContext(), citiesInformationArrayList2.get(holder.getAdapterPosition()).cities_name,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(holder.itemView.getContext(), InformationPage.class);
                //info = citiesInformationArrayList2.get(holder.getAdapterPosition());
                //intent.putExtra("cities",citiesInformationArrayList2.get(holder.getAdapterPosition()));
                Singleton singleton = Singleton.getInstance();
                singleton.setCitiesInformation(citiesInformationArrayList2.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        // xml'in kaç kez oluşturacağını söyler.
        return citiesInformationArrayList2.size();
    }
    // To Apply RecyclerView Adapter

    public class CitiesHolder extends RecyclerView.ViewHolder{
        private RecyclerRowBinding binding;

        public CitiesHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        // Görünümlerimizi tutan yardımcı bir sınıftır.

    }


}
