package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    private Button btnFevetel, btnVisszaInsertMain;
    private EditText edtNev, edtLeiras, edtIdo, edtInsertAr;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        init();

        btnVisszaInsertMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visszaMain = new Intent(InsertActivity.this, MainActivity.class);
                startActivity(visszaMain);
                finish();
            }
        });

        btnFevetel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nev = edtNev.getText().toString().trim();
                String leiras = edtLeiras.getText().toString().trim();
                String ido =  edtIdo.getText().toString().trim();
                String ar = edtInsertAr.getText().toString().trim();

                if (nev.isEmpty() || ido.isEmpty() || ar.isEmpty()){
                    Toast.makeText(getApplicationContext(), "A leíráson kívül kötelező mindent kitolteni!", Toast.LENGTH_SHORT).show();
                }else{
                }

            }
        });
    }

    private void init(){
        btnFevetel = findViewById(R.id.btn_fevetel);
        btnVisszaInsertMain = findViewById(R.id.btn_vissza_insert_main);
        edtNev = findViewById(R.id.edt_nev);
        edtLeiras = findViewById(R.id.edt_leiras);
        edtIdo = findViewById(R.id.edt_ido);
        edtInsertAr = findViewById(R.id.edt_insert_ar);

    }
}