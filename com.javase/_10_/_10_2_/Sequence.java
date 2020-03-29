package _10_._10_2_;

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object object) {
        if (next < items.length) {
            items[next++] = object;
        }
    }

    /**
     * 这个内部类可以迭代操作外部类的成员变量，迭代器模式:容器只做存储的基本操作，迭代器专门做遍历。
     * <p>
     * 这里把迭代器写成私有内部类，然后外部类提供一个指向内部类的引用的方法，供外部对象调用
     */
    private class SequenceSelector implements Selector {
        private int i = 0;

        // 内部类不能有static的声明
//        static int j = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
        // 内部类不能有static的声明
//        static void getItem(int i) {
//            return;
//        }

        /**
         * 练习4 生成对外部类的对象的引用，用外部类类名.this
         */
        public Sequence getSequence() {
            return Sequence.this;
        }
    }

    /**
     * 练习22 反向遍历一个集合
     */
    private class ReverseSelector implements Selector {
        private int i = items.length - 1;

        @Override
        public boolean end() {
            return i<0;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i >= 0) {
                i--;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public ReverseSelector reverseSelector() {
        return new ReverseSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
        System.out.println("=====");
        ReverseSelector reverseSelector = sequence.reverseSelector();
        while (!reverseSelector.end()) {
            System.out.println(reverseSelector.current() + " ");
            reverseSelector.next();
        }
    }
}
