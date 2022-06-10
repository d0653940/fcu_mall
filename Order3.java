package fcu.mp.foodapp;

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

public class Order3 extends AppCompatActivity {

    private ListView lvShow;
    private String[] name = new String[]{"招牌牛肉麵 $90","牛肉湯麵 $65","水餃(12顆) $40","飲料 $10"};
    private int[] image = new int[]{R.drawable.beef,R.drawable.noodle,R.drawable.dumpling,R.drawable.drink};

    List<Map<String,Object>> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order3);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav);
        bottomNavigationView.setOnNavigationItemSelectedListener((item) -> {

            switch(item.getItemId()){
                case R.id.car:
                    Toast.makeText(this,"購物車清單",Toast.LENGTH_SHORT).show();
                    Intent last3 = new Intent();
                    last3.setClass(this,Last3.class);
                    startActivity(last3);
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
                Toast.makeText(Order3.this,"已加入購物車: "+name[i],Toast.LENGTH_SHORT).show();
            }
        });

    }
}