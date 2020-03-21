package com.example.albunsmusicasapp.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AppUtil {

    public static boolean verificaConexaoComInternet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo;

        if (connectivityManager != null){
            networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected() &&
                    (networkInfo.getType() == ConnectivityManager.TYPE_WIFI
                    || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
        }

        return false;
    }

}
