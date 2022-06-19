package com.example.traficapplication.activities.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.List;

public class StoreUtils {
    public static SharedPreferences sharedPreferences;

    public static void save(Context context, String key, String values) {
        sharedPreferences = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString(key, values);
        myEdit.commit();
    }

    public static String get(Context context, String key) {
        sharedPreferences = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }
    private static final String LIST_KEY = "list";
    public static void writeListInPref(Context context, List<String> list, final String LIST_KEY) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        SharedPreferences pref = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY, jsonString);
        editor.apply();
    }
}
