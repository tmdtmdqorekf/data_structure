package Stack;

class LinkedStack<E> implements Stack<E> {
    private Link<E> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public void clear() {
        size = 0;
        top = null;
    }

    @Override
    public void push(E item) {
        top = new Link<E>(item, top);
        size++;
    }

    @Override
    public E pop() {
       E item = top.item; // top 요소의 값 저장
       top = top.getNext(); // top 요소를 다음 요소로 변경
       size--; // 스택 크기 1 감소
       return item; // 삭제한 값 반환
    }

    @Override
    public E topValue() {
        return top.item;
    }

    @Override
    public int length() {
        return size;
    }
}

public class Linked_Stack {
    public static void main(String[] args) throws Exception {
        Stack<String> myList = new LinkedStack<String>();

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

        myList.clear();
        System.out.println(myList.length());
    }
}