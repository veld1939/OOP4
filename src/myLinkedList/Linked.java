package myLinkedList;

public interface Linked<E> {
    void addLast(E e);
    void addFirs(E e);
    int size();
    E getElementByIndex(int counter);

}
