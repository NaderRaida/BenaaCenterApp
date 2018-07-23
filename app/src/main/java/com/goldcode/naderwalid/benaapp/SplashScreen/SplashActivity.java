package com.goldcode.naderwalid.benaapp.SplashScreen;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.goldcode.naderwalid.benaapp.Activities.QRScannerActivity;
import com.goldcode.naderwalid.benaapp.R;

public class SplashActivity extends AppCompatActivity {
    TextView title_view;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        title_view = findViewById(R.id.title_of_splash);
        Typeface type = Typeface.createFromAsset(getAssets(), "lemonada-light.ttf");
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
    }
}
