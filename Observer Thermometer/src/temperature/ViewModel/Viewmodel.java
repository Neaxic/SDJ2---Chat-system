package temperature.ViewModel;

import Client.ClientSocketHandler;
import Server.ServerSocketHandler;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class Viewmodel {

    StringProperty textField;
    StringProperty ReciveText;
    private ClientSocketHandler clientSocketHandler;

    public Viewmodel(ClientSocketHandler clientSocketHandler){
        textField = new SimpleStringProperty();
        ReciveText = new SimpleStringProperty();
        this.clientSocketHandler = clientSocketHandler;
        this.clientSocketHandler.addPropertyChangeListerner("Msg", evt -> updateArea(evt));
    }

    public void updateArea(PropertyChangeEvent evt){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ReciveText.setValue("test: " +evt.getNewValue());
            }
        });
    }

    public void setClientSocketHandler(ClientSocketHandler clientSocketHandler) {
        this.clientSocketHandler = clientSocketHandler;
    }

    public StringProperty getTextField() {
        return textField;
    }

    public void send(String msg){
        clientSocketHandler.sendMessage(msg);
    }
}
