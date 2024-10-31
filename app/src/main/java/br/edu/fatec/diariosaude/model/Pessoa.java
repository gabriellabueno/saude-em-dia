package br.edu.fatec.diariosaude.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Pessoa {
    private Integer id;
    private String nome;
    private Integer idade;
    private float altura;
    private float peso;
    private Integer sexo;
    private Integer gestante;
    private Integer sedentario;


    // CONTRUTORES
    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, int idade, float altura, float peso, Integer sexo, Integer gestante, Integer sedentario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.gestante = gestante;
        this.sedentario = sedentario;
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

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
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

    // Sobrescreve método toString() para apresentar dados no ListView
    @NonNull
    @Override
    public String toString() {
        return "Id: " + id + "Nome: " + nome +  "Idade: " + idade;

    }
}
