package Tree;

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
    public void setElement(E element) {
        this.element = element;
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
    public boolean isLeaf() {
        return true;
    }
}
