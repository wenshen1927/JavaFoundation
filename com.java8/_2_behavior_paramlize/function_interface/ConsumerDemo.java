package _2_behavior_paramlize.function_interface;

import java.util.function.Consumer;

/**
 * Consumer函数式接口使用练习
 */
public class ConsumerDemo {
    public void pushMessage(int id, Consumer consumer) {
        consumer.accept(id);
    }
}
