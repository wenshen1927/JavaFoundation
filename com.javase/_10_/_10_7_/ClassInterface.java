package _10_._10_7_;

/**
 * 在接口内部放嵌套类,因为在接口内声明的任何类都是自动public和static的
 */
public interface ClassInterface {
    void howdy();
    class Test implements ClassInterface {

        @Override
        public void howdy() {
            System.out.println("howdy");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
