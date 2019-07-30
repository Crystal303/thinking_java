package chap10.exercise;

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {

    @Override
    public void menace() {
    }

    @Override
    public void destroy() {
    }
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {

    @Override
    public void menace() {

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

public class HorrorShow14 {

    static void u(Monster b) { b.menace(); }
    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }
    static void w(Lethal l) { l.kill(); }
    public DangerousMonster monsterMaker() {
        return new DangerousMonster() {
            @Override
            public void destroy() {
                System.out.println("DangerousMonster Menace");
            }

            @Override
            public void menace() {
                System.out.println("DangerousMonster Destroy");
            }
        };
    }

    public Vampire vampireMaker() {
        return new Vampire() {
            @Override
            public void drinkBlood() {
                System.out.println("Vampire DrinkBlood");
            }

            @Override
            public void destroy() {
                System.out.println("Vampire Destroy");
            }

            @Override
            public void kill() {
                System.out.println("Vampire kill");
            }

            @Override
            public void menace() {
                System.out.println("Vampire Menace");
            }
        };
    }

    public static void main(String[] args) {
        HorrorShow14 show = new HorrorShow14();
        HorrorShow14.u(show.monsterMaker());
        HorrorShow14.v(show.monsterMaker());
        HorrorShow14.u(show.vampireMaker());
        HorrorShow14.v(show.vampireMaker());
        HorrorShow14.w(show.vampireMaker());
    }
}
