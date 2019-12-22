package three;

/**
 * @author zhangyn
 * @description Java浮点数的练习：精度的问题
 * @date 2019/6/28 下午1:28
 */
public class FloatTest {
    public static void main(String[] args) {
        //判断一个数是不是一个数字，不要用==判断
        System.out.println(Double.isNaN(Double.NaN));//true

        //浮点数的计算有四舍五入的误差，如二进制系统无法精确表示1/10，应该改用BigDecimal类
        System.out.println(2.0 - 1.1);//0.8999999999999999


    }
}
