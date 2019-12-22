package _9_._9_4_mutil_inhiert_;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-08 22:13
 */
interface Canfight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface Canfly{
    void fly();
}

class ActionCharacter {
    public void fight(){}
}

class Hero extends ActionCharacter implements Canfight,Canfly,CanSwim {

    @Override
    public void swim() {

    }

    @Override
    public void fly() {

    }
}

public class Aventure {
}
