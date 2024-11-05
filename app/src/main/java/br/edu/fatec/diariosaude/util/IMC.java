package br.edu.fatec.diariosaude.util;

public enum IMC {

    ABAIXO("Para ganhar peso de forma saudável, priorize alimentos nutritivos e calóricos, inclua uma fonte de proteína em todas as refeições, combine carboidratos complexos com gorduras saudáveis, faça refeições menores e lanches frequentes e consuma alimentos ricos em ferro, cálcio e vitamina B12."),
    NORMAL("Para manter o peso e uma nutrição equilibrada, encha metade do prato com vegetais e frutas, prefira grãos integrais, inclua proteínas magras, use gorduras saudáveis e limite açúcares e sal."),
    SOBREPESO("Para manter ou reduzir o peso, priorize alimentos de baixa densidade calórica, controle as porções, consuma proteínas magras e laticínios com baixo teor de gordura, escolha grãos integrais, evite açúcares e gorduras processadas, e aumente a atividade física."),
    OBESIDADE1("Para reduzir o peso de forma gradual e saudável, priorize alimentos ricos em fibras, reduza a ingestão calórica substituindo alimentos calóricos por opções saudáveis, prefira fontes magras de proteína, evite gorduras e açúcares processados, aumente a hidratação com água e considere o acompanhamento de um nutricionista para um plano alimentar personalizado."),
    OBESIDADE2("Para reduzir o peso de forma gradual e saudável, consuma alimentos ricos em fibras, substitua opções calóricas por alternativas saudáveis e de baixo teor calórico, inclua proteínas magras, evite açúcares e gorduras processadas, aumente a ingestão de água e considere o acompanhamento de um nutricionista para um plano alimentar personalizado."),
    OBESIDADE3("Para reduzir o peso de forma estruturada e supervisionada, consuma alimentos ricos em fibras e mantenha a hidratação; faça uma redução calórica rigorosa com opções leves, sempre sob supervisão; evite açúcares e gorduras e busque acompanhamento multidisciplinar com nutricionista e médico para um plano seguro, considerando tratamentos adicionais quando necessário.");

    private final String message;

    private IMC (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
