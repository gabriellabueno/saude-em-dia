package br.edu.fatec.diariosaude.util;

public enum Nutricao {

    ABAIXO("IMC BAIXO! Abaixo do peso",
            "Priorize alimentos nutritivos e calóricos e inclua uma fonte de proteína em todas as refeições. \nCombine carboidratos complexos com gorduras saudáveis, faça refeições menores e lanches frequentes. \nConsuma alimentos ricos em ferro, cálcio e vitamina B12."),
    NORMAL("Peso normal.",
            "Encha metade do prato com vegetais e frutas e prefira grãos integrais. \nInclua proteínas magras, use gorduras saudáveis e limite açúcares e sal."),
    SOBREPESO("IMC ALTO! Sobrepeso.",
            "Priorize alimentos de baixa densidade calórica e controle as porções. \nConsuma proteínas magras e laticínios com baixo teor de gordura, escolha grãos integrais. \nEvite açúcares e gorduras processadas, e aumente a atividade física."),
    OBESIDADE1("IMC ALTO! Obesidade Grau I.",
            "Priorize alimentos ricos em fibras, substitua alimentos calóricos por opções saudáveis. \nPrefira fontes magras de proteína, evite gorduras e açúcares processados. \nBeba mais água e considere o acompanhamento de um nutricionista para um plano alimentar personalizado."),
    OBESIDADE2("IMC ALTO! Obesidade Grau II.",
            "Consuma alimentos ricos em fibras, substitua opções calóricas por alternativas saudáveis. \nInclua proteínas magras, evite açúcares e gorduras processadas. \nBeba mais água e considere o acompanhamento de um nutricionista para um plano alimentar personalizado."),
    OBESIDADE3("IMC ALTO! Obesidade Grau III.",
            "Consuma alimentos ricos em fibras e mantenha a hidratação. \nFaça uma redução calórica rigorosa com opções leves, sempre sob supervisão. \nEvite açúcares e gorduras e busque acompanhamento multidisciplinar com nutricionista e médico.");

    private final String indice;
    private final String nutricao;

    private Nutricao(String indice, String message) {
        this.indice = indice;
        this.nutricao = message;
    }

    public String getIndice() {
        return indice;
    }

    public String getNutricao() {
        return nutricao;
    }

}
