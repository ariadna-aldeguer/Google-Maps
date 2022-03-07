package com.example.googlemaps;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiThread extends AsyncTask<Void, Void, String> {

    public JSONObject jObject;
    public LatLng latLng;

    public ApiThread(LatLng latLng) {
        this.latLng = latLng;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.sunrise-sunset.org/json?lat=" + latLng.latitude + "&lng=" + latLng.longitude);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // Read API results
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String data = bufferedReader.readLine();
            return data;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);
        try {
            jObject = new JSONObject(data);
            jObject = jObject.getJSONObject("results");
            String sunrise = jObject.getString("sunrise");
            String sunset = jObject.getString("sunset");
            Log.i("Sunrise", "------>" + sunrise);
            Log.i("Sunset", "------>" + sunset);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
