package com.example.berberuyg;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private  Button ClientLoginButton;
    private  Button ClientRegisterButton;
    private  TextView ClientRegisterLink;
    private  TextView ClientStatusTextView;
    private  EditText ClientEmailEditText;
    private  EditText ClientPasswordEditText;
    private ProgressDialog loadingBar1;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


            ClientLoginButton = (Button) findViewById(R.id.musteriloginButton);
            ClientRegisterButton = (Button) findViewById(R.id.registerButton);
            ClientRegisterLink = (TextView) findViewById(R.id.musteriregisterLink);
            ClientStatusTextView = (TextView) findViewById(R.id.musteriStatus);
            ClientEmailEditText = (EditText) findViewById(R.id.musteriEmail);
            ClientPasswordEditText = (EditText) findViewById(R.id.musteriPassword);

            firebaseAuth = FirebaseAuth.getInstance();

            loadingBar1 = new ProgressDialog(this);

            ClientRegisterButton.setVisibility(View.INVISIBLE);
            ClientRegisterButton.setEnabled(false);


            ClientRegisterLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ClientLoginButton.setVisibility(View.INVISIBLE);
                    ClientRegisterLink.setVisibility(View.INVISIBLE);
                    ClientStatusTextView.setText("Musteri Olarak Kaydolun");

                    ClientRegisterButton.setVisibility(View.VISIBLE);
                    ClientRegisterButton.setEnabled(true);


                }
            });

            ClientRegisterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = ClientEmailEditText.getText().toString();
                    String password = ClientPasswordEditText.getText().toString();

                    RegisterClient(email, password);

                }
            });

            ClientLoginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String email = ClientEmailEditText.getText().toString();
                    String password = ClientPasswordEditText.getText().toString();

                    LoginClient(email, password);

                }
            });

        };




        private void RegisterClient(String email, String password) {
            if(TextUtils.isEmpty(email)){
                Toast.makeText(RegisterActivity.this,"Lutfen Email'inizi Giriniz",Toast.LENGTH_SHORT).show();
            }
            if(TextUtils.isEmpty(password)){
                Toast.makeText(RegisterActivity.this,"Lutfen Sifrenizi Giriniz",Toast.LENGTH_SHORT).show();
            }
            else {

                loadingBar1.setTitle("Musteri Kaydi");
                loadingBar1.setMessage("Lutfen Kaydiniz Gerceklestirilirken Bekleyiniz");
                loadingBar1.show();

                firebaseAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(RegisterActivity.this,"  Kaydiniz Basariyla Gerceklesti",Toast.LENGTH_LONG).show();
                                    loadingBar1.dismiss();
                                }
                                else{
                                    Toast.makeText(RegisterActivity.this,"Kaydiniz Gerceklestirilimedi...Lutfen Tekrar Deneyin",Toast.LENGTH_LONG).show();
                                    loadingBar1.dismiss();
                                }
                            }
                        });
            }

        }

        private void LoginClient(String email, String password)
        {
            if(TextUtils.isEmpty(email)){
                Toast.makeText(RegisterActivity.this,"Lutfen Email'inizi Giriniz",Toast.LENGTH_SHORT).show();
            }
            if(TextUtils.isEmpty(password)){
                Toast.makeText(RegisterActivity.this,"Lutfen Sifrenizi Giriniz",Toast.LENGTH_SHORT).show();
            }
            else {

                loadingBar1.setTitle("Musteri Olarak Oturum Acin");
                loadingBar1.setMessage("Lutfen Oturum Acilirken Bekleyiniz");
                loadingBar1.show();

                firebaseAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Oturum Basariyla Acildi", Toast.LENGTH_LONG).show();
                                    loadingBar1.dismiss();
                                    Intent mainActivityIntent = new Intent(RegisterActivity.this,MainActivity.class);
                                    startActivity(mainActivityIntent);


                                } else {
                                    Toast.makeText(RegisterActivity.this, "Oturum Acilamadi ..Lutfen Tekrar Deneyin", Toast.LENGTH_LONG).show();
                                    loadingBar1.dismiss();
                                }
                            }
                        });
            }



        }
}
