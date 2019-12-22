package _15_._15_2_class_generic._15_2_2_stack;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-13 23:29
 */
public class LinkedStack<T> {
    private static class Node<A> {
        A item;
        Node<A> next;

        Node() {
            this.item = null;
            this.next = null;
        }

        Node(A item, Node<A> next) {
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
    Node<T> top = new Node<>();

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
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
