package models;

import Interfaces.ConverterMoeda;
import com.google.gson.annotations.SerializedName;

public class MoedaBrasileira extends Moeda implements ConverterMoeda {
    @SerializedName("BRL")
    float valorParaMultiplicar;

    public MoedaBrasileira() {
        super();
    }

    @Override
    public void mostrarValorConvertido() {
        System.out.println("O valor de " + getValue() + " " + getMoedaP()+ " em " + getMoedaS() + " é de: " + (this.valorParaMultiplicar*getValue()));
    }
}
