package com.ids.ids.toServer.ServerTask;

import android.os.AsyncTask;
import android.util.Log;

import com.ids.ids.utils.Parametri;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Classe che setta i valori per la connessione con il server e testa la connessione
 */
public class ServerConnection extends AsyncTask<Void, Void, Boolean> {

    private static final String TAG = "ServerConnection";

    private HttpURLConnection connection;
    private final String PATH = Parametri.PATH;

    @Override
    protected void onPreExecute() {

    }
    //"/FireExit"

    @Override
    protected Boolean doInBackground(Void... arg0) {

        try {
            connection = (HttpURLConnection) new URL(PATH+"/FireExit").openConnection();
            connection.setConnectTimeout(4000); //lancia una eccezione qualora la connessione non viene stabilita entro i 6 secondi
            connection.setReadTimeout(6000);    //lancia un eccezione se la lettura dal server non termina entro i 6 secondi
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return (200 <= responseCode && responseCode <= 399);
        } catch (IOException exception) {
            Log.e(TAG,"Server non raggiungibile");
            return false;
        }

    }

    @Override
    protected void onProgressUpdate(Void... arg0) {

    }

    @Override
    protected void onPostExecute(Boolean result) {

    }
}
