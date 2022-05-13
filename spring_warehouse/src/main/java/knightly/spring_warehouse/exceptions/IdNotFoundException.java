package knightly.spring_warehouse.exceptions;

public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException(long id) {
        super("Object with id :" + id + ", not found");
    }
}
