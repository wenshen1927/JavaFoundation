package _9_._9_5_extends_interface;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-08 21:59
 */
interface Monster {
    void mennce();
}

interface DangerouseMonster extends Monster{
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerouseMonster {

    @Override
    public void mennce() {

    }

    @Override
    public void destroy() {

    }
}

/**
 * 这里其实继承Monster这个父接口是没用的
 */
class CuteMonster implements Monster,DangerouseMonster{

    @Override
    public void mennce() {

    }

    @Override
    public void destroy() {

    }
}

interface Vampire extends DangerouseMonster,Lethal{
    void drinkBlood();
}

class VeryBadVampire implements Vampire{

    @Override
    public void mennce() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void kill() {

    }

    @Override
    public void drinkBlood() {

    }
}

public class HorrorShow {
    static void u(Monster b){
        b.mennce();
    }
    static void v(DangerouseMonster d){
        d.destroy();
        d.mennce();
    }

    static void w(Lethal l){
        l.kill();
    }

    static void r(Vampire v){

    }

    public static void main(String[] args) {
        DangerouseMonster barney = new DragonZilla();
        u(barney);
        v(barney);

        Vampire vampire = new VeryBadVampire();
        u(vampire);
        v(vampire);
        w(vampire);
        v(vampire);

    }
}
