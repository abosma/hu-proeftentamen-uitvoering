package hu.nl.refractor;

public interface Repository<T> {
    void add(T item);
    void add(Iterable<T> items);
    void remove(T item);
}
