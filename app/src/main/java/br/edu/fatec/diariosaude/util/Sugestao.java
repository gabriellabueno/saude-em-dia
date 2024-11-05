package br.edu.fatec.diariosaude.util;

public class Sugestao {

    private String sugestaoIMC;
    private String sugestaoExercicio;
    private String sugestaoNutricao;
    private String sugestaoGestante;

    // CONSTRUTORES
    public Sugestao() {
    }

    public Sugestao(String sugestaoIMC, String sugestaoNutricao, String sugestaoExercicio, String sugestaoGestante) {
        this.sugestaoIMC = sugestaoIMC;
        this.sugestaoNutricao = sugestaoNutricao;
        this.sugestaoExercicio = sugestaoExercicio;
        this.sugestaoGestante = sugestaoGestante;
    }


    // MÉTODOS
    public Sugestao geraSugestao(Double imc, Integer sedentario, Integer gestante, Integer idade) {

        Sugestao sugestao = new Sugestao();

        // ARRUMAR ESSA LÓGICA:
        if(imc >= 25) {
            sugestao.sugestaoIMC = geraSugestaoIMC(imc);
        }

        if(sedentario == 1) {
            sugestao.sugestaoNutricao = geraSugestaoNutricao();
            sugestao.sugestaoExercicio = geraSugestaoExercicio(idade);
        }

        if(gestante == 1)
            sugestao.sugestaoGestante = geraSugestaoGestante(imc);

        return sugestao;
    }

    public String geraSugestaoIMC(Double imc) {

        String sugestao = "";


        if (imc <= 18.5) {
            // Abaixo do peso
            sugestao = IMC.ABAIXO.getMessage();
        } else if (imc >= 18.6 && imc <= 24.9) {
            //Normal
            sugestao = IMC.NORMAL.getMessage();
        } else if (imc >= 25 && imc <= 29.9) {
            // Sobrepeso
            sugestao = IMC.SOBREPESO.getMessage();
        } else if (imc >= 30 && imc <= 34.9) {
            //  Obesidade grau I
            sugestao = IMC.OBESIDADE1.getMessage();
        } else if (imc >= 35 && imc <= 39.0) {
            // Obesidade grau II
            sugestao = IMC.OBESIDADE2.getMessage();
        } else {
            //  Obesidade grau III
            sugestao = IMC.OBESIDADE3.getMessage();
        }

        return sugestao;
    }

    public String geraSugestaoExercicio(Integer idade) {

        String sugestao = "";

        if (idade < 65) {
            //Adultos
        } else {
            //Idosos
        }

        return sugestao;
    }

    public String geraSugestaoNutricao() {
        String sugestao = "";
        return sugestao;
    }

    public String geraSugestaoGestante(Double imc) {

        String sugestao = "";


        if (imc <= 18.5) {
            // Grávidas abaixo do peso

        } else if (imc >= 18.6 && imc <= 24.9) {
            // Grávidas com peso normal

        } else if (imc >= 25 && imc <= 29.9) {
            // Grávidas com sobrepeso

        } else if (imc >= 30 && imc <= 34.9) {
            // Grávidas com obesidade grau I

        } else if (imc >= 35 && imc <= 39.0) {
            // Grávidas com obesidade grau II

        } else {
            // Grávidas com obesidade grau III

        }

        return sugestao;
    }


}
