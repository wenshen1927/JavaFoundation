package _15_._15_4_metnod_generic._15_4_6;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author zhangyn
 * @description 用Sets类的方法，找到Collection类与Map类之间的方法差异
 * @date 2019-12-21 22:12
 */
public class ContainerMethodDifference {
    /**
     * Object类的方法
     */
    static Set<String> objects = methodSet(Object.class);
    static {
        objects.add("clone");
    }

    /**
     * 查询类的所有方法
     * @param type
     * @return
     */
    static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<>();
        for (Method m :type.getMethods()) {
            result.add(m.getName());
        }
        return result;
    }

    /**
     * 查询类集成的所有接口
     * @param type
     */
    static void interfaces(Class<?> type){
        System.out.println("Interfaces in " + type.getName() + "：");
        List<String> result = new ArrayList<>();
        for (Class<?> c : type.getInterfaces()) {
            result.add(c.getSimpleName());
        }
        System.out.println(result);
    }

    /**
     * 测试类的方法集合和接口集合的交集
     * @param superset
     * @param subset
     */
    static void difference(Class<?> superset,Class<?> subset){
        System.out.println("superset : "+superset.getSimpleName());
        System.out.println("subset : " +subset.getSimpleName());
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        // 不显示Object的方法
        comp.removeAll(objects);
        System.out.println(" difference : "+comp);
        interfaces(superset);
        interfaces(subset);
    }

    public static void main(String[] args) {
        System.out.println("Collections : "+ methodSet(Collection.class));
        interfaces(Collection.class);

        difference(Set.class,Collection.class);
        difference(TreeSet.class,Set.class);


        System.out.println("Map: ");
        difference(Map.class,HashMap.class);
    }
 }
