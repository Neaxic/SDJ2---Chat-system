package temperature.ViewModel;

import External.Thermometer;
import Radiator.Radiator;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import temperature.core.ModelFactory;
import temperature.core.ViewModelFactory;
import temperature.mediator.ClientModel;
import temperature.mediator.TemperatureModel;
import temperature.model.Temperature;
import temperature.view.ViewHandler;

import javax.print.DocFlavor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Viewmodel {

    StringProperty textField;
    StringProperty textArea;
    ClientModel clientModel;
    ViewHandler view;

    public Viewmodel(ClientModel clientModel){
        this.clientModel = clientModel;
        textField = new SimpleStringProperty();
        textArea = new SimpleStringProperty();

            /*clientModel.addListenter("c1", this);
            clientModel.addListenter("t2", this);
            clientModel.addListenter("t3", this);*/
    }

    public StringProperty getTextField() {
        return textField;
    }

    /* public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                    textField.setValue(evt.getPropertyName() +": "+evt.getNewValue().toString());
            }
        });
    }*/

    public void send(){
        System.out.println("Viewmodel check: " +textField.get());
    }

    public void setView(ViewHandler view){
        this.view = view;
    }

    public void Settings(){
        view.openView("settings");
    }
}
