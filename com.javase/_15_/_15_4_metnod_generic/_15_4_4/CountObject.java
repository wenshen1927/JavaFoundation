package _15_._15_4_metnod_generic._15_4_4;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-15 23:27
 */
public class CountObject {
    private static int count = 0;
    private final int id = count++;
    public long id(){return id;}
    @Override
    public String toString(){
        return "CountObject : "+id;
    }
}
