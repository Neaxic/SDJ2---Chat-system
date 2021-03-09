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
    Thermometer t1 = new Thermometer("t1",15,1, modelFactory.getDataModel() ,modelFactory.getR());
    Thermometer t2 = new Thermometer("t2",15,7, modelFactory.getDataModel(),modelFactory.getR());
    Thermometer t3 = new Thermometer("t3",15,15, modelFactory.getDataModel(),modelFactory.getR());
    ViewHandler view = new ViewHandler(t1, t2, t3, modelFactory.getR(), viewModelFactory);
    Thread t = new Thread(t1);
    Thread d = new Thread(t2);
    Thread e = new Thread(t3);
    t.start();
    d.start();
    e.start();


    // View
    view.start(primaryStage);

    viewModelFactory.getViewModel().setView(view);

    // needed for check if critical temp t1t2 indoor
    viewModelFactory.getViewModel().setThermometer(t1,t2);

    viewModelFactory.getViewModelSettings().setView(view);

    // brugt til at instille min og max temp på dem
    viewModelFactory.getViewModelSettings().setThermometer(t1,t2,t3);
  }
}
