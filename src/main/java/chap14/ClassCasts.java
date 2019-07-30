package chap14;

class Blinding {}

class House extends Blinding {}

public class ClassCasts {
    public static void main(String[] args) {
        Blinding b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        System.out.println(b instanceof House);

    }
}
