package temperature.view;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import temperature.ViewModel.Viewmodel;
import temperature.ViewModel.ViewmodelSettings;

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
        //inputText.textProperty().bind(viewmodel.getOutputlabel());
        ReciveText.textProperty().bind(viewmodel.getTextField());
    }

    @FXML private void NicknamePromt()
    {
        viewmodel.NicknamePromt();
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
