package com.example.a1811intent;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.a1811intent.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {

    static final String KEY3 = "KEY";
    static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThirdBinding binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        binding.toFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        binding.Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(KEY3, "THIRD");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String str = data.getStringExtra(KEY3);
            Toast.makeText(this, "from " + str + " to THIRD", Toast.LENGTH_SHORT).show();
        }
    }
}