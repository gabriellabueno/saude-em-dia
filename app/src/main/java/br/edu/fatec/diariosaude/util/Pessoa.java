package br.edu.fatec.diariosaude.util;

import androidx.annotation.NonNull;

public class Pessoa {
    private Integer id;
    private String nome;
    private Integer idade;
    private Float altura;
    private Double peso;
    private String genero;
    private Integer sexo;
    private Integer gestante;
    private Integer sedentario;
    private String indiceIMC;
    private Double imc;
    private Sugestao sugestao;


    // CONSTRUTORES
    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, int idade, Float altura, Double peso, String genero,
                  Integer sexo, Integer gestante, Integer sedentario, Double imc, String indiceIMC, Sugestao sugestao) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.genero = genero;
        this.gestante = gestante;
        this.sedentario = sedentario;
        this.imc = null;
        this.indiceIMC = null;
        this.sugestao = sugestao;
    }


    // GETTERS E SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Integer isGestante() {
        return gestante;
    }

    public void setGestante(Integer gestante) {
        this.gestante = gestante;
    }

    public Integer isSedentario() {
        return sedentario;
    }

    public void setSedentario(Integer sedentario) {
        this.sedentario = sedentario;
    }

    public String getIndiceIMC() {
        return this.sugestao.getIndiceImc();
    }

    public void setIndiceIMC(String indiceIMC) {
        this.indiceIMC = indiceIMC;
    }

    public Double getImc() {
        return imc;
    }

    public void calculaIMC() {
        imc = peso / Math.pow(altura, 2);
    }

    public void setSugestao() {
        this.calculaIMC();
        sugestao.geraSugestao(imc, sedentario, gestante, idade);
    }

    public Sugestao getSugestao() {
        return sugestao;
    }

    // Sobrescreve método toString() para apresentar dados no ListView
    @NonNull
    @Override
    public String toString() {
        return "Id: " + id + "Nome: " + nome + "Idade: " + idade;
    }

}