package com.escom.camera;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_CODE = 1240;
    private static final String TAG = MainActivity.class.getName();

    String[] appPermissions = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAndRequestPermissions();
    }

    public void camera1(View view){
        startActivity(new Intent(this, Camera1Activity.class));
    }

    public void camera2(View view){
        startActivity(new Intent(this, Camera2Activity.class));
    }

    public void QR(View view){
        startActivity(new Intent(this, QrActivity.class));
    }

    public boolean checkAndRequestPermissions(){
        List<String> listPermissionNeeded = new ArrayList<>();
        for(String perm: appPermissions){
            if(ContextCompat.checkSelfPermission(this, perm) != PackageManager.PERMISSION_GRANTED){
                listPermissionNeeded.add(perm);
            }
        }

        if(!listPermissionNeeded.isEmpty()){
            ActivityCompat.requestPermissions(MainActivity.this, listPermissionNeeded.toArray(new String[listPermissionNeeded.size()]), PERMISSIONS_REQUEST_CODE);
            return false;
        }
        return true;
    }
}
