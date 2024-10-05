package models;

public class Moeda {
    private Float value;
    private String moedaS;
    private String moedaP;
    private Float conversion_rate;

    public Float getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(Float conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }



    public String getMoedaS() {
        return moedaS;
    }

    public void setMoedaS(String moedaS) {
        this.moedaS = moedaS;
    }

    public String getMoedaP() {
        return moedaP;
    }

    public void setMoedaP(String moedaP) {
        this.moedaP = moedaP;
    }



    public Float CalculaAConveersao() {
        try {
            return (getConversion_rate() * getValue());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "O valor de: " + String.format("%.2f", getValue()) + " " + getMoedaP() + " em " + getMoedaS() + " é: " + String.format("%.2f", CalculaAConveersao());
    }
}
