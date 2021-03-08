package Server1.src.communicationobjects;

import java.io.Serializable;

public class Request implements Serializable {
    private String text;
    private String arg;
    private String requestType;
    enum requestType{
        HIGH,
        MED,
        LOW,
    }
    public Request(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
