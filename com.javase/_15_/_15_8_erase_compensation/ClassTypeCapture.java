package _15_._15_8_erase_compensation;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ClassTypeCapture
 * @Description 引入类型标签对擦除进行补偿
 * @Date 2019/12/27 22:57
 * @Created by Super Man
 */
public class ClassTypeCapture<T> {
    /**
     * 用来表示运行时的泛型类型信息
     */
    Class<T> kind;
    /**
     * 用map来维护一个类型信息，表示运行时的泛型信息
     */
    Map<String, Class<?>> map;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
        this.map = new HashMap<>();
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typeName, Class<?> kind) {
        map.put(typeName, kind);
    }

    public Object createNew(String typeName) throws Exception {
        if (map.containsKey(typeName)) {
            return map.get(typeName).newInstance();
        }
        throw new Exception(typeName + "{}类型不存在");
    }

    public static void main(String[] args) throws Exception {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        ctt1.addType("Tower",Tower.class);
        System.out.println(ctt1.createNew("Tower"));

        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));

    }
}

class Building {
}

class House extends Building {
}

class Tower extends Building {
}
