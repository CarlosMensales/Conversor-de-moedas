import com.google.gson.Gson;
import models.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        /* moedas trabalhadas: EUR, BRL, USD, JPY, GBP */
        Scanner sc = new Scanner(System.in);
        String moedaPrincipal = "", moedaSecundaria = "";
        int opcao = 0;
        float value = 0;
        Gson gson = new Gson();
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
                7 - Libra para Iene
                8 - Iene para Libra
                9 - Won para Iene
                10 - Iene para Won
                
                11 - Sair
                
                
                *******************
                """;
        while(opcao != 11) {
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
                    moedaPrincipal = "GBP";
                    moedaSecundaria = "JPY";
                    break;

                case 8:
                    moedaPrincipal = "JPY";
                    moedaSecundaria = "GBP";
                    break;
                case 9:
                    moedaPrincipal = "KRW";
                    moedaSecundaria = "JPY";
                    break;
                case 10:
                    moedaPrincipal = "JPY";
                    moedaSecundaria = "KRW";
                    break;
                case 11:
                    break;

                default:
                    System.out.println("Digite uma opção válida!!!\n");
                    continue;



            }
            if (opcao == 11) break;

            System.out.println("Digite um valor para ser convertido: ");
            value = sc.nextFloat();

            String endereco = "https://v6.exchangerate-api.com/v6/3d8f887772b45abe317b4aa9/latest/" + moedaPrincipal;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Rates rates = gson.fromJson(json, Rates.class);
            Moeda moeda = new Moeda();
            moeda.setMoedaP(moedaPrincipal);
            moeda.setMoedaS(moedaSecundaria);
            moeda.setValue(value);
            moeda.setConversion_rate(rates.conversion_rates().get(moedaSecundaria));
            System.out.println(moeda);


        }

        System.out.println("Programa finalizado!!!");

        sc.close();
    }


}