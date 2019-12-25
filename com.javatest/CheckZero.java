import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 多级数组（树遍历）
 */
public class CheckZero {

    void checkZero(Node current) {
        if (current.visibility == 0) {
            System.out.println("groupId:" + current.groupId);
        }
    }

    /**
     * 层序遍历
     * @param root
     */
    void level(Node root) {
        if (root == null) {
            return;
        }
        Node current = null;
        // 按层次把树节点放到队列里
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            checkZero(current);
            List<Node> children = current.children;
            //把每一个子节点放到队列里
            if (children != null) {
                for (Node child : children) {
                    queue.offer(child);
                }
            }
        }
    }

//    Node createData(){
//
//    }

    public static void main(String[] args) {

    }
}

class Node {
    String groupId;

    Integer visibility;

    List<Node> children;
}
