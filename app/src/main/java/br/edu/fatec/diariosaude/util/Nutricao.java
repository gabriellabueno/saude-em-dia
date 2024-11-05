package br.edu.fatec.diariosaude.util;

public enum Nutricao {

    ABAIXO("IMC BAIXO! Abaixo do peso",
            "Para ganhar peso de forma saudável, priorize alimentos nutritivos e calóricos. \nInclua uma fonte de proteína em todas as refeições, combine carboidratos complexos com gorduras saudáveis, faça refeições menores e lanches frequentes. \nConsuma alimentos ricos em ferro, cálcio e vitamina B12."),
    NORMAL("Peso normal.",
            "Para manter o peso e uma nutrição equilibrada, encha metade do prato com vegetais e frutas. \nPrefira grãos integrais, inclua proteínas magras, use gorduras saudáveis e limite açúcares e sal."),
    SOBREPESO("IMC ALTO! Sobrepeso.",
            "Para manter ou reduzir o peso, priorize alimentos de baixa densidade calórica e controle as porções. \nConsuma proteínas magras e laticínios com baixo teor de gordura, escolha grãos integrais, evite açúcares e gorduras processadas, e aumente a atividade física."),
    OBESIDADE1("IMC ALTO! Obesidade Grau I.",
            "Para reduzir o peso de forma gradual e saudável, priorize alimentos ricos em fibras, reduza a ingestão calórica substituindo alimentos calóricos por opções saudáveis, prefira fontes magras de proteína, evite gorduras e açúcares processados, aumente a hidratação com água e considere o acompanhamento de um nutricionista para um plano alimentar personalizado."),
    OBESIDADE2("IMC ALTO! Obesidade Grau II.",
            "Para reduzir o peso de forma gradual e saudável, consuma alimentos ricos em fibras, substitua opções calóricas por alternativas saudáveis e de baixo teor calórico, inclua proteínas magras, evite açúcares e gorduras processadas, aumente a ingestão de água e considere o acompanhamento de um nutricionista para um plano alimentar personalizado."),
    OBESIDADE3("IMC ALTO! Obesidade Grau III.",
            "Para reduzir o peso de forma estruturada e supervisionada, consuma alimentos ricos em fibras e mantenha a hidratação; faça uma redução calórica rigorosa com opções leves, sempre sob supervisão; evite açúcares e gorduras e busque acompanhamento multidisciplinar com nutricionista e médico para um plano seguro, considerando tratamentos adicionais quando necessário.");

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
