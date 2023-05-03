package Linked;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

class LinkedList<E> implements List<E> {
    Link<E> head, tail;
    int size;
    Link<E> freelist;

    public LinkedList() {
        head = tail = new Link(null, null);
        size = 0;
        freelist = null;
    }

    @Override
    public void clear() {
        head.setNext(null);
        tail = head;
        size = 0;
        freelist = null;
    }
    @Override
    public void insert(int pos, E item) {
        Link<E> curr = head;
        for(int i=0; i<pos; i++) {
            curr = curr.next;
        }
        curr.setNext(Link.get(item, curr.next));
        if (curr == tail) {
            tail = curr.next;
        }
        size++;
    }

    @Override
    public void append(E item) {
        tail.next = new Link(item, null);
        tail = tail.next;
        size++;
    }
    @Override
    public void update(int pos, E item) {
        Link<E> curr = head;
        for (int i=0; i<pos; i++) {
            curr = curr.next;
        }
        curr.next.setItem(item);
    }
    @Override
    public E getValue(int pos) {
        Link<E> curr = head;
        for(int i=0; i<pos; i++) {
            curr = curr.next;
        }
        return curr.next.item;
    }
    @Override
    public E remove(int pos) {
        Link<E> curr = head;
        for(int i=0; i<pos; i++) {
            curr = curr.next;
        }
        E ret = curr.next.item;

        if (curr.next == tail) {
            tail = curr;
        }

        Link<E> tmp = curr.next;
        tmp.release();

        curr.next = curr.next.next;

        size--;
        return ret;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {
            Link<E> curr = head;
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
                Link<E> prev = head;
                while (prev.next != curr) {
                    prev = prev.next;
                }
                curr = prev;
                return curr.next.item;
            }
        };
    }
}

public class Linked_list {
    public static void main(String[] args) throws Exception {
        List<String> myList = new LinkedList<String>();

        long startTime = System.nanoTime();

//        //freelist 사용 x
//        for(int i=0; i<1000000; i++) {
//            myList.append(Integer.toString(i));
//        }

//        //freelist 사용 o
//        for(int i=0; i<1000000; i++) {
//            if (myList.length() > 0) {
//                myList.update(0, Integer.toString(i));
//                myList.remove(0);
//            }
//            else {
//                myList.append(Integer.toString(i));
//            }
//        }

        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1000000.0;

        System.out.println("소요 시간: " + elapsedTime + " ms");

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

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage MemoryUsage = memoryBean.getHeapMemoryUsage();
        System.out.println("메모리 사용량: " + MemoryUsage.getUsed() / (1024 * 1024) + " MB");

    }
}