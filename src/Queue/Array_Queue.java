package Queue;

class ArrayQueue<E> implements Queue<E> {
    private int size; // 큐에 들어가있는 요소 개수
    private int front, rear; // 큐의 맨 앞, 맨 뒤 요소
    private E[] listArray; // 큐 배열

    public ArrayQueue(int size) { // 매개변수로 받음
        listArray = (E[]) new Object[size]; // 주어진 크기로 새 배열 생성
        front = 0; // 맨 앞 요소의 인덱스 0으로 초기화
        rear = -1;
        this.size = 0;
    }

    @Override
    public void clear() {
        listArray = (E[]) new Object[listArray.length];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(E item) {
        if (isFull()) {
            System.out.println("Queue is full");
        }
        rear = (rear + 1) % listArray.length;
        listArray[rear] = item;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        E queueFront = listArray[front];
        front = (front + 1) % listArray.length;
        size--;
        return queueFront;
    }

    @Override
    public E frontValue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        return listArray[front];
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
        return size == listArray.length;
    }
}

public class Array_Queue {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new ArrayQueue<Integer>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front of the queue: " + queue.frontValue());
        System.out.println("Queue size: " + queue.length());

        int element = queue.dequeue();
        System.out.println("Dequeued element: " + element);
        System.out.println("Queue size after dequeue: " + queue.length());

        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()) { // 큐가 비어있지 않은 경우 반복
            element = queue.dequeue(); // 앞에 있는 요소 삭제
            System.out.println("Dequeued element: " + element);
        }

        System.out.println("Queue is empty: " + queue.isEmpty());
    }
}