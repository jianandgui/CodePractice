package sort;

public class ListImplementsQueue<Item> {

    private class Node {
        private Item item;
        private Node next;
    }

    private Node first = null;
    private Node last = null;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enQueue(Item item) {
        //尾部添加  头部删除
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        if (last == null) {
            first = newNode;
            last = newNode;
        }else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }


    public Item deQueue() {
        if (first == null) {
            throw new IllegalArgumentException();
        }
        Node next = first.next;
        Item item = first.item;
        first = next;
        size--;
        return item;
    }

}
