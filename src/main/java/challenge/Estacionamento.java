package challenge;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
        carros.add(carro);
    }

    // carro estacionado
    public Boolean carroEstacionado(Carro carro) {
        return true;
    }

    // carros estacionados
    public Integer carrosEstacionados() {
        return carros.size();
    }

}
