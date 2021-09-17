package Algorithm.structure.map;

public interface Map<E, V> {
    void put(E k, E o);
    Object get(Object obj);
    void remove(Object obj);
    int size();
    void clear();
    boolean isEmpty();
}
