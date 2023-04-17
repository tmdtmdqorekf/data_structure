package Stack;
public interface Stack<E> {
    /** Reinitialize the stack. */
    public void clear();

    /** Push an element onto the top of the stack.
     @param item The element being pushed onto the stack. */
    public void push(E item); //편의 상 it-> item 으로 수정

    /** Remove and return the element at the top of the stack.
     @return The element at the top of the stack. */
    public E pop();

    /** @return A copy of the top element. */
    public E topValue();

    /** @return The number of elements in the stack. */
    public int length();
}