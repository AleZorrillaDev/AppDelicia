package com.example.appdelicia01.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String PREF_NAME = "delicia_session";
    private static final String KEY_NAME = "user_name";
    private static final String KEY_EMAIL = "user_email";

    private final SharedPreferences prefs;
    private final SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void saveUser(String name, String email) {
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    public String getName() {
        return prefs.getString(KEY_NAME, "Invitado");
    }

    public String getEmail() {
        return prefs.getString(KEY_EMAIL, "invitado@delicia.com");
    }

    public boolean isLoggedIn() {
        return prefs.contains(KEY_EMAIL);
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }
}
