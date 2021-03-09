package temperature.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import temperature.ViewModel.Viewmodel;
import temperature.mediator.TemperatureModel;
import temperature.model.Temperature;

import javax.swing.text.View;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewController
{
   @FXML private Label outputLabel;
   @FXML private Label outputLabel1;
   @FXML private Label outputLabel2;
   @FXML private Label outputLabelWarning;
   @FXML private TextField filterField;
   @FXML private Label filterLabel;
   @FXML private Label powerLabel;
   @FXML private Label currentMin, currentMax;

   private ViewHandler viewHandler;

   private Region root;
   private String thermometerId;
   private Viewmodel viewmodel;

   public TemperatureViewController()
   {
   }

   public void init(ViewHandler viewHandler,  Viewmodel viewmodel, Region root)
   {
      this.viewHandler = viewHandler;
      this.viewmodel = viewmodel;
      this.root = root;
      thermometerId = null;

      outputLabel.textProperty().bind(viewmodel.getOutputlabel());
      outputLabel1.textProperty().bind(viewmodel.getOutputlabel1());
      outputLabel2.textProperty().bind(viewmodel.getOutputlabel2());
      powerLabel.textProperty().bind(viewmodel.getPowerLabel());
      outputLabelWarning.textProperty().bind(viewmodel.getOutputlabelWarning());
      currentMax.textProperty().bind(viewmodel.getCurrentMax());
      currentMin.textProperty().bind(viewmodel.getCurrentMin());
   }

   public void reset()
   {
      // empty
   }

   public Region getRoot()
   {
      return root;
   }

   @FXML private void updateButtonPressed()
   {
      viewmodel.updateButton();
   }

   @FXML private void upRadiator()
   {
      viewmodel.upRadiator();
   }

   @FXML private void downRadiator()
   {
      viewmodel.downRadiator();
   }
   @FXML private void settings()
   {
      viewmodel.settings();
   }


}
