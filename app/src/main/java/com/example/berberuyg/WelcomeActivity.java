package com.example.berberuyg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private Button WelcomeBerberButton;
    private Button WelcomeClientButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        WelcomeBerberButton= (Button)findViewById(R.id.buttonBerber);
        WelcomeClientButton =(Button)findViewById(R.id.buttonMusteri);

        WelcomeBerberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginRegisterDriverIntent =new Intent(WelcomeActivity.this,BerberLoginRegisterActivity.class);
                startActivity(LoginRegisterDriverIntent);

            }
        });

        WelcomeClientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginRegisterCustomerIntent =new Intent(WelcomeActivity.this,RegisterActivity.class);
                startActivity(LoginRegisterCustomerIntent);

            }
        });
    }
}
