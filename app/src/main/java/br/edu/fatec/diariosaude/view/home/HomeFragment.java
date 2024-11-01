package br.edu.fatec.diariosaude.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import br.edu.fatec.diariosaude.R;
import br.edu.fatec.diariosaude.view.controle.ControleFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel viewModel;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Infla o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inicializa a ViewModel associada ao Fragment
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);




        return view;
    }

    // Ao clicar no botão da Home, redireciona para a tela de Pessoas Cadastradas
    // (tentei fazer mas to com um cagaço REAL de mexer nas classes erradas e atrapalhar o trabalho de vocês)


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}