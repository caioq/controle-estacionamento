package challenge;

import challenge.exceptions.EstacionamentoException;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Estacionamento {

    private final Integer VAGAS = 10;

    // Set collection - nao havera carros duplicados e ordenacao importa
    private LinkedHashSet<Carro> carros = new LinkedHashSet<>();

    public Integer getVAGAS() {
        return VAGAS;
    }

    public LinkedHashSet<Carro> getCarros() {
        return carros;
    }

    // estacionar
    public void estacionar(Carro carro) {
        // verifica se estacionamento esta cheio
        if (carros.size() >= getVAGAS()) {
            Iterator<Carro> itCarros = carros.iterator();

            while(itCarros.hasNext()){
                // verifica se primeiro carro a sair eh senior
                Motorista motor = itCarros.next().getMotorista();
                //if
            }
            //carros.iterator().remove();
            //throw new EstacionamentoException("Estacionamento cheio");
        }
        carros.add(carro);
    }

    // carro estacionado
    public Boolean carroEstacionado(Carro carro) {
        return true;
    }

    // carros estacionados
    public long carrosEstacionados() {
        return carros.size();
    }

    public static void main(String[] args) {
        Motorista motorista = Motorista.builder().withHabilitacao("CNH1").withIdade(24).withNome("Motor 1").withPontos(15).build();
        Motorista motorista2 = Motorista.builder().withHabilitacao("CNH2").withIdade(60).withNome("Motor 2").withPontos(21).build();
        Carro carro1 = Carro.builder().withCor(Cor.BRANCO).withPlaca("123").withMotorista(motorista).build();
        Carro carro2 = Carro.builder().withCor(Cor.BRANCO).withPlaca("1234").withMotorista(motorista2).build();

        LinkedHashSet<Carro> carros = new LinkedHashSet<>();
        carros.add(carro1);
        carros.add(carro2);

        Iterator<Carro> it = carros.iterator();
        while (it.hasNext())
            System.out.println(it.next().getPlaca());

    }
}
