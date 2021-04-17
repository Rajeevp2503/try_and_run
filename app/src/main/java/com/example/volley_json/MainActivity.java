package com.example.volley_json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    RecyclerView recview;

    private static final String url ="https://mocki.io/v1/cc36fc9c-60f6-4e8c-bd4a-4a27d79e0e52" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            recview = (RecyclerView)findViewById(R.id.recview);
            recview.setLayoutManager(new LinearLayoutManager(this));

            RequestQueue requestQueue;
            requestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Log.d("res",response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
             Datum []objects  =  gson.fromJson(response,Datum[].class);
                //Log.d("res", String.valueOf(objects));
                recview.setAdapter(new myadapter(objects , getApplicationContext()));
            }
        }, new  Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            Log.e("res","kuch toh gadbad hai daya");
            }
        });

        requestQueue.add(request);
    }
}