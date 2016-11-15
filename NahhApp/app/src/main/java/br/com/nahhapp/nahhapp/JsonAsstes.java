package br.com.nahhapp.nahhapp;

/**
 * Created by Renan on 15/11/2016.
 */

public class JsonAsstes {



    private String jsonMensagens = "{\n"+
            "  \"mensagens\": {\n"+
            "    \"1\": \"Te amo\",\n"+
            "    \"2\": \"Leão\",\n"+
            "    \"3\": \"Cabeção\"\n"+
            "  }\n"+
            "}";

    private String  jsonCores = "{\n" +
            "  \"cores\": {\n" +
            "    \"0\": \"#c7b4b4\",\n" +
            "    \"1\": \"#096790\",\n" +
            "    \"2\": \"#c72828\",\n" +
            "    \"3\": \"#ffc125\",\n" +
            "    \"4\": \"#1ca154\",\n" +
            "    \"5\": \"#E80C7A\"\n" +
            "  }\n" +
            "}";

    public String getJsonMensagens() {
        return jsonMensagens;
    }

    public String getJsonCores() {
        return jsonCores;
    }
}
