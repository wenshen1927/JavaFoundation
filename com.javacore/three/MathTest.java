package three;

/**
 * @author zhangyn
 * @description 数学函数的练习
 * @date 2019/6/28 下午2:31
 */
public class MathTest {
    enum Size {SMALL,MIDEUM,BIG };

    public static void main(String[] args) {
        double x = 4;
        System.out.println(Math.sqrt(4));

        //幂运算
        System.out.println(Math.pow(3, 2));

        //取余运算，相较于%运算，该方法能够解决被除数为负的问题。
        System.out.println(Math.floorMod(10 + 5, 12));

        double q = 9.99;
        System.out.println((int) q);
        System.out.println((int) Math.round(q));
        //如果强制类型转换，超出了目标类型的取值范围，那么会出现错误值
        System.out.println((byte) 128);//byte -128---127

        x += 3.5;
        System.out.println(x);

        int n = 24;
        System.out.println(Integer.toBinaryString(n));
        int forthBitFromRight = (n & 0b1000)/ 0b1000 ;
        System.out.println(forthBitFromRight);

        Size s = Size.BIG;

        String greet = "Hello";
        String g1 = "Hello";
        System.out.println(greet == g1);//true
        System.out.println((char) greet.codePointAt(0));


        Integer i1 = 1000;
        Integer i2 = 1000;
        System.out.println(i1 == i2);

    }
}
