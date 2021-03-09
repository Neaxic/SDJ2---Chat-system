package temperature.core;

import temperature.ViewModel.Viewmodel;
import temperature.ViewModel.ViewmodelSettings;
import temperature.model.Temperature;

public class ViewModelFactory {

    private Viewmodel viewModel;
    private ViewmodelSettings viewModelSettings;

    public ViewModelFactory(ModelFactory modelFactory) {
        viewModel = new Viewmodel(modelFactory.getDataModel(), modelFactory.getR());
        viewModelSettings = new ViewmodelSettings();
    }

    public Viewmodel getViewModel() {
        return viewModel;
    }

    public ViewmodelSettings getViewModelSettings(){
        return viewModelSettings;
    }
}


