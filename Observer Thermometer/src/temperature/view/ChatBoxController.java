package temperature.view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import temperature.ViewModel.Viewmodel;

import java.util.List;

public class ChatBoxController {
    private ViewHandler viewHandler;
    private Region root;
    private Viewmodel viewmodel;

    @FXML private TextField inputText;
    @FXML private TextArea ReciveText;

    public ChatBoxController() {
    }

    public void init(ViewHandler viewHandler, Viewmodel viewmodel, Region root)
    {
        this.viewHandler = viewHandler;
        this.viewmodel = viewmodel;
        this.root = root;
        //ReciveText.textProperty().bind(viewmodel.);
    }

    @FXML public void Settings()
    {
        viewHandler.openView("settings");
    }

    public void send(){
        viewmodel.send(inputText.getText());
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
