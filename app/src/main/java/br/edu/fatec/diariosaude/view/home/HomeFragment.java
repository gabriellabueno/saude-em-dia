package br.edu.fatec.diariosaude.view.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import br.edu.fatec.diariosaude.R;

public class HomeFragment extends Fragment {

    private HomeViewModel viewModel;

    Button btnComecar;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Infla o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inicializa a ViewModel associada ao Fragment
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);


        btnComecar = view.findViewById(R.id.btnComecar);

        // BOTÃO COMEÇAR
        // Redireciona para tela de Cadastro
        btnComecar.setOnClickListener(v -> {
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_home_to_cadastro);
        });


        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}