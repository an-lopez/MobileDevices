package com.escom.camera;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Camera1Activity extends AppCompatActivity {
    private File file;
    private Button button;
    private static final String TAG = Camera1Activity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera1);
        ActivityCompat.requestPermissions(Camera1Activity.this,
                new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},23);

        button = findViewById(R.id.btn_takephoto);
        file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "misfotos");
        if (file.exists())
            Log.d(TAG, "Ya existe la carpeta: " + file.getAbsolutePath());
        else
            Log.d(TAG, "No existe la carpeta: " + file.getAbsolutePath());
        if (isExternalStorageWritable())
            Log.d(TAG, "Si se puede escribir");
        else
            Log.d(TAG, "No se puede escribir");

        if (file.mkdirs())
            Log.d(TAG, "SE CREO LA CARPETA");
        else
            Log.d(TAG, "NO SE CREO LA CARPETA");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getCode() + ".jpg";
                File file1 = new File(file, s);
                try {
                    file1.createNewFile();
                } catch (IOException e) {
                    Log.e(TAG, "Error al crear " + file1.getAbsolutePath() + ":  ", e);
                }
                Uri u = FileProvider.getUriForFile(Camera1Activity.this, BuildConfig.APPLICATION_ID + ".provider", file1);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, u);
                startActivityForResult(intent, 0);
            }
        });
    }

    private String getCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmss");
        return "pic_" + sdf.format(new Date());
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

}
