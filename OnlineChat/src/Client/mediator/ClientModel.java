package Client.mediator;

import Model.PropertyChangeSubject;

public interface ClientModel extends PropertyChangeSubject {
    void addMessage(String id, String msg);
}
//TODO: WTF ER DET HER