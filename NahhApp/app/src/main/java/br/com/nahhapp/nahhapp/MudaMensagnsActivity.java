package br.com.nahhapp.nahhapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Random;

public class MudaMensagnsActivity extends AppCompatActivity {

    ImageButton btnAvancar;
    ImageButton btnVoltar;
    ImageButton btnRandom;
    TextView    mainText;
    TextView    codeHash;
    int         value = 0;

    String json = "{\n"+
            "  \"mensagens\": {\n"+
            "    \"1\": \"Te amo\",\n"+
            "    \"2\": \"leao\",\n"+
            "    \"3\": \"cabeção\"\n"+
            "  }\n"+
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muda_mensagns);

        btnAvancar = (ImageButton) findViewById(R.id.avancar);
        btnVoltar  = (ImageButton) findViewById(R.id.voltar);
        btnRandom  = (ImageButton) findViewById(R.id.random);
        mainText   = (TextView) findViewById(R.id.main_text);
        codeHash   = (TextView) findViewById(R.id.number_hash);

        btnAvancar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                verifica(v);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                verifica(v);
            }
        });

        btnRandom.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                verifica(v);
            }
        });


    }

    private void verifica(View view){
        switch (view.getId()){
            case R.id.avancar:
                value++;
                alterarTexto(value);
                break;
            case R.id.voltar:
                value--;
                alterarTexto(value);
                break;
            case R.id.random:
                alterarTexto(getRandomValue(value));
                break;
        }


    }

    private void alterarTexto(int valor){
        try{
            JSONObject jsonObject = new JSONObject(json);
            mainText.setText(jsonObject.getJSONObject("mensagens").getString(String.valueOf(valor)));
            codeHash.setText(String.valueOf(valor));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private int getRandomValue(int valor){
        int randomNumber = valor;
        while (valor == randomNumber){
            randomNumber = new Random().nextInt(101);
        }
        value = randomNumber;
        return randomNumber;
    }

}
