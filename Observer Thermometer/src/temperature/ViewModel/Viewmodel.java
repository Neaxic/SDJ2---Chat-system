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

    StringProperty outputlabel;
    StringProperty outputlabel1;
    StringProperty outputlabel2;
    StringProperty outputlabelWarning;
    StringProperty powerLabel;
    StringProperty currentMin, currentMax;
    TemperatureModel temperatureModel;
    String thermometerId;
    Radiator radiator;
    ViewHandler view;
    Thermometer thermometer1;
    Thermometer thermometer2;

    public Viewmodel(TemperatureModel temperatureModel, Radiator radiator){
        this.temperatureModel = temperatureModel;
        outputlabel = new SimpleStringProperty();
        outputlabel1 = new SimpleStringProperty();
        outputlabel2 = new SimpleStringProperty();
        outputlabelWarning = new SimpleStringProperty();
        outputlabelWarning.setValue("Temprature is normal");
        currentMin = new SimpleStringProperty();
        currentMax = new SimpleStringProperty();
        powerLabel = new SimpleStringProperty();
        this.radiator = radiator;
            temperatureModel.addListenter("t1", this);
            temperatureModel.addListenter("t2", this);
            temperatureModel.addListenter("t3", this);
    }

    public StringProperty getOutputlabel() {
        return outputlabel;
    }
    public StringProperty getOutputlabel1() {
        return outputlabel1;
    }
    public StringProperty getOutputlabel2() {
        return outputlabel2;
    }
    public StringProperty getPowerLabel() {
        return powerLabel;
    }
    public StringProperty getOutputlabelWarning(){return outputlabelWarning; }

    public StringProperty getCurrentMin() {
        return currentMin;
    }

    public StringProperty currentMinProperty() {
        return currentMin;
    }

    public StringProperty getCurrentMax() {
        return currentMax;
    }

    public StringProperty currentMaxProperty() {
        return currentMax;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(thermometer1.isCriticalTemp() || thermometer2.isCriticalTemp()){
                    outputlabelWarning.setValue("Temprature is at a critical level");
                } else {
                    outputlabelWarning.setValue("Temprature is normal");
                }
                // kan flyttes til et andet sted (vi behøver ikke opdatatere hele tiden)
                currentMin.setValue("Current min: "+thermometer1.getMinValue());
                currentMax.setValue("Current max: "+thermometer1.getMaxValue());
                powerLabel.setValue("Power position: " +radiator.getPower());
                if(evt.getPropertyName().equals("t1")){
                    outputlabel.setValue(evt.getPropertyName() +": "+evt.getNewValue().toString());
                } else if(evt.getPropertyName().equals("t2")){
                    outputlabel1.setValue(evt.getPropertyName() +": "+evt.getNewValue().toString());
                } else if(evt.getPropertyName().equals("t3")){
                    outputlabel2.setValue(evt.getPropertyName() +": "+evt.getNewValue().toString());
                }
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
