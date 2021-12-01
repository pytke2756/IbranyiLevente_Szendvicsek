package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnKeres, btnUj;
    private EditText edtAr;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnUj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insert = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(insert);
                finish();
            }
        });

        btnKeres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ar = edtAr.getText().toString().trim();
                if (ar.equals("")){
                    Toast.makeText(MainActivity.this, "Nem hagyhatod üresen a mezőt!", Toast.LENGTH_SHORT).show();
                }
                else if (Integer.parseInt(ar) < 0){
                    Toast.makeText(MainActivity.this, "Nem lehet nullánál kisebb érték!", Toast.LENGTH_SHORT).show();
                }
                else{
                    editor.putString("ar", ar);
                    boolean help = editor.commit();
                    Log.d("Sikeres feltöltés", "" +help);
                    Intent search = new Intent(MainActivity.this, SearchResultActivity.class);
                    startActivity(search);
                    finish();

                }
            }
        });
    }

    private void init(){
        btnKeres = findViewById(R.id.btn_keres);
        btnUj = findViewById(R.id.btn_uj);
        edtAr = findViewById(R.id.edt_ar);
        sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
}