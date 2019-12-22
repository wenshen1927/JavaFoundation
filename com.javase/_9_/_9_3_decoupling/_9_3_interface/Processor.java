package _9_._9_3_decoupling._9_3_interface;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-04 23:21
 */
public interface Processor {
    String name();

    Object process(Object input);
}

class Apply{
    public static void process(Processor p, Object s){
        System.out.println("Using Processor "+p.name());
        System.out.println(p.process(s));
    }
}


