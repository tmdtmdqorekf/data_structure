package BST;

public class BinarySearchTree <Key extends Comparable<Key>, E> implements Dictionary<Key, E> {
    public BinNode<Entry> root;
    int size;

    class Entry { //각 노드에 저장될 데이터 담기 위한 객체
        public Key key; //노드의 키
        public E data; //노드의 데이터

        public Entry(Key key, E data) {
            this.key = key;
            this.data = data;
        }
    }

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public void insert(Key k, E data) {
        root = insertMethod(k, data, root);
        size++;
    }

    public BinNode<Entry> insertMethod(Key k, E data, BinNode<Entry> rt) {
        if (rt == null) { //루트 없으면 아무것도 없는거
            rt = new LeafNode<>(new Entry(k, data)); //처음엔 자식 노드 없으니까 LeafNode 로 생성
        }
        else if (rt.element().key.compareTo(k) == 0) { //루트랑 키 같으면
            rt.element().data = data; //값 덮어쓰기
        }
        else if (rt.element().key.compareTo(k) > 0) { //새로 추가하려는 노드 키가 현재 노드 키보다 작은 경우 -> 왼쪽 서브트리
            if (rt.left() == null && rt.right() == null) {
                rt = new InternalNode<>(rt.element(), new LeafNode<>(new Entry(k, data)), null);
            }
            rt.setLeft(insertMethod(k, data, rt.left()));
        }
        else if (rt.element().key.compareTo(k) < 0) { //새로 추가하려는 노드 키가 현재 노드 키보다 큰 경우 -> 오른쪽 서브트리
            if (rt.left() == null && rt.right() == null) {
                rt = new InternalNode<>(rt.element(), null, new LeafNode<>(new Entry(k, data)));
            }
            rt.setRight(insertMethod(k, data, rt.right()));
        }
        return rt;
    }

    @Override
    public E remove(Key k) {
        E ret = findMethod(k, root); //지울 값 찾기
        if (ret != null) { //지울 값 존재하면
            root = removeMethod(k, root);
            size--;
        }
        return ret;
    }

    private BinNode<Entry> removeMethod(Key k, BinNode<Entry> rt) {
        if (rt == null) {
            return null;
        }
        else if (rt.left() == null && rt.right() == null) {
            rt = new LeafNode<>(new Entry(rt.element().key, rt.element().data));
        }
        else if (rt.element().key.compareTo(k) > 0) { //왼쪽 서브트리
            rt.setLeft(removeMethod(k, rt.left()));
        }
        else if (rt.element().key.compareTo(k) < 0) { //오른쪽 서브트리
            rt.setRight(removeMethod(k, rt.right()));
        }
        else if (rt.left() != null && rt.right() != null) {
            Entry LMost = getLeft(rt.left());
            rt.setElement(LMost);
            rt.setLeft(removeLMost(rt.left()));
        }
        else {
            rt = (rt.left() != null) ? rt.left() : rt.right();
        }
        return rt;
    }

    private Entry getLeft(BinNode<Entry> rt) {
        BinNode<Entry> curr = rt;
        while (curr.right() != null) {
            curr = curr.right();
        }
        return curr.element();
    }

    private BinNode<Entry> removeLMost(BinNode<Entry> rt) {
        if (rt.right() == null) {
            return rt.left();
        }
        else {
            rt.setRight(removeLMost(rt.right()));
            return rt;
        }
    }

    @Override
    public E removeAny() {
        return remove(root.element().key);
    }

    @Override
    public E find(Key k) {
        E tmp = findMethod(k, root);
        return tmp;
    }

    public E findMethod(Key k, BinNode<Entry> rt) { //키로 검색
        if (rt == null) {
            return null;
        }
        else if (rt.element().key == k) {
            return rt.element().data;
        }
        else if (rt.element().key.compareTo(k) > 0) { //왼쪽 서브트리
            return findMethod(k, rt.left());
        }
        else { //오른쪽 서브트리
            return findMethod(k, rt.right());
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    public void inorder(BinNode<Entry> rt) {
        if (rt == null) {
            return;
        }
        inorder(rt.left());
        System.out.print(rt);
        System.out.println(rt.element().data);
        inorder(rt.right());
    }
}