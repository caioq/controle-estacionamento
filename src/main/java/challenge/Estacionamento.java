package challenge;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.Set;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Estacionamento {

    private final Integer VAGAS = 10;

    // Set collection - nao havera carros duplicados e ordenacao importa
    private Set<Carro> carros = new LinkedHashSet<>();

    public Integer getVAGAS() {
        return VAGAS;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    // estacionar
    public void estacionar(Carro carro) {
        // verifica se estacionamento esta cheio
        if (carros.size() >= getVAGAS()) {
            Iterator<Carro> itCarros = carros.iterator();

            while(itCarros.hasNext()){
                // verifica se primeiro carro a sair eh senior
                Carro carroEstacionado = itCarros.next();
                Motorista motor = carroEstacionado.getMotorista();
                if(motor.getIdade() < 55){
                    if(validarMotorista(motor)){
                        carros.remove(carroEstacionado);
                        carros.add(carro);
                        return;
                    }
                }
            }
            // estacionamento cheio
            throw new EstacionamentoException("Estacionamento cheio");
        }
        if(validarMotorista(carro.getMotorista())){
            carros.add(carro);
        }
    }

    // carro estacionado
    public Boolean carroEstacionado(Carro carro) {
        Iterator<Carro> itCarros = carros.iterator();
        while(itCarros.hasNext()){
            if(itCarros.next() == carro) {
                return true;
            }
        }
        return false;
    }

    // carros estacionados
    public long carrosEstacionados() {
        return carros.size();
    }

    public Boolean validarMotorista(Motorista motorista) {
        if(motorista.getIdade() < 18){
            throw new EstacionamentoException("Motorista é menor de idade.");
        }
        if(motorista.getPontos() > 20) {
            throw new EstacionamentoException("Motorista com mais de 20 pontos.");
        }

        return true;
    }

    public static void main(String[] args) {
//        Motorista motorista = Motorista.builder().withHabilitacao("CNH1").withIdade(24).withNome("Motor 1").withPontos(15).build();
//        Motorista motorista2 = Motorista.builder().withHabilitacao("CNH2").withIdade(60).withNome("Motor 2").withPontos(21).build();
//        Carro carro1 = Carro.builder().withCor(Cor.BRANCO).withPlaca("123").withMotorista(motorista).build();
//        Carro carro2 = Carro.builder().withCor(Cor.BRANCO).withPlaca("1234").withMotorista(motorista2).build();
//
          //LinkedHashSet<Carro> carros = new LinkedHashSet<>();
//        carros.add(carro1);
//        carros.add(carro2);

        Estacionamento estacionamento = new Estacionamento();

        Motorista ada = Motorista.builder().withNome("Ada").withIdade(20)
                .withPontos(3)
                .withHabilitacao("11111")
                .build();

        Carro carroBranco = Carro.builder().withCor(Cor.BRANCO).
                withPlaca("11111")
                .withMotorista(ada)
                .build();

        estacionamento.estacionar(carroBranco);

        for (int indice = 1; indice <= 10; indice++) {

            Motorista motorista = Motorista.builder()
                    .withNome("Motorista " + indice)
                    .withIdade(20)
                    .withPontos(3)
                    .withHabilitacao(Long.toString(current().nextLong()))
                    .build();

            Carro carro = Carro.builder().withCor(Cor.BRANCO).
                    withPlaca(indice + "123")
                    .withMotorista(motorista)
                    .build();

            estacionamento.estacionar(carro);
        }


        Iterator<Carro> it = estacionamento.carros.iterator();
        while (it.hasNext())
            System.out.println(it.next().getPlaca());

    }
}
