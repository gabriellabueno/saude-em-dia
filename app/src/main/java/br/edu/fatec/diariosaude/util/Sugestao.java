package br.edu.fatec.diariosaude.util;

public class Sugestao {

    private String indiceImc;
    private String sugestaoNutricional;
    private String sugestaoAtvFisica;
    private String sugestaoSedentario;


    // CONSTRUTORES
    public Sugestao() {
    }

    public Sugestao(String indiceImc, String sugestaoNutricional, String sugestaoAtvFisica, String sugestaoSedentario) {
        this.indiceImc = indiceImc;
        this.sugestaoNutricional = sugestaoNutricional;
        this.sugestaoAtvFisica = sugestaoAtvFisica;
        this.sugestaoSedentario = sugestaoSedentario;
    }

    // MÉTODOS
    public String getSugestaoSedentario() {return sugestaoSedentario;}

    public String getIndiceImc() {
        return indiceImc;
    }

    public String getSugestaoNutricional() {
        return sugestaoNutricional;
    }

    public String getSugestaoAtvFisica() {
        return sugestaoAtvFisica;
    }

    public void geraSugestao(Double imc, Integer sedentario, Integer gestante, Integer idade) {

        sugestaoNutricional = geraSugestaoNutricional(imc);

        if (sedentario == 1) {
            // SEDENTÁRIO
            sugestaoSedentario = geraSugestaoSedentario();
        }

        if (idade >= 65) {
            //IDOSO
            sugestaoAtvFisica = geraSugestaoIdoso();

        } else {

            if (gestante == 1) {
                // GESTANTE
                sugestaoAtvFisica = geraSugestaoGestante();
            } else {
                //ADULTO
                sugestaoAtvFisica = geraSugestaoAdulto();
            }
        }
    }

    //SUGESTÃO DE ATIVIDADE FÍSICA PARA SEDENTÁRIOS
    public String geraSugestaoSedentario() {

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
