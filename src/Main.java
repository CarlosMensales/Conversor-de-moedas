import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* moedas trabalhadas: EUR, BRL, USD, JPY */
        Scanner sc = new Scanner(System.in);
        String moedaPrincipal, moedaSecundaria;
        int opcao = 0;
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
            }
            Classe exemploClasse.converterMoeda(moedaPrincipal, moedaSecundaria);
            break
        }

        sc.close();
    }


}