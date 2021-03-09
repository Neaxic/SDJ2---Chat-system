package temperature.ViewModel;

import External.Thermometer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import temperature.view.ViewHandler;

public class ViewmodelSettings {
    private ViewHandler view;
    private Thermometer[] thermometerList = new Thermometer[3];

    public void setView(ViewHandler view){
        this.view = view;
    }

    public void backBTN(){
        view.openView("temperature");
    }

    public void saveBTN(int min, int max){
        for (Thermometer current: thermometerList) {
            current.setMinValue(min);
            current.setMaxValue(max);
        }
        view.openView("temperature");
    }

    public void setThermometer(Thermometer thermometer1, Thermometer thermometer2, Thermometer thermometer3) {
        thermometerList[0] = thermometer1;
        thermometerList[1] = thermometer2;
        thermometerList[2] = thermometer3;
    }
}
