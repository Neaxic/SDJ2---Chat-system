package temperature.mediator;

import temperature.model.Temperature;

public interface ClientModel extends NamedPropertyChangeSubject{
    void addMessage(String id, String msg);
}
