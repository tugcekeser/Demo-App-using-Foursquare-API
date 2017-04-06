package com.example.tuze.remindtakehome.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.example.tuze.remindtakehome.Constants.AppConstants;
import com.example.tuze.remindtakehome.R;

import java.io.IOException;

public class NetworkUtil {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean isOnline() {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isConnected(Context context) {
        if (!isNetworkAvailable(context)) {
            Toast.makeText(context, R.string.network_not_available, Toast.LENGTH_LONG).show();
        } else if (!isOnline()) {
            Toast.makeText(context, R.string.not_online, Toast.LENGTH_LONG).show();
        } else {
            Log.d(AppConstants.DEBUG, AppConstants.CONNECTED);
            return true;
        }
        return false;
    }
}
