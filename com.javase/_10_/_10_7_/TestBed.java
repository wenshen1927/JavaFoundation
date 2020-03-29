package _10_._10_7_;

public class TestBed {

    public void f() {
        System.out.println("f()");
    }

    // 可以设置一个嵌套类来测试外部类里的某些方法，在打包前把TestBed$Tester排除
    static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
}
