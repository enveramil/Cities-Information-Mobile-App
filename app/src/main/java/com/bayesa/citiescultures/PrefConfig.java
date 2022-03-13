package com.bayesa.citiescultures;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PrefConfig {

    private static final String LIST_KEY = "list_key";

    public static void writeListInPref(Context context, ArrayList<CitiesInformation> list){
        Gson gson = new Gson();
        String json = gson.toJson(list);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(LIST_KEY,json);
        editor.apply();

    }

    public static ArrayList<CitiesInformation> readListFromPref(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String json = preferences.getString(LIST_KEY,"");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<CitiesInformation>>() {}.getType();
        ArrayList<CitiesInformation> list = gson.fromJson(json,type);
        return list;
    }

}
