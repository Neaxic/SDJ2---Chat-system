package temperature.core;

import Client.ClientSocketHandler;
import temperature.ViewModel.Viewmodel;
import temperature.ViewModel.ViewmodelSettings;

import java.io.IOException;

public class ViewModelFactory {

    private Viewmodel viewModel;
    private ViewmodelSettings viewModelSettings;

    public ViewModelFactory(ModelFactory modelFactory, ClientSocketHandler handler) throws IOException {
        viewModel = new Viewmodel(handler);
        viewModelSettings = new ViewmodelSettings();
    }

    public Viewmodel getViewModel() {
        return viewModel;
    }

    public ViewmodelSettings getViewModelSettings(){
        return viewModelSettings;
    }
}


