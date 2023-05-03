package BST;

// 자식 노드가 없는 노드
class LeafNode<E> implements BinNode<E> {
    private E element;

    public LeafNode(E element) {
        this.element = element;
    }

    @Override
    public E element() {
        return element;
    }

    @Override
    public E setElement(E item) {
        this.element = item;
        return item;
    }

    @Override
    public BinNode<E> left() {
        return null;
    }

    @Override
    public BinNode<E> right() {
        return null;
    }

    @Override
    public void setLeft(BinNode<E> n) {

    }

    @Override
    public void setRight(BinNode<E> n) {

    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    public String toString() {
        return "Leaf node value: ";
    }
}
