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
        // valida obrigacoes minimas para estacionar
        if (carro.getMotorista().getIdade() < 18) {
            throw new EstacionamentoException("Motorista é menor de idade.");
        }
        if (carro.getMotorista().getPontos() > 20) {
            throw new EstacionamentoException("Motorista com mais de 20 pontos.");
        }
        // verifica se estacionamento esta cheio
        if (carros.size() >= getVAGAS()) {
            Iterator<Carro> itCarros = carros.iterator();

            while (itCarros.hasNext()) {
                // verifica se primeiro carro a sair eh senior
                Carro carroEstacionado = itCarros.next();
                Motorista motor = carroEstacionado.getMotorista();
                if (motor.getIdade() < 55) {

                    carros.remove(carroEstacionado);
                    carros.add(carro);
                    return;

                }
            }
            // estacionamento cheio
            throw new EstacionamentoException("Estacionamento cheio");
        }
        carros.add(carro);
    }

    // carro estacionado
    public Boolean carroEstacionado(Carro carro) {
        Iterator<Carro> itCarros = carros.iterator();
        while (itCarros.hasNext()) {
            if (itCarros.next() == carro) {
                return true;
            }
        }
        return false;
    }

    // carros estacionados
    public long carrosEstacionados() {
        return carros.size();
    }

}
