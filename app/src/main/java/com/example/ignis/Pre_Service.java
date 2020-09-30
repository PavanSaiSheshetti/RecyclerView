package com.example.ignis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pre_Service extends AppCompatActivity {
    Button Addnew;
    RecyclerView view;

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre__service);
        Addnew = (Button) findViewById(R.id.addnew);
        view =findViewById(R.id.recycleviewlist);
        myDB = new DatabaseHelper(this);

        loardRecords();

        Addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pre_Service.this,Service_form.class);
                startActivity(intent);
            }
        });
    }

    private void loardRecords() {
        AdapterRecord adapterRecord = new AdapterRecord(Pre_Service.this,
                myDB.getAllRecords());
        view.setAdapter(adapterRecord);
    }
}