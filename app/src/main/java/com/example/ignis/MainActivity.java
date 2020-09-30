package com.example.ignis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button pre_service;
    Button order_flow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pre_service = (Button) findViewById(R.id.btn_pre);
        order_flow = (Button) findViewById(R.id.btn_ord);
        pre_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Pre_Service.class);
                startActivity(intent);
            }
        });
        order_flow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,Order_flow.class);
                startActivity(intent1);
            }
        });
    }
}