package chap10.exercise;

interface Cycle {
    void ride();
}

interface CycleFactory{
    Cycle getCycle();
}

class Unicycle implements Cycle {
    private Unicycle() {}
    @Override
    public void ride() {
        System.out.println("Ride Unicycle");
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    };
}

class Bicycle implements Cycle {
    private Bicycle() {}
    @Override
    public void ride() { System.out.println("Ride Bicycle"); }
    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}

class Tricycle implements Cycle {
    private Tricycle() {}
    @Override
    public void ride() {
        System.out.println("Ride Tricycle");
    }
    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}

public class Cycles {
    public static void rideCycle(CycleFactory factory) {
        Cycle c = factory.getCycle();
        c.ride();
    }

    public static void main(String[] args) {
        rideCycle(Unicycle.factory);
        rideCycle(Bicycle.factory);
        rideCycle(Tricycle.factory);
    }
}
