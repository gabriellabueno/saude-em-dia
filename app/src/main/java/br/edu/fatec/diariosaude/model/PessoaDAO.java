package br.edu.fatec.diariosaude.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.diariosaude.util.Pessoa;

public class PessoaDAO {
    // Variáveis de Conexão
    private ConnectionFactory conexao;
    private SQLiteDatabase banco;

    // Variáveis pra consultas SQL
    private static final String table = "pessoa";
    private static final String id = "id";
    private static final String nome = "nome";
    private static final String idade = "idade";
    private static final String altura = "altura";
    private static final String peso = "peso";
    private static final String genero = "genero";
    private static final String sexo = "sexo";
    private static final String gestante = "gestante";
    private static final String sedentario = "sedentario";
    String[] args = {id, nome, idade, altura, peso, genero, sexo, gestante, sedentario};

    // Construtor
    public PessoaDAO(Context context){
        // Abre conexão com BD
        conexao = new ConnectionFactory(context);
        banco = conexao.getWritableDatabase();
    }

    // MÉTODOS CRUD - CREATE, READ, UPDATE, DELETE

    // CREATE
    public void create(Pessoa pessoa){
        ContentValues values = new ContentValues();

        values.put(nome, pessoa.getNome());
        values.put(idade, pessoa.getIdade());
        values.put(altura, pessoa.getAltura());
        values.put(peso, pessoa.getPeso());
        values.put(genero, pessoa.getGenero());
        values.put(sexo, pessoa.getSexo());
        values.put(gestante, pessoa.isGestante());
        values.put(sedentario, pessoa.isSedentario());

        banco.insert(table, null, values);
    }

    // UPDATE
    public void update(Pessoa pessoa) {
        ContentValues values = new ContentValues();

        values.put(nome, pessoa.getNome());
        values.put(idade, pessoa.getIdade());
        values.put(altura, pessoa.getAltura());
        values.put(peso, pessoa.getPeso());
        values.put(genero, pessoa.getGenero());
        values.put(sexo, pessoa.getSexo());
        values.put(gestante, pessoa.isGestante());
        values.put(sedentario, pessoa.isSedentario());

        String[] idPessoa = {String.valueOf(pessoa.getId())};

        banco.update(table, values, "id=?", idPessoa);
    }

    // Reseta ID da tabela "pessoa"
    public void updateTableID() {
        banco.delete("sqlite_sequence", "name = ?", new String[]{table});
        banco.delete(table, null, null);
    }


    // DELETE
    public void delete(Pessoa pessoa) {
        String[] idPessoa = {String.valueOf(pessoa.getId())};

        banco.delete(table,"id=?", idPessoa);
    }


    // READ
    public Pessoa read(Integer id) {
        String[] idPessoa = {String.valueOf(id)};

        Cursor cursor = banco.query(table, args,
                "id=?", idPessoa, null, null, null);

        cursor.moveToFirst();

        Pessoa pessoa = new Pessoa();

        // Percorre todas as colunas do registro
        if(cursor.getCount() > 0){
            pessoa.setNome(cursor.getString(1));
            pessoa.setIdade(cursor.getInt(2));
            pessoa.setAltura(cursor.getFloat(3));
            pessoa.setPeso(cursor.getDouble(4));
            pessoa.setGenero(cursor.getString(5));
            pessoa.setSexo(cursor.getInt(6));
            pessoa.setGestante(cursor.getInt(7));
            pessoa.setSedentario(cursor.getInt(8));
        }
        cursor.close();
        return pessoa;
    }

    // Retorna uma lista com todos os registros
    // para apresentar no ListView
    public List<Pessoa> listAll() {
        List<Pessoa> pessoas = new ArrayList<>(); // Array de pessoas

        String[] args = {id, nome, idade};

        Cursor cursor = banco.query(table, args,
                null, null, null, null, null );

        // Loop para percorrer todas as linhas da tabela
        while (cursor.moveToNext()) {
            Pessoa p = new Pessoa();

            p.setId(cursor.getInt(0));
            p.setNome(cursor.getString(1));
            p.setIdade(cursor.getInt(2));
            pessoas.add(p); // adiciona pessoa ao array
        }

        cursor.close();
        return pessoas;
    }

}
