package _8_._8_3_2_reference_counting;

/**
 * @author zhangyn
 * @description
 * 对于共享变量的垃圾收集，我们要看他的引用计数是否归零
 * @date 2019-11-25 22:59
 */
public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composings = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
        };
        for (Composing c :
                composings) {
            c.dispose();
        }
    }
}

/**
 * 这是一个共享资源
 */
class Shared {
    private int refcount = 0;
    /**
     * 跟踪创建Shared的数量
     */
    private static long counter = 0;

    private final long id = counter++;

    public Shared() {
        System.out.println("Creating " + this);
        // 这里在构造器里引用计数+1是没有用的，需要调用方主动给它+1
//        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    public void addRef() {
        refcount++;
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;

    private static long counter;

    private final long id = counter++;

    public Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("disposing" + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}