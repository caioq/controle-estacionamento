package challenge;

import java.util.Objects;

public class CarroBuilder {

    private Motorista motorista;

    private String placa;

    private Cor cor;

    public CarroBuilder withMotorista(Motorista motorista) {
        this.motorista = motorista;
        return this;
    }

    public CarroBuilder withPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public CarroBuilder withCor(Cor cor) {
        this.cor = cor;
        return this;
    }

    public Carro build() {
        Objects.requireNonNull(motorista, "O motorista é obrigatório");
        Objects.requireNonNull(placa, "A placa é obrigatório");
        Objects.requireNonNull(cor, "A cor é obrigatório");
        return new Carro(motorista, placa, cor);
    }


}
