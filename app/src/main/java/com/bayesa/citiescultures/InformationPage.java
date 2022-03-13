package com.bayesa.citiescultures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bayesa.citiescultures.databinding.ActivityInformationPageBinding;

public class InformationPage extends AppCompatActivity {
    private ActivityInformationPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflate -> connect to xml and code file.
        binding = ActivityInformationPageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // to meet data
        //Intent intent = getIntent();
        //Casting
        //CitiesInformation citiesInformation = (CitiesInformation) intent.getSerializableExtra("cities");

        //CitiesInformation citiesInformation = info;

        Singleton singleton = Singleton.getInstance();
        CitiesInformation citiesInformation = singleton.getCitiesInformation();


        binding.imageView.setImageResource(citiesInformation.picture);
        binding.citiesView.setText(citiesInformation.cities_name);
        binding.descriptionView.setText(citiesInformation.cities_description);



    }
    public void back(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void nextPage(View view){
        Toast.makeText(this,"Bu özellik üzerinde çalışılıyor...",Toast.LENGTH_SHORT).show();

    }
}