package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MealActivity extends AppCompatActivity {

    private ListView lvshow;
    private String[] name = new String[]{"薯條 $20","豬肉蛋堡 $40","奶茶 $15","蛋餅 $35"};
    private int[] image = new int[]{R.drawable.french,R.drawable.hamber,R.drawable.tea,R.drawable.egg};


    List<Map<String,Object>> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        lvshow = (ListView) findViewById(R.id.lvShow);

        for(int i=0;i< image.length;i++){
            Map<String,Object> item = new HashMap<>();
            item.put("image",image[i]);
            item.put("text",name[i]);
            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,items,R.layout.listview_item,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
        lvshow.setAdapter(adapter);
    }
}