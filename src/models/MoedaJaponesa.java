package models;

import Interfaces.ConverterMoeda;
import com.google.gson.annotations.SerializedName;

public class MoedaJaponesa extends Moeda implements ConverterMoeda {
    @SerializedName("JPY")
    float valorParaMultiplicar;

    public MoedaJaponesa() {
        super();
    }


    @Override
    public void mostrarValorConvertido() {
        System.out.println("O valor de " + getValue() + " " + getMoedaP()+ " em " + getMoedaS() + " é de: " + (this.valorParaMultiplicar*getValue()));
    }
}
