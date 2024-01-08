package myLinkedList;

public class LinkedList {



    public static class Node<E>{

        E item;
        Node <E> next;
        Node <E> pref;

        public Node(E item, Node<E> next, Node<E> pref) {
            this.item = item;
            this.next = next;
            this.pref = pref;
        }
    }
}
