package br.com.nahhapp.nahhapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class MudaMensagensActivity extends AppCompatActivity {

    private ImageButton btnAvancar;
    private ImageButton btnVoltar;
    private ImageButton btnRandom;
    private TextView    mainText;
    private TextView    codeHash;
    private int         value;
    private RelativeLayout mudaMensagemActivity;
    private JSONObject jsonObject = null;

    String json = "{\n"+
            "  \"mensagens\": {\n"+
            "    \"0\": \"Te amo\",\n"+
            "    \"1\": \"Leão\",\n"+
            "    \"2\": \"Cabeção\"\n"+
            "  }\n"+
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muda_mensagens);

        btnAvancar = (ImageButton) findViewById(R.id.avancar);
        btnVoltar  = (ImageButton) findViewById(R.id.voltar);
        btnRandom  = (ImageButton) findViewById(R.id.random);
        mainText   = (TextView) findViewById(R.id.main_text);
        codeHash   = (TextView) findViewById(R.id.number_hash);


        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/jambo.otf");
        mainText.setTypeface(font);
        codeHash.setTypeface(font);

        insereValoresIniciais();

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

                if(value ==2){
                    value = 2;
                }else{
                    value++;
                    alterarTexto(value);
                }

                break;
            case R.id.voltar:
                if(value == 0){
                    value = 0;
                }else{
                    value--;
                    alterarTexto(value);
                }

                break;
            case R.id.random:
                alterarTexto(getRandomValue(value));
                break;
        }
        alterarBackGround();
    }

    private void alterarTexto(int valor){
        try{
            mainText.setText(jsonObject.getJSONObject("mensagens").getString(String.valueOf(valor)));
            codeHash.setText("#" + String.valueOf(valor));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private int getRandomValue(int valor){
        int randomNumber = valor;
        while (valor == randomNumber){
            randomNumber = new Random().nextInt(100);
        }
        Log.v("Cor", "Numero do texto" + randomNumber);
        value = randomNumber;
        return randomNumber;
    }
    private void alterarBackGround(){
        mudaMensagemActivity = (RelativeLayout) findViewById(R.id.activity_muda_mensagns);
        String  jsonCores = "{\n" +
                "  \"cores\": {\n" +
                "    \"0\": \"#c7b4b4\",\n" +
                "    \"1\": \"#096790\",\n" +
                "    \"2\": \"#c72828\",\n" +
                "    \"3\": \"#ffc125\",\n" +
                "    \"4\": \"#1ca154\",\n" +
                "    \"5\": \"#E80C7A\"\n" +
                "  }\n" +
                "}";

        int randomNumber = new Random().nextInt(6);
        Log.v("Cor", "Numero da cor" + randomNumber);

        try {
            JSONObject jsonObject = new JSONObject(jsonCores);
            mudaMensagemActivity.setBackgroundColor(Color.parseColor(
                    jsonObject.getJSONObject("cores").getString(
                    String.valueOf(randomNumber))));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void insereValoresIniciais(){
        try {
            jsonObject = new JSONObject(json);
            mainText.setText(jsonObject.getJSONObject("mensagens").getString(String.valueOf(0)));
            codeHash.setText("#" + String.valueOf(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
