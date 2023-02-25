
/**
 * Interface for a queue: a collection of elements that are inserted
 * and removed according to the first-in first-out principle.
 */
public interface Queue<E> {

    int size();

    boolean isEmpty();

    void enqueue(E e);

    E first();

    E dequeue();
}
