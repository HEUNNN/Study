package kr.inflearn;

public class ObjectArray {
    private int count;
    private Object[] objArr;

    public ObjectArray() {
        this(10);
    }
    public ObjectArray(int init) {
        objArr = new Object[init];
    }

    public void add(Object data) {
        objArr[count++] = data;
    }
    public Object get(int idx) {
        return objArr[idx];
    }
    public int size() {
        return count;
    }

}
