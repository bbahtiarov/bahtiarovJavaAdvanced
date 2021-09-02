package domain.exceptions;

public class IlluminanceTooMuchException extends Exception {

    @Override
    public String getMessage() {

        return "Вы превысили допустимую освещённость";

    }
}
