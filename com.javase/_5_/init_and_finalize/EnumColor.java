package _5_.init_and_finalize;

/**
 * @author zhangyn
 * @date 2018/10/25 下午7:16
 */
public enum EnumColor {
    RED, GREEN("绿色", 2), BLACK("黑色", 3), YELLO("黄色", 4);

    private String name;
    private int index;

    private int i;

    private EnumColor(String name, int index) {//构造器无法为public
        this.name = name;
        this.index = index;
    }


    EnumColor() {

    }

    /**
     * 普通方法
     *
     * @param index
     * @return
     */
    public static String getNames(int index) {
        for (EnumColor c :
                EnumColor.values()) {
            if (c.index == index) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
