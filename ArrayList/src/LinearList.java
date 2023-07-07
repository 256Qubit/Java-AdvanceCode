import java.util.ArrayList;

public class LinearList<T> {
    private ArrayList<T> list;

    public LinearList() {
        list = new ArrayList<>();
    }

    // 添加元素
    public void add(T element) {
        list.add(element);
    }

    // 删除元素
    public void remove(T element) {
        list.remove(element);
    }

    // 修改元素
    public void update(int index, T newElement) {
        if (index >= 0 && index < list.size()) {
            list.set(index, newElement);
        } else {
            System.out.println("Index out of range.");
        }
    }

    // 查找元素
    public int search(T element) {
        return list.indexOf(element);
    }

    // 获取线性表长度
    public int size() {
        return list.size();
    }

    // 获取指定位置的元素
    public T get(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            System.out.println("Index out of range.");
            return null;
        }
    }

    // 打印线性表中的所有元素
    public void printList() {
        for (T element : list) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        LinearList<Integer> linearList = new LinearList<>();

        // 添加元素
        linearList.add(1);
        linearList.add(2);
        linearList.add(3);
        linearList.add(4);

        // 打印线性表
        linearList.printList();

        // 删除元素
        linearList.remove(2);

        // 修改元素
        linearList.update(0, 5);

        // 查找元素
        int index = linearList.search(4);
        System.out.println("Index of 4: " + index);

        // 获取线性表长度
        int size = linearList.size();
        System.out.println("Size of list: " + size);

        // 获取指定位置的元素
        Integer element = linearList.get(1);
        System.out.println("Element at index 1: " + element);
    }
}
