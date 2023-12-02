package com.example.contextsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.contextsave.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static String LoginTrue = "admin";
    public static String PasswordTrue = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        String log = pref.getString("login", "0");
        String pass = pref.getString("password", "0");
        if (log.equals(LoginTrue) && pass.equals(PasswordTrue)){
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }

        binding.Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = binding.Login.getText().toString();
                String password = binding.Password.getText().toString();
                if (login.equals(LoginTrue) && password.equals(PasswordTrue)){
                    SharedPreferences pref = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();
                    edit.putString("login", login);
                    edit.putString("password", password);
                    edit.commit();

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}