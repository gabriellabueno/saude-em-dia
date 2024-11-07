package br.edu.fatec.diariosaude.util;

public class Sugestao {

    private String indiceImc, sugestaoNutricional, sugestaoAtvFisica, sugestaoSedentario;


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

        if (idade >= 65)
            sugestaoAtvFisica = geraSugestaoIdoso();
        else {
            if (gestante == 1)
                sugestaoAtvFisica = geraSugestaoGestante();
            else
                sugestaoAtvFisica = geraSugestaoAdulto();
        }

        if (sedentario == 1)
            sugestaoSedentario = geraSugestaoSedentario();
    }

    //SUGESTÃO DE ATIVIDADE FÍSICA PARA SEDENTÁRIOS
    private String geraSugestaoSedentario() {
        return AtividadeFisica.SEDENTARIO.getSugestao();
    }

    //SUGESTÃO DE ATIVIDADE FÍSICA PARA IDOSOS
    private String geraSugestaoIdoso() {
        return AtividadeFisica.IDOSOS.getSugestao();
    }

    //SUGESTÃO DE ATIVIDADE FÍSICA PARA ADULTOS
    private String geraSugestaoAdulto() {
        return AtividadeFisica.ADULTOS.getSugestao();
    }

    //SUGESTÕES DE ATIVIDADE FÍSICA PARA GESTANTES
    private String geraSugestaoGestante() {
        return AtividadeFisica.GRAVIDA.getSugestao();
    }

    //SUGESTÃO NUTRICIONAL GERAL
    private String geraSugestaoNutricional (Double imc) {

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
            indiceImc = Nutricao.OBESIDADE3.getIndice();
            sugestao = Nutricao.OBESIDADE3.getNutricao();
        }

        return sugestao;
    }
}
