package com.example.ignis;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Service_form extends AppCompatActivity {

    EditText edittext_number,edittext_car,edittext_date,edittext_additional_problem,edittext_odometer,edittext_fuel_reading,
            edittext_fuel_type,edittext_belongings,edittext_dents,edittext_estimate,tyrecondition,paintcondition,
            engineoilcondition,coolantcondition,chklist,inspectedby,pickupexecutive,signature;
    TextView textview_front,textview_rear,textview_rtside,textview_ltside,textview_odofuel,textview_shield;
    ImageButton imagebtn_front , imagebtn_rear,imagebtn_rtside,imagebtn_ltside,imagebtn_odofuel,imagebtn_shield;

    Button btnsave;

    private static final int CAMERA_REQUEST_CODE = 100;
    private static final int STORAGE_REQUEST_CODE = 101;
    private static final int IMAGE_PICK_CAMERA_CODE = 102;
    private static final int IMAGE_PICK_GALLERY_CODE = 103;

    private String[] cameraPermissions;
    private String[] storagePermissions;

    private Uri imageUri;

    public String number,car,date,problem,odometer,fuel_reading,fuel_type,belongings,dents,estimate,tyre,paint,oil,coolant,
            checklist,inspected,executive,sign1;
    public DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_form);

        edittext_number = findViewById(R.id.edittext_number);
        edittext_car = findViewById(R.id.edittext_car);
        edittext_date = findViewById(R.id.edittext_date);
        edittext_additional_problem = findViewById(R.id.edittext_additional_problem);
        edittext_odometer = findViewById(R.id.edittext_odometer);
        edittext_fuel_reading = findViewById(R.id.edittext_fuel_reading);
        edittext_fuel_type = findViewById(R.id.edittext_fuel_type);
        edittext_belongings = findViewById(R.id.edittext_belongings);
        edittext_dents = findViewById(R.id.edittext_dents);
        edittext_estimate = findViewById(R.id.edittext_estimate);
        tyrecondition = findViewById(R.id.tyrecondition);
        paintcondition = findViewById(R.id.paintcondition);
        coolantcondition = findViewById(R.id.coolantcondition);
        inspectedby = findViewById(R.id.inspectedby);
        pickupexecutive = findViewById(R.id.pickupexecutive);
        signature = findViewById(R.id.signature);
        textview_front = findViewById(R.id.textview_front);
        textview_rear = findViewById(R.id.textview_rear);
        textview_ltside = findViewById(R.id.textview_ltside);
        textview_rtside = findViewById(R.id.textview_rtside);
        textview_odofuel = findViewById(R.id.textview_odofuel);
        textview_shield = findViewById(R.id.textview_shield);
        imagebtn_front = findViewById(R.id.imagebtn_front);
        imagebtn_rear = findViewById(R.id.imagebtn_rear);
        imagebtn_rtside = findViewById(R.id.imagebtn_rtside);
        imagebtn_ltside = findViewById(R.id.imagebtn_ltside);
        imagebtn_odofuel = findViewById(R.id.imagebtn_odofuel);
        imagebtn_shield = findViewById(R.id.imagebtn_shield);

        btnsave = findViewById(R.id.btnsave);

        myDB = new DatabaseHelper(this);

        cameraPermissions = new  String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermissions = new  String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        textview_front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePickDialog();
            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputData();
            }
        });
    }

    private void inputData() {
        car = ""+ edittext_car.getText().toString().trim();
        number = ""+ edittext_number.getText().toString().trim();
        date =  ""+ edittext_date.getText().toString().trim();
        odometer = ""+edittext_odometer.getText().toString().trim();
        problem = ""+edittext_additional_problem.getText().toString().trim();
        fuel_reading =""+ edittext_fuel_reading.getText().toString().trim();
        fuel_type = ""+edittext_fuel_type.getText().toString().trim();
        belongings = ""+edittext_belongings.getText().toString().trim();
        dents = ""+edittext_dents.getText().toString().trim();
        estimate = ""+edittext_estimate.getText().toString().trim();
        tyre = ""+tyrecondition.getText().toString().trim();
        paint = ""+paintcondition.getText().toString().trim();
        oil = ""+engineoilcondition.getText().toString().trim();
        coolant = ""+ coolantcondition.getText().toString().trim();
        checklist = ""+chklist.getText().toString().trim();
        inspected = ""+inspectedby.getText().toString().trim();
        executive = ""+pickupexecutive.getText().toString().trim();
        sign1 = ""+signature.getText().toString().trim();

        String timestamp = ""+System.currentTimeMillis();

        long result = myDB.insert_record(
                ""+car,
                ""+number,
                ""+date,
                ""+odometer,
                ""+problem,
                ""+fuel_reading,
                ""+fuel_type,
                ""+belongings,
                ""+dents,
                ""+estimate,
                ""+imageUri,
                "",
                "",
                "",
                "",
                "",
                ""+tyre,
                ""+paint,
                ""+oil,
                ""+coolant,
                ""+checklist,
                ""+inspected,
                ""+executive,
                ""+sign1);
        Toast.makeText(this,"Record Added successfully against ID:"+result,Toast.LENGTH_SHORT).show();

    }

    private void imagePickDialog() {
        String[] options = {"Camera", "Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick Image From");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (i==0){
                    if (!checkCameraPermissions()){
                        requestCameraPermission();
                    }
                    else {
                        pickFromCamera();
                    }
                }
                else if (i==1){
                    if (!checkStoragePermission()){
                        requestStoragePermission();
                    }
                    else {
                        pickFromGallery();
                    }
                }

            }
        });
        builder.create().show();
    }

    private void pickFromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, IMAGE_PICK_GALLERY_CODE);
    }

    private void pickFromCamera() {
        ContentValues cv = new ContentValues();
        cv.put(MediaStore.Images.Media.TITLE,"Image title");
        cv.put(MediaStore.Images.Media.DESCRIPTION,"Image description");
        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cv);
        Intent CameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        CameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(CameraIntent, IMAGE_PICK_CAMERA_CODE);
    }

    private boolean checkStoragePermission (){
        boolean res= ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return res;
    }
    private void  requestStoragePermission (){
        ActivityCompat.requestPermissions(this, storagePermissions, STORAGE_REQUEST_CODE);
    }
    private boolean checkCameraPermissions (){
        boolean res= ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        boolean res1= ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return res && res1;
    }
    private void  requestCameraPermission (){
        ActivityCompat.requestPermissions(this, cameraPermissions, CAMERA_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    switch (requestCode){
        case CAMERA_REQUEST_CODE:{
            if(grantResults.length>0){
                boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                if (cameraAccepted && storageAccepted){
                    pickFromCamera();
                }
                else{
                    Toast.makeText(this,"Camera and Storage Permissions Required...",Toast.LENGTH_SHORT).show();
                }
            }
        }
        break;
        case STORAGE_REQUEST_CODE:{
            if(grantResults.length>0){
                boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                if (storageAccepted){
                    pickFromGallery();
                }
                else
                {
                    Toast.makeText(this,"Storage Permission is Required...",Toast.LENGTH_SHORT).show();
                }
            }
        }
        break;
    }
    }

}