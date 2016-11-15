package br.com.nahhapp.nahhapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
    private int         value = 1;
    private RelativeLayout mudaMensagemActivity;
    private JsonAsstes jsonAsstes;
    private JSONObject jsonObject = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jsonAsstes = new JsonAsstes();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
                if(value ==3){
                    value = 3;
                }else{
                    value++;
                    alterarTexto(value);
                }

                break;
            case R.id.voltar:
                value--;
                if(value == 0){
                    value = 1;
                }
                alterarTexto(value);
                break;
            case R.id.random:
                alterarTexto(getRandomValue(value));
                break;
        }
        alterarBackGround();
    }

    private void alterarTexto(int valor){
        try{
            jsonObject = new JSONObject(jsonAsstes.getJsonMensagens());
            mainText.setText(jsonObject.getJSONObject("mensagens").getString(String.valueOf(valor)));
            codeHash.setText("#" + String.valueOf(valor));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private int getRandomValue(int valor){

        int randomNumber = valor;

        while (valor == randomNumber) {
            randomNumber = new Random().nextInt(100);
        }

        value = randomNumber;

        return randomNumber;
    }

    private void alterarBackGround(){
        mudaMensagemActivity = (RelativeLayout) findViewById(R.id.activity_muda_mensagns);

        int randomNumber = new Random().nextInt(6);

        try {
            JSONObject jsonObject = new JSONObject(jsonAsstes.getJsonCores());
            mudaMensagemActivity.setBackgroundColor(Color.parseColor(
                    jsonObject.getJSONObject("cores").
                            getString(String.valueOf(randomNumber))));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void insereValoresIniciais(){
        try {
            jsonObject = new JSONObject(jsonAsstes.getJsonMensagens());
            mainText.setText(jsonObject.getJSONObject("mensagens").getString(String.valueOf(1)));
            codeHash.setText("#" + String.valueOf(1));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
