package fcu.mp.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Last0 extends AppCompatActivity {

    Button btn_up[] = new Button[4];
    Button btn_down[] = new Button[4];
    TextView num[] = new TextView[4];
    TextView tv[] = new TextView[4];

    int up[] = { R.id.btn_add1, R.id.btn_add2, R.id.btn_add3, R.id.btn_add4 };
    int down[] = { R.id.btn_down1, R.id.btn_down2, R.id.btn_down3,
            R.id.btn_down4};

    int number[] = { R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4};
    TextView tv_pork, tv_soup, tv_noodle, tv_lil;
    int e[]={0,0,0,0};

    ImageView imv;
    String s = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        findView();

        tv_pork.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                imv.setImageResource(R.drawable.pork);

            }
        });
        tv_soup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                imv.setImageResource(R.drawable.soup);

            }
        });
        tv_noodle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                imv.setImageResource(R.drawable.noodle);

            }
        });
        tv_lil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                imv.setImageResource(R.drawable.lil);

            }
        });
    }

    public void Down(View view){
        for(int i=0;i<btn_down.length;i++){
            if(view==btn_down[i]){
                if(e[i]>0){
                    e[i]--;
                    s=Integer.toString(e[i]);
                    num[i].setText(s);
                }
            }
        }
    }

    public void Enter(View view){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("????????????").setMessage(
                    "?????????:"+e[0]+"???\n"+
                    "?????????:"+e[1]+"???\n"+
                    "?????????:"+e[2]+"???\n"+
                    "??????:"+e[3]+"???\n\n"+ "???????????????????????? "+(e[0]*45+e[1]*20+e[2]*35+e[3]*10)+"??????\n").setPositiveButton("??????", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent end = new Intent();
                    end.setClass(Last0.this,Ending.class);
                    startActivity(end);
                }
            }).show();
        }

    public void UP(View view){
        for(int i=0;i<btn_up.length;i++){
            if(view==btn_up[i]){
                e[i]++;
                s=Integer.toString(e[i]);
                num[i].setText(s);
            }
        }
    }

    public void findView(){
        for(int i=0;i<btn_up.length;i++){
            btn_up[i]=(Button) this.findViewById(up[i]);
            btn_down[i]=(Button) this.findViewById(down[i]);
            num[i]=(TextView) this.findViewById(number[i]);

            tv_pork=(TextView) this.findViewById(R.id.pork);
            tv_soup=(TextView) this.findViewById(R.id.soup);
            tv_noodle=(TextView) this.findViewById(R.id.noodle);
            tv_lil=(TextView) this.findViewById(R.id.lil);
            imv = (ImageView) this.findViewById(R.id.imv);
        }
    }
}


