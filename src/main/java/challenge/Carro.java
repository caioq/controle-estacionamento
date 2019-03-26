package challenge;

public class Carro {

    private Motorista motorista;

    private String placa;

    private Cor cor;

    public Carro(Motorista motorista, String placa, Cor cor) {
        this.motorista = motorista;
        this.placa = placa;
        this.cor = cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }
}
