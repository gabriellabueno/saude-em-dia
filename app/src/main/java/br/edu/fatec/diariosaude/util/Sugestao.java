package br.edu.fatec.diariosaude.util;

public class Sugestao {

    private String indiceImc;
    private String sugestaoNutricional;
    private String sugestaoAtvFisica;


    // CONSTRUTORES
    public Sugestao() {
    }

    public Sugestao(String indiceImc, String sugestaoNutricional, String sugestaoAtvFisica) {
        this.indiceImc = indiceImc;
        this.sugestaoNutricional = sugestaoNutricional;
        this.sugestaoAtvFisica = sugestaoAtvFisica;
    }

    // MÉTODOS
    public String getIndiceImc() {
        return indiceImc;
    }

    public String getSugestaoNutricional() {
        return sugestaoNutricional;
    }

    public String getSugestaoAtvFisica() {
        return sugestaoAtvFisica;
    }

    public Sugestao geraSugestao(Double imc, Integer sedentario, Integer gestante, Integer idade) {

        Sugestao sugestao = new Sugestao();

        sugestao.sugestaoNutricional = geraSugestaoNutricional(imc);

        if (idade < 65)
            sugestaoAtvFisica = geraSugestaoAdulto();
        else if (idade >= 65)
            sugestaoAtvFisica = geraSugestaoIdoso();

        if (sedentario == 1) {
            //sugestao.sugestaoNutricao = geraSugestaoAdultos(imc);
            //sugestao.sugestaoExercicio = geraSugestaoExercicio(idade);
        }

        if (gestante == 1)
            sugestao.sugestaoAtvFisica = geraSugestaoGestante();

        return sugestao;
    }

    //SUGESTÃO DE ATIVIDADE FÍSICA PARA SEDENTÁRIOS
    public String geraSugestaoSedentario(Double imc) {

        String sugestao = "";

        sugestao = AtividadeFisica.SEDENTARIO.getSugestao();

        return sugestao;
    }

    //SUGESTÃO DE ATIVIDADE FÍSICA PARA IDOSOS
    public String geraSugestaoIdoso() {

        String sugestao = "";

        sugestao = AtividadeFisica.IDOSOS.getSugestao();

        return sugestao;
    }

    //SUGESTÃO DE ATIVIDADE FÍSICA PARA ADULTOS
    public String geraSugestaoAdulto() {

        String sugestao = "";

        sugestao = AtividadeFisica.ADULTOS.getSugestao();

        return sugestao;
    }

    //SUGESTÕES DE ATIVIDADE FÍSICA PARA GESTANTES
    public String geraSugestaoGestante() {

        String sugestao = "";

        sugestao = AtividadeFisica.GRAVIDA.getSugestao();

        return sugestao;
    }

    //SUGESTÃO NUTRICIONAL GERAL
    public String geraSugestaoNutricional (Double imc) {

        String sugestao = "";

        if (imc <= 18.5) {
            // Abaixo do peso
            indiceImc = Nutricao.ABAIXO.getIndice();
            sugestao = Nutricao.ABAIXO.getNutricao();
        } else if (imc >= 18.6 && imc <= 24.9) {
            //Normal
            indiceImc = Nutricao.NORMAL.getIndice();
            sugestao = Nutricao.NORMAL.getNutricao();
        } else if (imc >= 25 && imc <= 29.9) {
            // Sobrepeso
            indiceImc = Nutricao.SOBREPESO.getIndice();
            sugestao = Nutricao.SOBREPESO.getNutricao();
        } else if (imc >= 30 && imc <= 34.9) {
            //  Obesidade grau I
            indiceImc = Nutricao.OBESIDADE1.getIndice();
            sugestao = Nutricao.OBESIDADE1.getNutricao();
        } else if (imc >= 35 && imc <= 39.0) {
            // Obesidade grau II
            indiceImc = Nutricao.OBESIDADE2.getIndice();
            sugestao = Nutricao.OBESIDADE2.getNutricao();
        } else {
            //  Obesidade grau III
            indiceImc = Nutricao.ABAIXO.getIndice();
            sugestao = Nutricao.OBESIDADE3.getNutricao();
        }

        return sugestao;
    }
}
