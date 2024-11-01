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

    // !!! Necessário criar método UPDATE para tela de Manutenção

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
    public void update(Pessoa pessoa) { // Recebe objeto Aluno
        ContentValues values = new ContentValues();

        values.put(nome, pessoa.getNome());
        values.put(idade, pessoa.getIdade());
        values.put(altura, pessoa.getAltura());
        values.put(peso, pessoa.getPeso());
        values.put(sexo, pessoa.getSexo());

        // Pega ID da pessoa para consulta SQL
        String[] idPessoa = {String.valueOf(pessoa.getId())};

        // id=? - condição para comando SQL
        banco.update(table, values, "id=?", idPessoa);
    }

    // O método updateTable() atualiza apenas o ID da tabela do BD
    public void updateTable() {
        // Reseta o ID do banco de dados
        banco.delete("sqlite_sequence", "name = ?", new String[]{table});
        banco.delete(table, null, null);
    }

    // DELETE
    public void delete(Pessoa pessoa) {
        // Pega ID da pessoa para consulta SQL
        String[] idPessoa = {String.valueOf(pessoa.getId())};

        // id=? - condição para comando SQL
        banco.delete(table,"id=?", idPessoa);
    }

    //NÃO SEI SE FUNCIONA
    public Pessoa findById(Pessoa pessoa) {
        String[] idPessoa = {String.valueOf(pessoa.getId())};

        Cursor cursor = banco.query(table, args, "id=?", idPessoa, null, null, null);

        if (cursor.moveToFirst()) {
            pessoa.setNome(cursor.getString(1));
            pessoa.setIdade(cursor.getInt(2));
            pessoa.setAltura(cursor.getFloat(3));
            pessoa.setPeso(cursor.getFloat(4));
            pessoa.setSexo(cursor.getInt(5));
            pessoa.setGestante(cursor.getInt(6));
            pessoa.setSedentario(cursor.getInt(7));

            cursor.close();
            return pessoa;
        } else {
            cursor.close();
            return null; // Não encontrou a pessoa
        }
    }

    public Pessoa read(Integer id) {
        String idPessoa[] = {String.valueOf(id)};

        Cursor cursor = banco.query(table, args,
                "id=?", idPessoa, null, null, null);

        cursor.moveToFirst();

        Pessoa pessoa = new Pessoa();

        if(cursor.getCount() > 0){
            pessoa.setNome(cursor.getString(1));
            pessoa.setIdade(cursor.getInt(2));
            pessoa.setAltura(cursor.getFloat(3));
            pessoa.setPeso(cursor.getFloat(4));
            pessoa.setSexo(cursor.getInt(5));
            pessoa.setGestante(cursor.getInt(6));
            pessoa.setSedentario(cursor.getInt(7));
        }
        return pessoa;
    }

}
