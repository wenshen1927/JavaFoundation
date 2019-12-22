package _5_.init_and_finalize;

/**
 * 枚举类的应用
 *
 * @author zhangyn
 * @date 2018/10/25 下午5:16
 */
public class EnumOrder {
    public static void main(String[] args) {
        Spiciness howhot = Spiciness.MEDIUM;
        System.out.println(howhot);
        for (Spiciness s :
                Spiciness.values()) {
            System.out.println(s + " ordinal " + s.ordinal());
        }
    }
}
