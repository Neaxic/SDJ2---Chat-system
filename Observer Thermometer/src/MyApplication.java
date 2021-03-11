import Client.Client;
import External.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;
import temperature.core.ModelFactory;
import temperature.core.ViewModelFactory;
import temperature.view.ViewHandler;

import java.io.IOException;

public class MyApplication extends Application
{
  public void start(Stage primaryStage) throws IOException {

    // Model
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);

    //Start Threads
    Client c1 = new Client();
    c1.start();
    ViewHandler view = new ViewHandler(c1, viewModelFactory);
    Thread t1 = new Thread(c1);
    t1.start();


    // View
    view.start(primaryStage);
    viewModelFactory.getViewModel().setView(view);


    viewModelFactory.getViewModelSettings().setView(view);

  }
}
