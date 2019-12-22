package _15_._15_2_class_generic._15_2_2_stack;

/**
 * @author zhangyn
 * @description'
 * 内部类可以访问外部类的参数类型
 * @date 2019-12-13 23:40
 */
public class LinkedStack2<A> {
    private class Node<T> {
        A item;
//        Node<A> next;// Node 没有类型参数
        Node<T> next;

        Node() {
            this.item = null;
            this.next = null;
        }

        Node(A item, Node<T> next) {// 这样写，Node里到底存的是什么类型
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    /**
     * 哨兵
     */
    Node<A> top = new Node();

    public void push(A item) {
        top = new Node(item, top);
    }

    public A pop() {
        A result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        lss.push("A");
        lss.push("B");
        lss.push("C");
        System.out.println(lss.pop());
        System.out.println(lss.pop());
        System.out.println(lss.pop());
        System.out.println(lss.pop());
        System.out.println(lss.pop());
        System.out.println(lss.pop());
    }
}
