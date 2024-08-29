package nachhilfe.yanni.todolist.Model;

@FunctionalInterface
public interface ThrowingSupplier<T, E extends Exception> {
    void supply(T t) throws E;
}
