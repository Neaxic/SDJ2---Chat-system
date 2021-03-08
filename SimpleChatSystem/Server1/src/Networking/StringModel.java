package Server1.src.Networking;

import java.util.Locale;

public class StringModel {
    private String str;

    public String toUpperCase(String str){
        return str.toUpperCase(Locale.ROOT);
    }

    public String toLowerCase(String str){
        return str.toLowerCase(Locale.ROOT);
    }
}
