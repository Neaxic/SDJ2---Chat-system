package temperature.mediator;

import javafx.beans.property.Property;
import temperature.model.Temperature;
import temperature.model.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private PropertyChangeSupport property;
  private PropertyChangeSupport property1;
  private PropertyChangeSupport property2;

  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
    property = new PropertyChangeSupport(this);
    property1 = new PropertyChangeSupport(this);
    property2 = new PropertyChangeSupport(this);

  }

  @Override public void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    Temperature old = getLastInsertedTemperature();
    this.temperatureList.addTemperature(temperature);
    if (old != null && old.getValue() != temperature.getValue())
    {
      System.out.println("-->" + temperature + " (from: " + old + ")");
      if(temperature.getId().equals("t1")){
        property.firePropertyChange(temperature.getId(),old.getValue(),temperature.getValue());
      }
      if(temperature.getId().equals("t2")){
        property1.firePropertyChange(temperature.getId(),old.getValue(),temperature.getValue());
      }
      if(temperature.getId().equals("t3")){
        property2.firePropertyChange(temperature.getId(),old.getValue(),temperature.getValue());

      }
    }
  }

  @Override public Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override public Temperature getLastInsertedTemperature(String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  @Override
  public void addListenter(String propertyName, PropertyChangeListener Listener) {
    if(propertyName == null){
      property.addPropertyChangeListener(Listener);
    } else if(propertyName.equals("t1")) {
      property.addPropertyChangeListener(propertyName, Listener);
    }else if(propertyName.equals("t2")){
      property1.addPropertyChangeListener(propertyName, Listener);
    } else if (propertyName.equals("t3")){
      property2.addPropertyChangeListener(propertyName, Listener);
    }}

  @Override
  public void removeListener(String propertyName, PropertyChangeListener Listerner) {

  }

  // and maybe other methods...
}
