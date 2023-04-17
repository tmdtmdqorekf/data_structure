package Tree;

// 자식 노드가 있는 노드
class InternalNode<E> implements BinNode<E> {
    private E element;
    private BinNode<E> leftChild;
    private BinNode<E> rightChild;

    public InternalNode(E element, BinNode<E> leftChild, BinNode<E> rightChild) {
        this.element = element;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public E element() {
        return element;
    }

    @Override
    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public BinNode<E> left() {
        return leftChild;
    }

    @Override
    public BinNode<E> right() {
        return rightChild;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}