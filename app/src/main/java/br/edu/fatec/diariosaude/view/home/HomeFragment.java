package br.edu.fatec.diariosaude.view.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import br.edu.fatec.diariosaude.R;

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}