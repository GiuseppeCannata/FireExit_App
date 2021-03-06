package com.ids.ids.notifica;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.ids.ids.ui.MainActivity;

/**
 * Riceve il token appena il prodotto è registrato
 */
public class MyFireBaseIstanceIdService extends FirebaseInstanceIdService {

    private static final String REG_TOKEN = "REG_TOKEN";


    /**
     * Metodo che permette di acquisire il tocken appena il prodotto viene registrato.
     * Inoltre questo token viene inviato al nostro server per poterlo salvare
     */
    @Override
    public void onTokenRefresh() {

        Log.i("MyFireBaseId","Ricezione token from FireBase");
        String recent_token = FirebaseInstanceId.getInstance().getToken();
        Log.i(REG_TOKEN,recent_token);
        //Intent intent = new Intent(this, RegistrationTokenService.class);
        //startService(intent);
    }
}
