package temperature.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import temperature.ViewModel.Viewmodel;

public class ChatBoxController {
    private ViewHandler viewHandler;
    private Region root;
    private Viewmodel viewmodel;

    @FXML private TextField inputText;
    //@FXML private ListView ReciveText;

    public ChatBoxController() {
    }

    public void init(ViewHandler viewHandler, Viewmodel viewmodel, Region root)
    {
        this.viewHandler = viewHandler;
        this.viewmodel = viewmodel;
        this.root = root;
        inputText.textProperty().bind(viewmodel.getTextField());
        //ReciveText.textProperty().bind(viewmodel.getTextField());
    }

    @FXML public void Settings()
    {
        viewmodel.Settings();
    }

    public void send(){
        viewmodel.send();
    }

    public void reset()
    {
        // empty
    }

    public Region getRoot()
    {
        return root;
    }
}
