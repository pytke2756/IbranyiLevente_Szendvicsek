package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity {

    private TextView txtvOsszes;
    private Button btnVisszaMain;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        init();
        listaz();

        btnVisszaMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visszaMain = new Intent(SearchResultActivity.this, MainActivity.class);
                startActivity(visszaMain);
                finish();
            }
        });
    }
    private void init(){
        txtvOsszes = findViewById(R.id.txtv_osszes);
        btnVisszaMain = findViewById(R.id.btn_vissza_main);
    }

    private void listaz(){
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        Log.d("asd", "asd");
        String ar = sharedPreferences.getString("ar", "0");
        Cursor listaz = db.listaz(ar);

        int stmtDb = listaz.getCount();
        if (stmtDb == 0){
            String hiba = String.format("Nincs ilyen olcsó szendvics: %s", ar);
            txtvOsszes.setText(hiba);
        }

    }

}