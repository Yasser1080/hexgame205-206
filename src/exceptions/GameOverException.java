package exceptions;

public class GameOverException extends Exception{

    public GameOverException(String msg) {
        System.err.println(msg);
    }
}
