package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {


    private GridView gvShow;
    private String[] name = new String[]{"拉亞漢堡","弘爺漢堡","早安有喜","麥味登早餐"};
    private int[] image = {R.drawable.laya,R.drawable.images,R.drawable.good,R.drawable.mac};

    List<Map<String,Object>> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        gvShow = (GridView) findViewById(R.id.gvShow);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i< image.length;i++){
            Map<String,Object> item = new HashMap<>();
            item.put("image",image[i]);
            item.put("text",name[i]);
            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,items,R.layout.gridview_item,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
        gvShow.setAdapter(adapter);
        gvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"我要吃: "+name[i],Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MealActivity.class);
                startActivity(intent);
            }
        });

    }

}