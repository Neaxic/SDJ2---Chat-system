package temperature.view;

        import javafx.application.Platform;
        import javafx.fxml.FXML;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.Region;
        import temperature.ViewModel.Viewmodel;
        import temperature.ViewModel.ViewmodelSettings;
        import temperature.mediator.TemperatureModel;
        import temperature.model.Temperature;

        import javax.swing.text.View;
        import java.beans.PropertyChangeEvent;
        import java.beans.PropertyChangeListener;

public class SettingsViewController
{
    private ViewHandler viewHandler;
    private Region root;
    private ViewmodelSettings viewmodelSettings;           
    @FXML private TextField MinInput, MaxInput;

    public SettingsViewController()
    {
    }

    public void init(ViewHandler viewHandler,  ViewmodelSettings viewmodel, Region root)
    {
        this.viewHandler = viewHandler;
        this.viewmodelSettings = viewmodel;
        this.root = root;

        MinInput.setPromptText("Input INT");
        MaxInput.setPromptText("Input INT");
    }

    public void reset()
    {
        // empty
    }

    public Region getRoot()
    {
        return root;
    }

    public void BackBTN(){
       viewmodelSettings.backBTN();
    }

    public void SaveBTN(){
        viewmodelSettings.saveBTN(Integer.parseInt(MinInput.getText()), Integer.parseInt(MaxInput.getText()));
    }


}
