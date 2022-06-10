package fcu.mp.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements OnCompleteListener<AuthResult> {

    private EditText etEmail;
    private EditText etPassword;
    FirebaseAuth firebaseAuth;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        firebaseAuth = FirebaseAuth.getInstance();
        preferences = getPreferences(MODE_PRIVATE);
    }

    @Override
    protected void onPause(){
        super.onPause();
        String email = etEmail.getText().toString();
        String pass = etPassword.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Email",email);
        editor.putString("Password",pass);
        editor.commit();
    }
    @Override
    protected void onResume(){
        super.onResume();
        String email = preferences.getString("Email","");
        String pass = preferences.getString("Password","");
        etPassword.setText(pass);
        etEmail.setText(email);

    }

    public void onLogin(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this,this);
    }

    public void onRegister(View view) {

        Intent intent = new Intent();
        intent.setClass(this,Register.class);
        startActivity(intent);
    }

    public void onComplete(@NonNull Task<AuthResult> task){
        if(task.isSuccessful()){
            Toast.makeText(this,"歡迎!登入成功!"+etEmail.getText().toString(),Toast.LENGTH_LONG).show();
            Intent intent = new Intent();
            intent.setClass(this,Meal.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Oops!登入失敗,請檢查是否已註冊!",Toast.LENGTH_LONG).show();
        }
    }
}