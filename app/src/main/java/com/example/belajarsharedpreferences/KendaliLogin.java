package com.example.belajarsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class KendaliLogin {
    private SharedPreferences sp;
    private SharedPreferences.Editor spEditor;
    private Context ctx;

    public String keyUsername = "Ya08483hhjiur89nwwe==username";
    public String varUsername1 = "desti";
    public String varPassword1 = "apaya?";
    public String varUsername2 = "jennie";
    public String varPassword2 = "apatuch?";


    public KendaliLogin(Context ctx) {
        this.ctx = ctx;
    }

    public void setPref(String key, String value){
        sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        spEditor = sp.edit();
        spEditor.putString(key, value);
        spEditor.commit();
    }

    public String getPref(String key){
        sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        return sp.getString(key, null);
    }

    public Boolean isLogin(String key){
        if(getPref(key) != null){
            return true;
        }
        else{
            return false;
        }
    }
}
