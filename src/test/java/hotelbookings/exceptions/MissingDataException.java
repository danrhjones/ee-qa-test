package hotelbookings.exceptions;

public class MissingDataException extends IllegalStateException {

    public MissingDataException(String message) {
        super(message);
    }

}
