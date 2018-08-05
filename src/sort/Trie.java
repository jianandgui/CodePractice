package sort;

import java.util.HashMap;

public class Trie {
    public static void main(String[] args) {

    }

    Node root = new Node();

    public static void buildTrie(String[] strs,Node root) {
        //先是往树里面添加节点
        for (String str : strs) {
            char[] chars = str.toCharArray();//首先获得字符数组
            int length = chars.length;
            Node curNode = root;
            for (int i=0;i<length;i++) {
                Node node = curNode.getSonNode(chars[i]);
                if (node==null){//没有这个节点
                    node = new Node();
                    curNode.addSonNode(chars[i], node);
                }
                curNode = node;
                if (i == length - 1) {
                    curNode.setLeaf(true);
                }
            }
        }
    }
}

 class Node {

    public boolean isLeaf = false;//默认不是
     public HashMap<Character, Node> sonNode = new HashMap<>();//保存全局节点

     public  boolean isSonNode(char c) {
         return sonNode.containsKey(c);
     }

     public void addSonNode(Character key, Node node) {
         sonNode.put(key, node);
     }
    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }



    public static boolean isLeaf(Node node) {
        return node.isLeaf;
    }

    public static void setLeaf(Node node) {
        node.setLeaf(true);
    }

     Node getSonNode(Character c) {
         return sonNode.get(c);
     }
}
