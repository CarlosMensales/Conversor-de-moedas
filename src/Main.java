import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        /* moedas trabalhadas: EUR, BRL, USD, JPY */
        Scanner sc = new Scanner(System.in);
        String moedaPrincipal = "", moedaSecundaria = "";
        int opcao = 0;
        float value = 0;
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        String menu =
                """
                *******************
                
                Escolha uma das opções seguintes para converter o valor da moeda:
                
                1 - Real para Iene
                2 - Iene para Real
                3 - Euro para Iene
                4 - Iene para Euro
                5 - Dólar para Iene
                6 - Iene para Dólar 
                
                7 - Sair
                
                
                *******************
                """;
        while(opcao != 7) {
            System.out.println(menu);
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    moedaPrincipal = "BRL";
                    moedaSecundaria = "JPY";
                    break;
                case 2:
                    moedaPrincipal = "JPY";
                    moedaSecundaria = "BRL";
                    break;
                case 3:
                    moedaPrincipal = "EUR";
                    moedaSecundaria = "JPY";
                    break;
                case 4:
                    moedaPrincipal = "JPY";
                    moedaSecundaria = "EUR";
                    break;
                case 5:
                    moedaPrincipal = "USD";
                    moedaSecundaria = "JPY";
                    break;
                case 6:
                    moedaPrincipal = "JPY";
                    moedaSecundaria = "USD";
                    break;
                case 7:
                    break;

                default:
                    System.out.println("Digite uma opção válida!!!\n");
                    continue;



            }
            if (opcao == 7) break;

            System.out.println("Digite um valor para ser convertido: ");
            value = sc.nextFloat();

            String endereco = "https://v6.exchangerate-api.com/v6/3d8f887772b45abe317b4aa9/latest/" + moedaPrincipal;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            switch (moedaSecundaria) {
                case "BRL":
                    MoedaBrasileira moeda = new MoedaBrasileira();
                    moeda.setMoedaP(moedaPrincipal);
                    moeda.setMoedaS(moedaSecundaria);
                    moeda.setValue(value);
                    moeda = gson.fromJson(json, MoedaBrasileira.class);
                    moeda.mostrarValorConvertido();
                case "JPY":
                    MoedaJaponesa moeda1 = new MoedaJaponesa();
                    moeda1.setMoedaP(moedaPrincipal);
                    moeda1.setMoedaS(moedaSecundaria);
                    moeda1.setValue(value);
                    moeda1 = gson.fromJson(json, MoedaJaponesa.class);
                    moeda1.mostrarValorConvertido();
                case "EUR":
                    MoedaEuropeia moeda2 = new MoedaEuropeia();
                    moeda2.setMoedaP(moedaPrincipal);
                    moeda2.setMoedaS(moedaSecundaria);
                    moeda2.setValue(value);
                    moeda2 = gson.fromJson(json, MoedaEuropeia.class);
                    moeda2.mostrarValorConvertido();
                case "USD":
                    MoedaAmericana moeda3 = new MoedaAmericana();
                    moeda3.setMoedaP(moedaPrincipal);
                    moeda3.setMoedaS(moedaSecundaria);
                    moeda3.setValue(value);
                    moeda3 = gson.fromJson(json, MoedaAmericana.class);
                    moeda3.mostrarValorConvertido();
            }




        }

        System.out.println("Programa finalizado!!!");

        sc.close();
    }


}