package domain.exceptions;

public class SpaceUsageTooMuchException extends Exception {

    @Override
    public String getMessage() {

        return "Вы превысили 70% площади";

    }
}
