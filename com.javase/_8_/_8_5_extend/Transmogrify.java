package _8_._8_5_extend;

/**
 * @author zhangyn
 * @description
 * @date 2019-11-30 23:40
 */

class Actor {
    public void act() {

    }
}

class HappyActor extends Actor {
    @Override
    public void act() {
        System.out.println("HappyActor");
    }
}

class SadActor extends Actor {
    @Override
    public void act() {
        System.out.println("SadActor");
    }
}

class Stage {
    private Actor actor = new HappyActor();

    public void change() {
        this.actor = new SadActor();
    }

    public void performPlay() {
        this.actor.act();
    }
}

public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
