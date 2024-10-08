package models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {
     Gson gson = new Gson();

    public static Rates Conectar(String moedaPrincipal) throws Exception {
        String endereco = "https://v6.exchangerate-api.com/v6/3d8f887772b45abe317b4aa9/latest/" + moedaPrincipal;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            return gson.fromJson(response.body(), Rates.class);
        } else {
            throw new Exception("Falha ao obter a resposta da API. Código de status: " + response.statusCode());
        }
    }
}
