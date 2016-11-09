package br.com.nahhapp.nahhapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

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
//                String abc = "R.string.teste1";
//                textoPadrao.setText(getString(R.string.teste2));
//
//                try{
//                    JSONObject jsonObject = new JSONObject(json);
//                    Log.i("JSON",jsonObject.getJSONObject("menssagens").getString("1"));
//                }catch (Exception e){
//                    e.printStackTrace();
//                }

                Intent intent = new Intent(MainActivity.this,MudaMensagnsActivity.class);
                startActivity(intent);

            }
        });
    }
}
