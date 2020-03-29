package _10_._10_4_;

/**
 * 练习7 练习8
 */
public class Exec7 {
    private String name;

    public Exec7(String name) {
        this.name = name;
    }

    private void writeName() {
        System.out.println(name);
    }

    class InnerCommit {
        private String innerClass;

        /**
         *  修改外部类的域
         */
        public void changeName(String changeName) {
            name = changeName;
        }

        /**
         * 内部类方法调用外部类方法
         */
        public void write() {
            writeName();
        }
    }

    public void change(String name) {
        InnerCommit innerCommit = new InnerCommit();
        innerCommit.changeName(name);
        innerCommit.write();
    }

    public static void main(String[] args) {
        Exec7 e = new Exec7("Wuhan");
        e.writeName();
        e.change("acc");
        // 外部类不能访问其内部类的私有属性
//        e.innerClass;// 报错
    }
}
