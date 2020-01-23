package com.example.foodtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView milk_title, milk_content;
    JSONArray milk_products, test1;
    JSONObject json_milk_products;
    ImageView testSuccess, testFailure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        milk_title = findViewById(R.id.milk_title);
        milk_content = findViewById(R.id.milk_content);
        testSuccess = findViewById(R.id.imageSuccess);


        try {
            json_milk_products = new JSONObject(OpenJSON.readJSONFromAsset(getApplicationContext(), "milk_products.json"));

            try {
                milk_products = json_milk_products.getJSONArray("milk_products");
                RecyclerView fillMilkProducts = findViewById(R.id.showMilkProducts);
                MilkProductsRecycler adapRecycler = new MilkProductsRecycler(getApplicationContext(), milk_products);
                fillMilkProducts.setAdapter(adapRecycler);
                fillMilkProducts.setLayoutManager(new LinearLayoutManager(this));
            } catch (JSONException e) {
                e.printStackTrace();
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void fillRecyclerWithLanguage(String lang) {

    }
}
