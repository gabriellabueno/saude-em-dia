package br.edu.fatec.diariosaude.util;

public enum Nutricao {

    ABAIXO("BAIXO! Abaixo do peso",
            "Priorize alimentos nutritivos e calóricos e inclua uma fonte de proteína em todas as refeições. Combine carboidratos complexos com gorduras saudáveis, faça refeições menores e lanches frequentes. Consuma alimentos ricos em ferro, cálcio e vitamina B12."),
    NORMAL("Peso normal.",
            "Encha metade do prato com vegetais e frutas e prefira grãos integrais. Inclua proteínas magras, use gorduras saudáveis e limite açúcares e sal."),
    SOBREPESO("ALTO! Sobrepeso.",
            "Priorize alimentos de baixa densidade calórica e controle as porções. Consuma proteínas magras e laticínios com baixo teor de gordura, escolha grãos integrais. Evite açúcares e gorduras processadas, e aumente a atividade física."),
    OBESIDADE1("ALTO! Obesidade Grau I.",
            "Priorize alimentos ricos em fibras, substitua alimentos calóricos por opções saudáveis. Prefira fontes magras de proteína, evite gorduras e açúcares processados. Beba mais água e considere o acompanhamento de um nutricionista para um plano alimentar personalizado."),
    OBESIDADE2("ALTO! Obesidade Grau II.",
            "Consuma alimentos ricos em fibras, substitua opções calóricas por alternativas saudáveis. Inclua proteínas magras, evite açúcares e gorduras processadas. Beba mais água e considere o acompanhamento de um nutricionista para um plano alimentar personalizado."),
    OBESIDADE3("ALTO! Obesidade Grau III.",
            "Consuma alimentos ricos em fibras e mantenha a hidratação. Faça uma redução calórica rigorosa com opções leves, sempre sob supervisão. Evite açúcares e gorduras e busque acompanhamento multidisciplinar com nutricionista e médico.");

    private final String indice, nutricao;

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
