package com.example.andre.myapplication;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by andre on 9/16/17.
 */

public class ClickRequest implements View.OnClickListener {

    private final MainActivity mainActivity;

    public ClickRequest(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        final String url = "http://www.mocky.io/v2/59bd5e363c00000c03529fb4";

        Log.d("url", url);

        try {
            String response = doRequest(url);
            Toast.makeText(mainActivity.getApplicationContext(), "Response: " + response, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(mainActivity.getApplicationContext(), "Erro :(" + e.getMessage(), Toast.LENGTH_LONG).show();

        }

    }

    private String doRequest(final String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
