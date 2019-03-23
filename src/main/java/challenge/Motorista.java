package challenge;

public class Motorista {

    private String nome;

    private Integer idade;

    private Integer pontos;

    private String habilitacao;

    public Motorista(String nome, Integer idade, Integer pontos, String habilitacao) {
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }
}
