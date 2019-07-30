package chap14.nullobject;

import java.util.ArrayList;

/**
 * 填充职位时查询空对象
 *
 * @author crystal303
 */
public class Staff extends ArrayList<Position> {
    public void add(String title, Person person) {
        add(new Position(title, person));
    }

    public void add(String... titles) {
        for (String title : titles) {
            add(new Position(title));
        }
    }

    public Staff(String... titles) {
        add(titles);
    }

    public boolean positionAvailable(String title) {
        for (Position position : this) {
            if (position.getTitle().equals(title)
            && position.getPerson() == Person.NULL) {
                return true;
            }
        }
        return false;
    }

    public void fillPosition (String title, Person person) {
        for (Position position : this) {
            if (position.getTitle() == title
            && position.getPerson() == Person.NULL) {
                position.setPerson(person);
                return;
            }
        }
        throw new RuntimeException(
                "Position " + title + " not available"
        );
    }

    public static void main(String[] args) {
        Staff staff = new Staff(
                "Marketing Manager", "President",
                "CTO", "Product Manager", "Project Lead",
                "Software Engineer", "Software Engineer",
                "Software Engineer", "Software Engineer",
                "Test Engineer", "Technical Writer"
        );
        staff.fillPosition("President",
                new Person("Me", "Last", "The Top, Lonely At"));
        System.out.println(staff);
    }
}
