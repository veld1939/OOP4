package  myLinkedList;

import java.util.Iterator;

public class LinkedContainer<E> implements Linked<E> ,Iterable<E>, DescendingIterator<E>{

    public static void main(String[] args) {
        LinkedContainer <String> stringLinked = new LinkedContainer<>();
        stringLinked.addFirs("ass");
        stringLinked.addFirs("ass");
        stringLinked.addFirs("ass");
        stringLinked.addFirs("ass");

        Iterator<String> iterator = stringLinked.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;

    public LinkedContainer(){

        lstNode = new Node<E>(null, fstNode, null);
        fstNode = new Node<E>(null, null, lstNode);
    }

    @Override
    public void addLast(E e) {
        Node<E> pref = lstNode;
        pref.setCurrentElement(e);
        lstNode = new Node<E>(null, pref, null);
        pref.setNextElement(lstNode);
        size++;
    }

    @Override
    public void addFirs(E e) {
        Node<E> next = fstNode;
        next.setCurrentElement(e);
        fstNode = new Node<E>(null, null, next);
        next.setNextElement(fstNode);
        size++;

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E getElementByIndex(int counter) {
        Node<E> target = fstNode.getNextElement();
        for(int i = 0; i < counter; i ++){
            target = getNextElement(target);
        };
        return target.getCurrentElement();
    }
       private Node<E> getNextElement(Node<E> current){
        return current.getNextElement();
       }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return  getElementByIndex(counter++);
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int counter = size - 1;
            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public E next() {
                return getElementByIndex(counter--);
            }
        };
    }

    private  class Node<E>{
        private E currentElement;
        public Node<E> nextElement;
        public Node<E> prefElement;



        public Node(E currentElement, Node<E> nextElement, Node<E> prefElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prefElement = prefElement;
        }
        public E getCurrentElement() {
            return currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public Node<E> getPrefElement() {
            return prefElement;
        }
        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public void setPrefElement(Node<E> prefElement) {
            this.prefElement = prefElement;
        }
    }




}
