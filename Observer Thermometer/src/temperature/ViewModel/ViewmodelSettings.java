package temperature.ViewModel;

import Client.ClientSocketHandler;

public class ViewmodelSettings {

    private ClientSocketHandler clientSocketHandler;

    public void setClientSocketHandler(ClientSocketHandler clientSocketHandler) {
        this.clientSocketHandler = clientSocketHandler;
    }

    public void saveBTN(String nickname){
        clientSocketHandler.setNickname(nickname);
    }

}
