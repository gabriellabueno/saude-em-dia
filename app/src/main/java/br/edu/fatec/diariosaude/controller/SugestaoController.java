package br.edu.fatec.diariosaude.controller;

import android.content.Context;

import br.edu.fatec.diariosaude.util.Sugestao;
import br.edu.fatec.diariosaude.model.SugestaoDAO;


public class SugestaoController {
    private SugestaoDAO dao;
    private Context context;

    // Construtor
    public SugestaoController(Context context) {
        this.context = context;
        // this.dao = new SugestaoDAO(context); // Abre BD
    }

    /*
    public void create(Sugestao sugestao) {
        dao = new SugestaoDAO(context);
       //dao.create(sugestao);
    }
     */

    public void update(Sugestao sugestao) {
        dao = new SugestaoDAO(context);
        // dao.update(sugestao);
    }

    public void delete(Sugestao sugestao) {
        dao = new SugestaoDAO(context);
        //  dao.delete(sugestao);
    }

    /*
    public List<Sugestao> listAll() {
        return dao.listAll();
    }
     */

}
