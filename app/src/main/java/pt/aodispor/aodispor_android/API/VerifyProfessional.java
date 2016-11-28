package pt.aodispor.aodispor_android.API;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import pt.aodispor.aodispor_android.AppDefinitions;

public class VerifyProfessional {
    private static final String BASE_URL = "https://api.aodispor.pt/profiles/me";

    public static boolean isRegistered(String phoneNumber, String password)
    {
        //startLoading();
        Professional info = null;
        HttpRequestTask request = new HttpRequestTask(Professional.class, null, BASE_URL);
        request.setMethod(HttpRequestTask.POST_REQUEST);
        request.setType(HttpRequest.UPDATE_PROFILE);
        request.addAPIAuthentication(phoneNumber, password);
        try {
            info = (Professional) request.execute().get(AppDefinitions.MILISECONDS_TO_TIMEOUT_ON_QUERY, TimeUnit.MILLISECONDS);
        }catch (Exception e) {
            return false;
        }
        if (info == null ) {
            return false;
        }

        //Log.d("INOT",info.full_name);
        Log.d("INOT",info.title);
        Log.d("INOT",info.currency);
        Log.d("INOT",info.type);
        Log.d("INOT",info.phone);
        Log.d("INOT",info.rate);
        Log.d("INOT",info.location);

        //if (info.full_name==null || info.full_name.equals("")) return false;
        if (info.title==null || info.title.equals("")) return false;
        if (info.currency==null || info.currency.equals("")) return false;
        if (info.type==null || info.type.equals("")) return false;
        if (info.phone==null || info.phone.equals("")) return false;
        if (info.rate==null || info.rate.equals("")) return false;
        if (info.location==null || info.location.equals("")) return false;
        //if (info.avatar_url==null || info.avatar_url.equals("")) return false;

        //these propertes also need to have values???

        Log.d("INOT","true");

        return true;

    }

}
