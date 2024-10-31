package br.edu.fatec.diariosaude.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SugestaoDAO {
    // Variáveis de Conexão
    private ConnectionFactory conexao;
    private SQLiteDatabase banco;

    // Construtor
    public SugestaoDAO(Context context){
        // Abre conexão com BD
        conexao = new ConnectionFactory(context);
        banco = conexao.getWritableDatabase();
    }

    // MÉTODOS CRUD - CREATE, READ, UPDATE, DELETE


}
