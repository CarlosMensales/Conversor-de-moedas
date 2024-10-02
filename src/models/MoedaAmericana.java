package models;

import Interfaces.ConverterMoeda;
import com.google.gson.annotations.SerializedName;

public class MoedaAmericana extends Moeda implements ConverterMoeda {
    @SerializedName("USD")
    float valorParaMultiplicar;

    public MoedaAmericana() {
        super();
    }

    @Override
    public void mostrarValorConvertido() {
        System.out.println("O valor de " + getValue() + " " + getMoedaP()+ " em " + getMoedaS() + " é de: " + (this.valorParaMultiplicar*getValue()));
    }
}
