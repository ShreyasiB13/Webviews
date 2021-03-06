package com.example.languagepreferences;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import static com.example.languagepreferences.R.*;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    TextView textView;

    @Override
    public boolean  onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(androidx.activity.R.Menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        super.onOptionsItemSelected(item);
//
//        if (item.getItemId() == id.english) {
//
//            setLanguage("English");
//
//        } else if (item.getItemId() == id.spanish) {
//
//            setLanguage("Spanish");
//
//        }
//
//        return true;
//
//    }

    public void setLanguage(String language) {

        sharedPreferences.edit().putString("language", language).apply();

        textView.setText(language);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        sharedPreferences = this.getSharedPreferences("com.example.mike.languagepreferences", Context.MODE_PRIVATE);

        textView = (TextView) findViewById(id.textView);

        String language = sharedPreferences.getString("language", "");

        if (language == "") {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_btn_speak_now)
                    .setTitle("Choose a language")
                    .setMessage("Which language would you like?")
                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            setLanguage("English");

                        }

                    })
                    .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            setLanguage("Spanish");

                        }
                    })
                    .show();
        } else {

            textView.setText(language);

        }
    }
}
