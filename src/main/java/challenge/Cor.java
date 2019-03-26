package challenge;

import java.util.function.Supplier;

public enum Cor implements Supplier<String> {
    BRANCO("Branco"), PRETO("Preto"), COLORIDO("Colorido");

    private final String cor;

    Cor(String cor) {
        this.cor = cor;
    }

    @Override
    public String get() {
        return cor;
    }
}
