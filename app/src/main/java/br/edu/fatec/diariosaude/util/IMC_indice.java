package br.edu.fatec.diariosaude.util;

public enum IMC_indice {

    ABAIXO("IMC BAIXO! Abaixo do peso"),
    NORMAL("Peso normal"),
    SOBREPESO("IMC ALTO! Sobrepeso"),
    OBESIDADE("IMC ALTO!Obesidade"),
    OBESIDADE1("IMC ALTO!Obesidade Grau I"),
    OBESIDADE2("IMC ALTO!Obesidade Grau II"),
    OBESIDADE3("IMC ALTO!Obesidade Grau III");

    private final String message;

    private IMC_indice (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
