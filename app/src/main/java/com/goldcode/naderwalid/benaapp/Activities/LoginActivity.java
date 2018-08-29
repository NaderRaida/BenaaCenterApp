package com.goldcode.naderwalid.benaapp.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.goldcode.naderwalid.benaapp.R;


public class LoginActivity extends AppCompatActivity {
    Intent sign_up_btn_intent;
    Intent login_btn_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.bounce, R.anim.animation_leave);
        setContentView(R.layout.activity_login);
//        ActionBar actionBar =getSupportActionBar();
//        if(actionBar != null){
//            actionBar.hide();
//
//        }
        TextView title_view = findViewById(R.id.txt_title);
        TextView mobile_label = findViewById(R.id.mobile_txt);

        final EditText editText = findViewById(R.id.edit_txt_mobile);
        final Button login_btn = findViewById(R.id.button);
        Button signUp_btn = findViewById(R.id.button2);

        Typeface type = Typeface.createFromAsset(getAssets(), "Droid_Arabic_Kufi.ttf");
        title_view.setTypeface(type);
        mobile_label.setTypeface(type);
        editText.setTypeface(type);
        login_btn.setTypeface(type);
        signUp_btn.setTypeface(type);

        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sign_up_btn_intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(sign_up_btn_intent);
                finish();
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*if (editText.getText().toString().equals("0592766119")) {*/
                    login_btn_intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(login_btn_intent);
                    finish();
              /*  } else {
                    Toast.makeText(getApplicationContext(), "this no equals", Toast.LENGTH_LONG).show();
                }
                */

            }
        });


    }
}
