package exceptions;

public class PlateauIsFullException extends Exception{
    public PlateauIsFullException(String msg) {
        System.err.println(msg);
    }
}
