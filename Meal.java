package fcu.mp.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Meal extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    private GridView gridView;
    private String[] name = new String[]{"鬍鬚吳滷肉飯專賣","洪記火雞肉飯","劉家麵攤","老張牛肉麵","葳威漢堡","羅素食"};
    private int[] image = {R.drawable.wu,R.drawable.hung,R.drawable.liu,R.drawable.chang,R.drawable.hamcan,R.drawable.veg};

    List<Map<String,Object>> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav);
        bottomNavigationView.setOnNavigationItemSelectedListener((item) -> {

            switch(item.getItemId()){
                case R.id.car:
                    Toast.makeText(this,"購物車清單",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.logout:
                    Toast.makeText(this,"登出",Toast.LENGTH_SHORT).show();
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent();
                    intent.setClass(this,Login.class);
                    startActivity(intent);
                    break;
                case R.id.pro:
                    Toast.makeText(this,"個人資料",Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        });

        gridView = (GridView) findViewById(R.id.gridview);

        for(int i=0;i< image.length;i++){
            Map<String,Object> item = new HashMap<>();
            item.put("image",image[i]);
            item.put("text",name[i]);
            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,items,R.layout.gridview_item,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i){
                    case 0:
                        Toast.makeText(Meal.this,"我要吃:"+name[0],Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(Meal.this,Order0.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(Meal.this,"我要吃:"+name[1],Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent();
                        intent1.setClass(Meal.this,Order1.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Toast.makeText(Meal.this,"我要吃:"+name[2],Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent();
                        intent2.setClass(Meal.this,Order2.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Toast.makeText(Meal.this,"我要吃:"+name[3],Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent();
                        intent3.setClass(Meal.this,Order3.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Toast.makeText(Meal.this,"我要吃:"+name[4],Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent();
                        intent4.setClass(Meal.this,Order4.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Toast.makeText(Meal.this,"我要吃:"+name[5],Toast.LENGTH_SHORT).show();
                        Intent intent5 = new Intent();
                        intent5.setClass(Meal.this,Order5.class);
                        startActivity(intent5);
                        break;


                }
            }
        });
    }



}