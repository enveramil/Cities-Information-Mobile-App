package com.bayesa.citiescultures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.bayesa.citiescultures.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<CitiesInformation> citiesInformationArrayList;
    SwipeRefreshLayout swipeRefreshLayout;
    CitiesAdapter citiesAdapter;


    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //used the binding instead findViewById in terms of access xml
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        // initialize


        citiesInformationArrayList = PrefConfig.readListFromPref(this);
        if (citiesInformationArrayList == null){
            citiesInformationArrayList = new ArrayList<>();
        }



        // Get Data
        String istanbul_description = "Anadolu Yakası veya Asya Yakası denir. Tarihte ilk olarak üç tarafı Marmara Denizi, Boğaziçi ve Haliç'in sardığı bir yarımada üzerinde kurulan İstanbul'un batıdaki sınırını İstanbul Surları oluşturmaktaydı. Gelişme ve büyüme sürecinde surların her seferinde daha batıya ilerletilerek inşa edilmesiyle 4 defa genişletilen şehrin[11] 39 ilçesi vardır. Sınırları içerisinde ise büyükşehir belediyesi ile birlikte toplam 40 belediye bulunmaktadır.";
        String ankara_description = "Anadolu Yakası veya Asya Yakası denir. Tarihte ilk olarak üç tarafı Marmara Denizi, Boğaziçi ve Haliç'in sardığı bir yarımada üzerinde kurulan İstanbul'un batıdaki sınırını İstanbul Surları oluşturmaktaydı. Gelişme ve büyüme sürecinde surların her seferinde daha batıya ilerletilerek inşa edilmesiyle 4 defa genişletilen şehrin[11] 39 ilçesi vardır. Sınırları içerisinde ise büyükşehir belediyesi ile birlikte toplam 40 belediye bulunmaktadır.";
        String rize_description = "Anadolu Yakası veya Asya Yakası denir. Tarihte ilk olarak üç tarafı Marmara Denizi, Boğaziçi ve Haliç'in sardığı bir yarımada üzerinde kurulan İstanbul'un batıdaki sınırını İstanbul Surları oluşturmaktaydı. Gelişme ve büyüme sürecinde surların her seferinde daha batıya ilerletilerek inşa edilmesiyle 4 defa genişletilen şehrin[11] 39 ilçesi vardır. Sınırları içerisinde ise büyükşehir belediyesi ile birlikte toplam 40 belediye bulunmaktadır.";

        CitiesInformation istanbul = new CitiesInformation(R.drawable.istanbu,"İstanbul",istanbul_description);
        CitiesInformation ankara = new CitiesInformation(R.drawable.ankara,"Ankara",ankara_description);
        CitiesInformation rize = new CitiesInformation(R.drawable.rize,"Rize",rize_description);


        // keep the all data in Array list.

        citiesInformationArrayList.add(istanbul);
        citiesInformationArrayList.add(ankara);
        citiesInformationArrayList.add(rize);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        citiesAdapter = new CitiesAdapter(citiesInformationArrayList, MainActivity.this);
        binding.recyclerView.setAdapter(citiesAdapter);


        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                PrefConfig.writeListInPref(getApplicationContext(),citiesInformationArrayList);

                citiesInformationArrayList.add(istanbul);
                citiesInformationArrayList.add(ankara);
                citiesInformationArrayList.add(rize);

                citiesAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);

            }
        });

        /*
        //ArrayAdapter

        //mapping
        //bir yapıyı başka bir yapıya dönüştürür.

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                citiesInformationArrayList.stream().map(citiesInformation -> citiesInformation.cities_name).collect(Collectors.toList())
        );
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, citiesInformationArrayList.get(i).cities_name,Toast.LENGTH_SHORT).show();
                // Send data to another activity
                Intent intent = new Intent(MainActivity.this, InformationPage.class);
                //Serialization : Bir nesnenin saklanacak / transfer edilecek forma dönüştürülme işlemidir.
                intent.putExtra("cities",citiesInformationArrayList.get(i));
                startActivity(intent);

            }
        });


         */


    }



}