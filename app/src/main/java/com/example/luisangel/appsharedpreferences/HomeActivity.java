package com.example.luisangel.appsharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView tvUsuario;
    private Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvUsuario = (TextView)findViewById(R.id.tvUsuario);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);
        SharedPreferences preferences = getSharedPreferences("appIDAT", MODE_PRIVATE);
        tvUsuario.setText(preferences.getString("usuario", ""));

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("appIDAT", MODE_PRIVATE).edit();

                editor.clear();
                editor.apply();

                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

            }
        });
    }
}
