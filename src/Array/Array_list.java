package Array;

class ArrayList<E> implements List<E> {
    private int size;
    private E[] data;

    public ArrayList(int max_size) {
        data = (E[]) new Object[max_size];
        size = 0;
    }

    @Override
    public void clear() {
        size = 0;
    }
    @Override
    public void insert(int pos, E item) {
        if (size == data.length) {
            doubling();
        }
        for (int i = size; i > pos; i--) {
            data[i] = data[i-1];
        }
        data[pos] = item;
        size++;
    }
    @Override
    public void append(E item) {
        if (size == data.length) {
            doubling();
            System.out.println("두 배 커진 배열 사이즈: " + data.length);
        }
        data[size++] = item;
    }
    @Override
    public void update(int pos, E item) {
        data[pos] = item;
    }
    @Override
    public E getValue(int pos) {
        return data[pos];
    }
    @Override
    public E remove(int pos) {
        E ret = data[pos];

        for (int i = pos; i < size-1; i++) {
            data[i] = data[i+1];
        }

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
            int pos = 0;
            public boolean hasNext() {
                return pos < size;
            }
            public E next() {
                return data[pos++];
            }
            public boolean hasPrevious() {
                return pos > 0;
            }
            public E previous() {
                return data[--pos];
            }
        };
    }

    //현재 배열의 크기를 두 배로 늘리고, 늘어난 크기만큼 새로운 배열 생성
    //기존 배열의 모든 요소를 새로운 배열로 복사
    //기존 배열이 필요 없어지면 garbage collector에 의해 자동으로 삭제됨
    @Override
    public void doubling() {
        int newSize = data.length * 2;
        E[] newData = (E[]) new Object[newSize];
        for(int i=0; i<data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
        System.out.println("두 배 커진 배열 사이즈: " + data.length);
    }
}

public class Array_list {
    public static void main(String[] args) throws Exception {
        ArrayList<String> myList = new ArrayList<String>(20);

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

        myList.doubling();
    }
}