package br.edu.fatec.diariosaude.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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
    private static final String sexo = "sexo";
    private static final String gestante = "gestante";
    private static final String sedentario = "peso";
    String[] args = {id, nome, idade, altura, peso, sexo, gestante, sedentario};

    // Construtor
    public PessoaDAO(Context context){
        // Abre conexão com BD
        conexao = new ConnectionFactory(context);
        banco = conexao.getWritableDatabase();
    }

    // MÉTODOS CRUD - CREATE, READ, UPDATE, DELETE

    // CREATE
    public long create(Pessoa pessoa){
        ContentValues values = new ContentValues();

        values.put(nome, pessoa.getNome());
        values.put(idade, pessoa.getIdade());
        values.put(altura, pessoa.getAltura());
        values.put(peso, pessoa.getPeso());
        values.put(sexo, pessoa.getSexo());
        values.put(gestante, pessoa.isGestante());
        values.put(sedentario, pessoa.isSedentario());

        return banco.insert(table, null, values);
    }

    // READ

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

    // UPDATE

    // O método updateTable() atualiza apenas o ID da tabela do BD
    // Necessário criar método UPDATE para tela de Manutenção


    public void updateTable() {
        // Reseta o ID do banco de dados
        banco.delete("sqlite_sequence", "name = ?", new String[]{table});
        banco.delete(table, null, null);
    }


    // DELETE


}
