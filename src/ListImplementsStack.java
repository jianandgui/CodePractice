public class ListImplementsStack<Item> {
    private class Node {
        private Item item;
        private Node next;//下一节点
    }

    private int size;
    private Node top = null;

    public  boolean isEmpty() {
        return size == 0;
    }

    public void push(Item item) {
        //栈是先进后出
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Item pop() {
        Node next = top.next;
        Item popItem = top.item;
        top = next;
        size--;
        return popItem;
    }
}
