package fcu.mp.foodapp;

import static fcu.mp.foodapp.R.layout.activity_order4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order4 extends AppCompatActivity {

    private ListView lvShow;
    private String[] name = new String[]{"葳威現做漢堡 $70","蔬食沙拉 $40","現炸薯條 $35","可樂 $15"};
    private int[] image = new int[]{R.drawable.hamber,R.drawable.salad,R.drawable.french,R.drawable.cola};

    List<Map<String,Object>> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav);
        bottomNavigationView.setOnNavigationItemSelectedListener((item) -> {

            switch(item.getItemId()){
                case R.id.car:
                    Toast.makeText(this,"購物車清單",Toast.LENGTH_SHORT).show();
                    Intent last4 = new Intent();
                    last4.setClass(this,Last4.class);
                    startActivity(last4);
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

        lvShow = (ListView) findViewById(R.id.lvShow);

        for(int i=0;i< image.length;i++){
            Map<String,Object> item = new HashMap<>();
            item.put("image",image[i]);
            item.put("text",name[i]);
            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,items,R.layout.listview_item,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
        lvShow.setAdapter(adapter);
        lvShow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Order4.this,"已加入購物車: "+name[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}