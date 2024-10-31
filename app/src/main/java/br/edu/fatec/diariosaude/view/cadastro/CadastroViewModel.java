package br.edu.fatec.diariosaude.view.cadastro;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CadastroViewModel extends ViewModel {
    private final MutableLiveData<Boolean> isFemininoSelected = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isGestanteSelected = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isSedentarioSelected = new MutableLiveData<>(false);


    public void setFemininoSelected(boolean selected) {
        isFemininoSelected.setValue(selected);
    }

    public LiveData<Boolean> isFemininoSelected() {
        return isFemininoSelected;
    }

    public void setGestanteSelected(boolean selected) {
        isGestanteSelected.setValue(selected);
    }

    public LiveData<Boolean> isGestanteSelected() {
        return isGestanteSelected;
    }

    public void setSedentarioSelected(boolean selected) {
        isSedentarioSelected.setValue(selected);
    }

    public LiveData<Boolean> isSedentarioSelected() {
        return isSedentarioSelected;
    }
}