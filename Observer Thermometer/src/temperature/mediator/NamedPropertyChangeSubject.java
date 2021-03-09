package temperature.mediator;

import java.beans.PropertyChangeListener;

public interface NamedPropertyChangeSubject {
    public void addListenter(String propertyName, PropertyChangeListener Listener);
    public void removeListener(String propertyName, PropertyChangeListener Listerner);
}
