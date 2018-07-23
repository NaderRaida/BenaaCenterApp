package com.goldcode.naderwalid.benaapp.Activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.goldcode.naderwalid.benaapp.R;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Toolbar toolbar = findViewById(R.id.contact_us_toolbar);
        TextView toolbarTitle = findViewById(R.id.contact_toolbar_title);
        toolbarTitle.setText("تواصل معنا");
        Typeface type = Typeface.createFromAsset(getAssets(), "Droid_Arabic_Kufi.ttf");
        toolbarTitle.setTypeface(type);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnBackPress();
            }
        });
    }

    private void handleOnBackPress(){
        finish();
    }
    }

