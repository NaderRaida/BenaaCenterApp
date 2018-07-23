package com.goldcode.naderwalid.benaapp.Activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.goldcode.naderwalid.benaapp.R;

public class WhoAreWeActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_are_we);
        Toolbar toolbar = findViewById(R.id.who_are_we_toolbar);
        toolbar.setTitle("من نحن");
//        toolbar.setPaddingRelative(350,0,0,0);
        setSupportActionBar(toolbar);
        TextView toolbarTitle = findViewById(R.id.who_toolbar_title);
        toolbarTitle.setText("من نحن");
        Typeface type = Typeface.createFromAsset(getAssets(), "Droid_Arabic_Kufi.ttf");

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
