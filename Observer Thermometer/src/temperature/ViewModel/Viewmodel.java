package temperature.ViewModel;

import External.Thermometer;
import Radiator.Radiator;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import temperature.core.ModelFactory;
import temperature.core.ViewModelFactory;
import temperature.mediator.TemperatureModel;
import temperature.model.Temperature;
import temperature.view.ViewHandler;

import javax.print.DocFlavor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Viewmodel implements PropertyChangeListener {

    StringProperty textField;
    TemperatureModel temperatureModel;
    String thermometerId;
    Radiator radiator;
    ViewHandler view;
    Thermometer thermometer1;
    Thermometer thermometer2;

    public Viewmodel(TemperatureModel temperatureModel, Radiator radiator){
        this.temperatureModel = temperatureModel;
        textField = new SimpleStringProperty();
            temperatureModel.addListenter("t1", this);
            temperatureModel.addListenter("t2", this);
            temperatureModel.addListenter("t3", this);
    }

    public StringProperty getTextField() {
        return textField;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                    outputlabel.setValue(evt.getPropertyName() +": "+evt.getNewValue().toString());
                    outputlabel1.setValue(evt.getPropertyName() +": "+evt.getNewValue().toString());
                    outputlabel2.setValue(evt.getPropertyName() +": "+evt.getNewValue().toString());
            }
        });
    }

    public void setThermometer(Thermometer thermometer1, Thermometer thermometer2) {
        this.thermometer1 = thermometer1;
        this.thermometer2 = thermometer2;
    }

    public void updateButton() {
        Temperature t = temperatureModel.getLastInsertedTemperature(thermometerId);
        if (t != null)
        {
            outputlabel.setValue(t.toString());
        }
        else
        {
            outputlabel.setValue("No data");
        }
    }

    public void upRadiator(){
        radiator.turnUp();
    }

    public void downRadiator(){
        radiator.turnDown();
    }

    public void setView(ViewHandler view){
        this.view = view;
    }

    public void settings(){
        view.openView("settings");
    }

    public TemperatureModel getTemperatureModel() {
        return temperatureModel;
    }
}
