package Queue;

class LinkedQueue<E> implements Queue<E> {
    private Link<E> front;
    private Link<E> rear;
    private int size;

    public LinkedQueue() {
        //처음 생성 시 아무런 데이터가 없으므로 front와 rear은 가리킬 노드가 없는 상태임
        front = rear = new Link<E>(null, null);
        size = 0;
    }

    @Override
    public void clear() {
        while (front != null) {
            Link<E> next = front.next;
            front.item = null;
            front.next = null;
            front = next;
        }
        front = rear = null;
        size = 0;
    }

    @Override
    public void enqueue (E item) {
        Link<E> newLink = new Link<E> (item, null);

        if (isEmpty()) {
            // 비어있는 경우, 새 요소가 front 이자 rear 됨
            front = newLink;
        }
        else {
            rear.next = newLink;
        }
        rear = newLink;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        // 삭제할 요소를 반환하기 위한 임시 변수
        E element = front.item;

        // nextLink 는 front 노드의 다음 노드를 가리키게 됨
        Link<E> nextLink = front.next;

        //front 의 모든 요소들 삭제
        front.item = null;
        front.next = null;

        // front 가 가리키는 노드를 삭제된 front 의 다음 노드를 가리키도록 변경
        front = nextLink;
        size--;

        return element;
    }

    @Override
    public E frontValue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.item;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}

public class Linked_Queue {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new LinkedQueue<Integer>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front of the queue: " + queue.frontValue());
        System.out.println("Queue size: " + queue.length());

        int element = queue.dequeue();
        System.out.println("Dequeue element: " + element);
        System.out.println("Queue size after dequeue: " + queue.length());

        queue.enqueue(4);
        queue.enqueue(5);

        while (!queue.isEmpty()) {
            element = queue.dequeue();
            System.out.println("Dequeued element: " + element);
        }

        System.out.println("Queue is empty: " + queue.isEmpty());
    }
}