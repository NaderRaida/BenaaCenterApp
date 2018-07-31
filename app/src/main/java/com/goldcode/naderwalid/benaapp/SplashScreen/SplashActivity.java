package com.goldcode.naderwalid.benaapp.SplashScreen;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.goldcode.naderwalid.benaapp.Activities.QRScannerActivity;
import com.goldcode.naderwalid.benaapp.R;

public class SplashActivity extends AppCompatActivity implements OnRequestPermissionsResultCallback {
    private static final int MY_PERMISSION_REQUEST_CAMERA = 0;
    TextView title_view;
    Button btn;
    private ViewGroup mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mainLayout = findViewById(R.id.relative_splash_layout);
        title_view = findViewById(R.id.title_of_splash);
        Typeface type = Typeface.createFromAsset(getAssets(),"Droid_Arabic_Kufi.ttf");
        title_view.setTypeface(type);
        btn = findViewById(R.id.start_btn);
        Typeface btn_type = Typeface.createFromAsset(getAssets(), "Droid_Arabic_Kufi.ttf");
        btn.setTypeface(btn_type);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QRScannerActivity.class);
                startActivity(intent);
                finish();
            }
        });
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestCameraPermission();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != MY_PERMISSION_REQUEST_CAMERA) {
            return;
        }

        if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Snackbar.make(mainLayout, "Camera permission was granted.", Snackbar.LENGTH_SHORT).show();
//            initQRCodeReaderView();
        } else {
            Snackbar.make(mainLayout, "Camera permission request was denied.", Snackbar.LENGTH_SHORT)
                    .show();
        }
    }


    private void requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            Snackbar.make(mainLayout, "Camera access is required to display the camera preview.",
                    Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityCompat.requestPermissions(SplashActivity.this, new String[]{
                            Manifest.permission.CAMERA
                    }, MY_PERMISSION_REQUEST_CAMERA);
                }
            }).show();
        } else {
            Snackbar.make(mainLayout, "Permission is not available. Requesting camera permission.",
                    Snackbar.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.CAMERA
            }, MY_PERMISSION_REQUEST_CAMERA);
        }
    }

}
