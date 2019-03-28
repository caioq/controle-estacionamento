package challenge;

public class Carro {

    private Motorista motorista;

    private String placa;

    private Cor cor;

    private Carro(Motorista motorista, String placa, Cor cor) {
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

    public static class CarroBuilder {
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
            if (placa == null) {
                throw new NullPointerException("A placa é obrigatório");
            }

            if (cor == null) {
                throw new NullPointerException("A cor é obrigatório");
            }

            if (motorista == null) {
                throw new EstacionamentoException("O motorista é obrigatório");
            }

            return new Carro(motorista, placa, cor);
        }
    }
}
