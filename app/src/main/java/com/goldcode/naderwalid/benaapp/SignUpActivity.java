package com.goldcode.naderwalid.benaapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {
    TextView title_label, name_label, phone_label, email_label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        overridePendingTransition(R.anim.bounce, R.anim.animation_leave);
//        ActionBar actionBar =getSupportActionBar();
//        if(actionBar != null){
//            actionBar.hide();
//
//        }
        title_label = findViewById(R.id.title_label);
        phone_label = findViewById(R.id.mobile_label);
        name_label = findViewById(R.id.name_label);
        email_label = findViewById(R.id.email_label);
        Typeface type = Typeface.createFromAsset(getAssets(), "Droid_Arabic_Kufi.ttf");
        title_label.setTypeface(type);
        phone_label.setTypeface(type);
        email_label.setTypeface(type);
        name_label.setTypeface(type);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_right);

    }
}
