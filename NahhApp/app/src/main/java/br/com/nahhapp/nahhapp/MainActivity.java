package br.com.nahhapp.nahhapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import android.widget.TextView;

import static android.view.WindowManager.*;

public class MainActivity extends AppCompatActivity {


    TextView textoPrincipal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                LayoutParams.FLAG_FULLSCREEN,
                LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        textoPrincipal = (TextView) findViewById(R.id.main_text);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/jambo.otf");

        textoPrincipal.setTypeface(font);

        textoPrincipal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MudaMensagensActivity.class);
                startActivity(i);
            }
        });
    }

}
