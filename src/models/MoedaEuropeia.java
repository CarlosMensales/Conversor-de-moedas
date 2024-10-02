package models;

import Interfaces.ConverterMoeda;
import com.google.gson.annotations.SerializedName;

public class MoedaEuropeia extends Moeda implements ConverterMoeda {
    @SerializedName("EUR")
    float valorParaMultiplicar;

    public MoedaEuropeia () {
        super();
    }

    @Override
    public void mostrarValorConvertido() {
        System.out.println("O valor de " + getValue() + " " + getMoedaP()+ " em " + getMoedaS() + " é de: " + (this.valorParaMultiplicar*getValue()));
    }
}
