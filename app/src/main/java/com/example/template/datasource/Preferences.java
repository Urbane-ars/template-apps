package com.example.template.datasource;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class Preferences {
    private static final String settingName = "setting";
    private SharedPreferences sharedPreferences;
    private Context context;

    public Preferences(Context context) {
       sharedPreferences = context.getSharedPreferences(settingName,Context.MODE_PRIVATE);
       this.context = context;
    }

    boolean isIntroShown(){
        Toast.makeText(context, "First start", Toast.LENGTH_LONG).show();
       return sharedPreferences.getBoolean("fistStart", true);
    }

    void introFinished(){
        sharedPreferences.edit().putBoolean("fistStart", false).apply();
    }
}
