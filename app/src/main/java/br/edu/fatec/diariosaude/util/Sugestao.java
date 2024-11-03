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
    public Sugestao geraSugestao(Double imc, Integer sedentario, Integer gestante) {

        Sugestao sugestao = new Sugestao();

        if(imc >= 25) {
            sugestao.sugestaoIMC = geraSugestaoIMC(imc);
        }

        if(sedentario == 1) {
            sugestao.sugestaoNutricao = geraSugestaoNutricao();
            sugestao.sugestaoExercicio = geraSugestaoExercicio();
        }

        if(gestante == 1)
            sugestao.sugestaoGestante = geraSugestaoGestante();

        return sugestao;
    }

    public String geraSugestaoIMC(Double imc) {

        String sugestao = "";


        if (imc <= 29.9) {
            // Sobrepeso
        } else if(imc >= 30 && imc <= 34.9) {
            //  Obesidade grau I
        } else if(imc >= 35 && imc <= 39.0) {
            // Obesidade grau II
        } else {
            //  Obesidade grau III
        }

        return sugestao;
    }

    public String geraSugestaoExercicio() {
        String sugestao = "";
        return sugestao;
    }

    public String geraSugestaoNutricao() {
        String sugestao = "";
        return sugestao;
    }

    public String geraSugestaoGestante() {
        String sugestao = "";
        return sugestao;
    }


}
