package com.example.saludaraccesoadatos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText texto, enlace;
    Button saludar,navegar;
    Intent i;

    public static final String DATO ="nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (EditText)findViewById(R.id.etxNombre);
        enlace = (EditText)findViewById(R.id.etxNavegar);
        saludar = (Button)findViewById(R.id.btnSaludar);
        navegar = (Button)findViewById(R.id.btnNavegar);
        saludar.setOnClickListener(this);
        navegar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnSaludar:
                i = new Intent (this, Segunda_Actividad.class);
                i.putExtra(DATO, texto.getText().toString());
                startActivity(i);
                break;
            case R.id.btnNavegar:
                if (enlace.getText().toString().substring(0,7) != "http://" || enlace.getText().toString().substring(0,8) != "https://") {
                    enlace.setText("http://" + enlace.getText().toString());
                }
                openWebPage(enlace.getText().toString());
            break;
        }
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
