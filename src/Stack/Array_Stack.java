package Stack;

class ArrayStack<E> implements Stack<E> {
    private int size;
    private int top;
    private E[] listArray;

    //초기화 & 생성자
    public ArrayStack(int size) {
        listArray = (E[]) new Object[size];
        top = -1; //-1로 해둬야 첫 원소가 들어왔을 때 1 증가시켜 listArray[0]을 가리킴
    }

    @Override
    public void clear() {
        size = 0;
        top = -1;
    }

    @Override
    public void push(E item) {
        size++;
        listArray[++top] = item;
    }

    @Override
    public E pop() {
        if (size == 0) {
            System.out.println("Stack is empty");
        }
        size--;
        return listArray[top--];
    }

    @Override
    public E topValue() {
        return listArray[top];
    }

    @Override
    public int length() {
        return size;
    }
}

public class Array_Stack {
    public static void main(String[] args) throws Exception {
        Stack<String> myList = new ArrayStack<String>(20);

        myList.push("first push");
        myList.push("second push");
        myList.push("third push");

        System.out.println("length before pop: ");
        System.out.println(myList.length());

        System.out.println("top value: ");
        System.out.println(myList.topValue());

        System.out.println("pop!: ");
        System.out.println(myList.pop());

        System.out.println("top value: ");
        System.out.println(myList.topValue());

        System.out.println("length after pop: ");
        System.out.println(myList.length());
    }
}