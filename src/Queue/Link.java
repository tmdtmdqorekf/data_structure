package Queue;

public class Link<E> { // Node 라고 표현해도 됨
    public E item;
    public Link<E> next; // ref

    public Link(E item, Link<E> next) {
        this.item = item;
        this.next = next;
    }
}
