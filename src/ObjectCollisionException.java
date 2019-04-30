public class ObjectCollisionException extends Exception {
    private Object object;
    ObjectCollisionException(Object object) {
        this.object = object;
    }
    public ObjectCollisionException(String msg) {
        super(msg);
    }
    Object getObject() {
        return object;
    }
}
