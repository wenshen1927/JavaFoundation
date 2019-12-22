package _7_.reuse_cLass;

/**
 * 代理类
 *
 * @author zhangyn
 * @date 2018/11/13 下午9:15
 */
public class SpaceShipDelegation {
    private String name;
    SpaceShipControl control = new SpaceShipControl();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    public void up(int velocity) {
        control.up(velocity);
    }

    public void down(int velocity) {
        control.down(velocity);
    }

    public void ll(final int l) {
        final int j = 0;
    }
}
