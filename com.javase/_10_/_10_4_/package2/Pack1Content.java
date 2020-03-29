package _10_._10_4_.package2;

import _10_._10_4_.package1.Pack1;

import java.util.Date;

public class Pack1Content {
    /**
     * 把实例化内部类的能力交给子类
     */
    protected class InnerPack1 implements Pack1{
        @Override
        public Date getDay() {
            return new Date();
        }
    }
}
