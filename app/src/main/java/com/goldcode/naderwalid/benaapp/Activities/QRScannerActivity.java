package com.goldcode.naderwalid.benaapp.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;


import com.dlazaro66.qrcodereaderview.QRCodeReaderView.OnQRCodeReadListener;
import com.example.qr_readerexample.PointsOverlayView;
import com.goldcode.naderwalid.benaapp.R;

public class QRScannerActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback, OnQRCodeReadListener {

    private static final int MY_PERMISSION_REQUEST_CAMERA = 0;

    private ViewGroup mainLayout;
    private TextView resultTextView;
    private QRCodeReaderView qrCodeReaderView;
    private PointsOverlayView pointsOverlayView;
    Button btn;
    String code;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrscanner_activity);
//        ActionBar actionBar =getSupportActionBar();
//        actionBar.hide();
        mainLayout = findViewById(R.id.main_layout);
        initQRCodeReaderView();

//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
//                == PackageManager.PERMISSION_GRANTED) {
//            initQRCodeReaderView();
//        } else {
//            requestCameraPermission();
//        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (qrCodeReaderView != null) {
            qrCodeReaderView.startCamera();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (qrCodeReaderView != null) {
            qrCodeReaderView.stopCamera();
        }
    }

    // Called when a QR is decoded
    // "text" : the text encoded in QR
    // "points" : points where QR control points are placed
    @Override
    public void onQRCodeRead(String text, PointF[] points) {
//        resultTextView.setText(text);
        pointsOverlayView.setPoints(points);
        code = text;
        qrCodeReaderView.stopCamera();
        intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.putExtra("contentOfQR", code);
        startActivity(intent);
        finish();
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        if (requestCode != MY_PERMISSION_REQUEST_CAMERA) {
//            return;
//        }
//
//        if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            Snackbar.make(mainLayout, "Camera permission was granted.", Snackbar.LENGTH_SHORT).show();
//            initQRCodeReaderView();
//        } else {
//            Snackbar.make(mainLayout, "Camera permission request was denied.", Snackbar.LENGTH_SHORT)
//                    .show();
//        }
//    }
//
//
//    private void requestCameraPermission() {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
//            Snackbar.make(mainLayout, "Camera access is required to display the camera preview.",
//                    Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    ActivityCompat.requestPermissions(QRScannerActivity.this, new String[]{
//                            Manifest.permission.CAMERA
//                    }, MY_PERMISSION_REQUEST_CAMERA);
//                }
//            }).show();
//        } else {
//            Snackbar.make(mainLayout, "Permission is not available. Requesting camera permission.",
//                    Snackbar.LENGTH_LONG).show();
//            ActivityCompat.requestPermissions(this, new String[]{
//                    Manifest.permission.CAMERA
//            }, MY_PERMISSION_REQUEST_CAMERA);
//        }
//    }

    private void initQRCodeReaderView() {
        View content = getLayoutInflater().inflate(R.layout.qrscanner_content, mainLayout, true);

        qrCodeReaderView = content.findViewById(R.id.qrdecoderview);
        resultTextView = content.findViewById(R.id.result_text_view);
        pointsOverlayView = content.findViewById(R.id.points_overlay_view);
        btn = content.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qrCodeReaderView.stopCamera();
                intent = new Intent(getApplicationContext(), LoginActivity.class);
//                intent.putExtra("contentOfQR",code);
                startActivity(intent);
                finish();
            }
        });
        qrCodeReaderView.setAutofocusInterval(2000L);
        qrCodeReaderView.setOnQRCodeReadListener(this);
        qrCodeReaderView.setBackCamera();
        qrCodeReaderView.setTorchEnabled(false);
        qrCodeReaderView.setQRDecodingEnabled(true);

        qrCodeReaderView.startCamera();


    }
}
