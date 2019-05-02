package com.example.berberuyg;

import android.app.ProgressDialog;
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

public class BerberLoginRegisterActivity extends AppCompatActivity {

    private Button BarberLoginButton;
    private Button BarberRegisterButton;
    private TextView BarberRegisterLink;
    private TextView BarberStatusTextView;
    private EditText BarberEmailEditText;
    private EditText BarberPasswordEditText;
    private ProgressDialog loadingBar;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berber_login_register);

        BarberLoginButton =(Button) findViewById(R.id.driverloginButton);
        BarberRegisterButton =(Button) findViewById(R.id.registerButton);
        BarberRegisterLink =(TextView) findViewById(R.id.driverregisterLink);
        BarberStatusTextView =(TextView) findViewById(R.id.driverStatus);
        BarberEmailEditText =(EditText)findViewById(R.id.driverEmail);
        BarberPasswordEditText =(EditText) findViewById(R.id.driverPassword);

        firebaseAuth =FirebaseAuth.getInstance();

        loadingBar = new ProgressDialog(this);

        BarberRegisterButton.setVisibility(View.INVISIBLE);
        BarberRegisterButton.setEnabled(false);


        BarberRegisterLink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                BarberLoginButton.setVisibility(View.INVISIBLE);
                BarberRegisterLink.setVisibility(View.INVISIBLE);
                BarberStatusTextView.setText("Berber İşletmesi Olarak Kaydolun");

                BarberRegisterButton.setVisibility(View.VISIBLE);
                BarberRegisterButton.setEnabled(true);


            }
        });

        BarberRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = BarberEmailEditText.getText().toString();
                String password =BarberPasswordEditText.getText().toString();

                RegisterBarber(email,password);
                
            }
        });

        BarberLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = BarberEmailEditText.getText().toString();
                String password =BarberPasswordEditText.getText().toString();

                LoginBarber(email,password);

            }
        });

    }



    private void RegisterBarber(String email, String password) {
        if(TextUtils.isEmpty(email)){
            Toast.makeText(BerberLoginRegisterActivity.this,"Lutfen Email'inizi Giriniz",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(BerberLoginRegisterActivity.this,"Lutfen Şifrenizi Giriniz",Toast.LENGTH_SHORT).show();
        }
        else {

            loadingBar.setTitle("Berber Kaydı");
            loadingBar.setMessage("Lutfen Kaydınız Yapılırken Bekleyiniz");
            loadingBar.show();

            firebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(BerberLoginRegisterActivity.this,"  Kaydınız Basariyla Gerceklesti",Toast.LENGTH_LONG).show();
                                loadingBar.dismiss();
                            }
                            else{
                                Toast.makeText(BerberLoginRegisterActivity.this,"Kaydınız Gerceklestirilimedi...Lutfen Tekrar Deneyin",Toast.LENGTH_LONG).show();
                                loadingBar.dismiss();
                            }
                        }
                    });
        }

    }

    private void LoginBarber(String email, String password)
    {
        if(TextUtils.isEmpty(email)){
            Toast.makeText(BerberLoginRegisterActivity.this,"Lutfen Email'inizi Giriniz",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(BerberLoginRegisterActivity.this,"Lutfen Şifrenizi Giriniz",Toast.LENGTH_SHORT).show();
        }
        else {

            loadingBar.setTitle("Berber Oturumu Acin");
            loadingBar.setMessage("Lutfen Oturum Acilirken Bekleyiniz");
            loadingBar.show();

            firebaseAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(BerberLoginRegisterActivity.this,"Oturum Basariyla Acildi",Toast.LENGTH_LONG).show();
                                loadingBar.dismiss();
                            }
                            else{
                                Toast.makeText(BerberLoginRegisterActivity.this,"Oturum Acilamadi ..Lutfen Tekrar Deneyin",Toast.LENGTH_LONG).show();
                                loadingBar.dismiss();
                            }
                        }
                                });
                                }



                }
    }
