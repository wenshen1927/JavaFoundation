package _15_._15_7_type_erasure._15_7_4;

/**
 * @Classname GeneticHolder
 * @Description
 * @Date 2020/1/1 22:00
 * @Created by Super Man
 */
public class GeneticHolder<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        GeneticHolder<String> holder = new GeneticHolder<>();
        holder.setObj("Item");
        String obj = holder.getObj();

    }
}
