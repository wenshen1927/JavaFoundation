package _15_._15_7_type_erasure._15_7_4;

/**
 * @Classname SimpleHosder
 * @Description 边界处的动作
 * @Date 2019/12/25 23:56
 * @Created by Super Man
 */
public class SimpleHolder {
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.setObj("Item");
        String obj = (String)holder.getObj();
    }
}
