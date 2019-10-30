package com.example.kuis0314;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    private static SharedPref INSTANCE;
    private static SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final String SP_NAME = "loginsession";
    public static final String SP_NAMA = "user" ;

    public SharedPref (Context context) {
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences(SP_NAME, Context. MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public static SharedPref getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new SharedPref(context);
        }
        return INSTANCE;
    }

    public SharedPreferences Pref(){
        return sharedPreferences;
    }

    public Boolean isLogin(){
        return sharedPreferences.getBoolean("isLogin",false);
    }

    public void setLogin (boolean isCall){
        sharedPreferences.edit().putBoolean("isLogin", isCall).apply();
    }

    public void setName(String spNama, String isName){
        sharedPreferences.edit().putString(SP_NAMA, isName).apply();
    }

    public String getName(){
        return sharedPreferences.getString(SP_NAMA,"");
    }
}
