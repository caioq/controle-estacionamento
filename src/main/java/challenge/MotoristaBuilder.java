package challenge;

import java.util.Objects;

public class MotoristaBuilder {

    private String nome;

    private Integer idade;

    private Integer pontos;

    private String habilitacao;

    public MotoristaBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public MotoristaBuilder withIdade(Integer idade) {
        if(idade < 0){
            throw new IllegalArgumentException("Idade deve ser positivo.");
        }
        this.idade = idade;
        return this;
    }

    public MotoristaBuilder withPontos(Integer pontos) {
        if(pontos < 0){
            throw new IllegalArgumentException("Pontos deve ser positivo.");
        }
        this.pontos = pontos;
        return this;
    }

    public MotoristaBuilder withHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
        return this;
    }

    public Motorista build() {
        Objects.requireNonNull(nome, "O nome é obrigatório.");
        Objects.requireNonNull(idade, "A idade é obrigatória.");
        Objects.requireNonNull(pontos, "Os pontos do motoristas são obrigatórios.");
        Objects.requireNonNull(habilitacao, "O número de habilitação são obrigatórios.");
        return new Motorista(nome, idade, pontos, habilitacao);
    }
}
