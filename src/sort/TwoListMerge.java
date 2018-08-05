package sort;

public class TwoListMerge {
    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);
        l1.next.next.next = new Node(7);

        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);
        l2.next.next.next = new Node(8);
        l2.next.next.next.next = new Node(10);

        Node res = merge(l1, l2);
        while (res != null) {
            System.out.print(res.value + " ");
            res = res.next;
        }
    }

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public static Node merge(Node list1, Node list2) {
        Node head = new Node(0);
        Node res = head;
        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                res.next = new Node(list1.value);
                res = res.next;
                list1 = list1.next;
            }else {
                res.next = new Node(list2.value);
                res = res.next;
                list2 = list2.next;
            }
        }
        res.next = list1 == null ? list2 : list1;
        return reverseList(head.next);
    }

    public static Node reverseList(Node head) {
        Node cur = head;
        Node next = null;
        Node pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
