package temperature.view;

import External.Thermometer;
import Radiator.Radiator;
import com.sun.javafx.property.adapter.PropertyDescriptor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import temperature.ViewModel.Viewmodel;
import temperature.core.ViewModelFactory;
import temperature.mediator.TemperatureModel;

public class ViewHandler extends Application
{
  private Stage primaryStage;
  private Scene currentScene;

  private TemperatureViewController temperatureViewController;
  private SettingsViewController settingsViewController;
  private ViewModelFactory viewModelFactory;

  private Thermometer t1, t2, t3;

  public ViewHandler(Thermometer t1, Thermometer t2, Thermometer t3, Radiator r, ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    this.t1 = t1;
    this.t2 = t2;
    this.t3 = t3;
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    this.currentScene = new Scene(new Region());
    openView("temperature");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "temperature":
        root = loadTemperatureView("TemperatureView.fxml");
        break;
      case "settings":
        root = loadSettingsView("SettingsView.fxml");
        break;
    }
    currentScene.setRoot(root);

    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  private Region loadTemperatureView(String fxmlFile)
  {
    if (temperatureViewController == null)
    {
      try
      {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        temperatureViewController = loader.getController();
        temperatureViewController.init(this, viewModelFactory.getViewModel() , root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      temperatureViewController.reset();
    }
    return temperatureViewController.getRoot();
  }

  private Region loadSettingsView(String fxmlFile)
  {
    if (settingsViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        settingsViewController = loader.getController();
        settingsViewController.init(this, viewModelFactory.getViewModelSettings(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      settingsViewController.reset();
    }
    return settingsViewController.getRoot();
  }

}
