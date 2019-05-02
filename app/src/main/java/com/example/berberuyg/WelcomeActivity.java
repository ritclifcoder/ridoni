package com.example.berberuyg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class WelcomeActivity extends AppCompatActivity {

   Button musteri;
   Button berber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        musteri = (Button) findViewById(R.id.musteri);
        berber =(Button) findViewById(R.id.berber);


        musteri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musteriloginregister =new Intent(WelcomeActivity.this,RegisterActivity.class);
                startActivity(musteriloginregister);
            }
        });
        berber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent berberloginregister =new Intent(WelcomeActivity.this,BerberLoginRegisterActivity.class);
                startActivity(berberloginregister);
            }
        });


    }
}
