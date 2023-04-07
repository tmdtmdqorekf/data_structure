package Doubly;

class DoublyLinkedList<E> implements List<E> {
    DLink<E> head, tail, curr;
    int size;
    public DoublyLinkedList() {
        head = tail = curr = new DLink<E>(null,null,null);
        size = 0;
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    @Override
    public void insert(int pos, E item) {
        DLink<E> curr = head;
        for(int i=0; i<pos; i++) {
            curr = curr.next;
        }
        curr.next = new DLink<E>(item, curr, curr.next);
        curr.next.next.prev = curr.next;

        size++;
    }
    @Override
    public void append(E item) {
        if (head == null) {
            DLink<E> n = new DLink<E>(item, null, null);
            head = n;
            if (head.next == null) {
                tail = head;
            }
        }
        else {
            DLink<E> n = new DLink<E>(item, tail, tail.prev);
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        size++;
    }
    @Override
    public void update(int pos, E item) {
        DLink<E> curr = head;
        for(int i=0; i<pos; i++) {
            curr = curr.next;
        }
        curr.next.item = item;
    }
    @Override
    public E getValue(int pos) {
        DLink<E> curr = head;
        for(int i=0; i<pos; i++) {
            curr = curr.next;
        }
        return curr.next.item;
    }
    @Override
    public E remove(int pos) {
        DLink<E> curr = head;
        for(int i=0; i<pos; i++) {
            curr = curr.next;
        }
        E ret = curr.next.item;
        curr.next.next.prev = curr;
        curr.next = curr.next.next;
        size--;
        return ret;
    }
    @Override
    public int length() {
        return size;
    }

    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {
            DLink<E> curr = head;

            public boolean hasNext() {
                return curr != tail;
            }
            public E next() {
                curr = curr.next;
                return curr.item;
            }
            public boolean hasPrevious() {
                return curr != head;
            }
            public E previous() {
                curr = curr.prev;
                return curr.next.item;
            }
        };
    }
}

public class Doubly_list {
    public static void main(String[] args) throws Exception {
        List<String> myList = new DoublyLinkedList<String>();

        myList.append("First");
        myList.append("Second");
        myList.append("Third");
        myList.append("Fourth");
        myList.append("Fifth");

        System.out.println("Initial list:");
        for(int i=0; i<myList.length(); i++) {
            System.out.println(myList.getValue(i));
        }

        System.out.println("Update:");
        myList.update(1, "HAHAHAHA");
        for(int i=0; i<myList.length(); i++) {
            System.out.println(myList.getValue(i));
        }

        System.out.println(myList.getValue(4));

        System.out.println("Remove:");
        myList.remove(2);
        for(int i=0; i<myList.length(); i++) {
            System.out.println(myList.getValue(i));
        }

        System.out.println("Insert:");
        myList.insert(0, "INSERT");
        for(int i=0; i<myList.length(); i++) {
            System.out.println(myList.getValue(i));
        }

        System.out.println("Length:");
        System.out.println(myList.length());

        System.out.println("ListIterator:");
        ListIterator<String> it = myList.listIterator();

        System.out.println("iterate!");
        while(it.hasNext()) {
            String x = it.next();
            System.out.println(x);
        }
        System.out.println("reverse!");
        while(it.hasPrevious()) {
            String x = it.previous();
            System.out.println(x);
        }
    }
}