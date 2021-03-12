package Client;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject {
    public void addListenter(String propertyName, PropertyChangeListener Listener);
    public void removeListener(String propertyName, PropertyChangeListener Listerner);
}
