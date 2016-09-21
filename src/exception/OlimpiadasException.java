package exception;

public class OlimpiadasException extends Exception {
    public OlimpiadasException(String msg){
        super(msg);
    }

    public OlimpiadasException(String msg, Throwable cause){
        super(msg, cause);
    }
}
