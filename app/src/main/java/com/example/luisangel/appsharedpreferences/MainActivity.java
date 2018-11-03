package com.example.luisangel.appsharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etUsuario, etPassword;
    private Button btnIniciar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsuario = (EditText)findViewById(R.id.etUsuario);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnIniciar = (Button)findViewById(R.id.btnIniciar);

        SharedPreferences preferences = getSharedPreferences("appIDAT", MODE_PRIVATE);

        if(preferences.contains("usuario")){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String password = etPassword.getText().toString();
                SharedPreferences.Editor editor = getSharedPreferences  ("appIDAT", MODE_PRIVATE).edit();
                editor.putString("usuario", usuario);
                editor.putString("password", password);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
