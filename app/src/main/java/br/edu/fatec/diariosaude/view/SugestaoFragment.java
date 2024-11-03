package br.edu.fatec.diariosaude.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import br.edu.fatec.diariosaude.R;

public class SugestaoFragment extends Fragment {


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Apresenta o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_sugestao, container, false);




        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}