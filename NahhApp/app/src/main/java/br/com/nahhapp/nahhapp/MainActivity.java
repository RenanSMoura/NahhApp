package br.com.nahhapp.nahhapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String json = "{\n"+
            "  \"menssagens\": {\n"+
            "    \"1\": \"Te amo\",\n"+
            "    \"2\": \"leao\",\n"+
            "    \"3\": \"cabeção\"\n"+
            "  }\n"+
            "}";
    TextView textoPadrao;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoPadrao = (TextView) findViewById(R.id.teste);

        button = (Button) findViewById(R.id.botao);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MudaMensagensActivity.class);
                startActivity(intent);

            }
        });
    }
}
