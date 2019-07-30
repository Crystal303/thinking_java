package chap14.nullobject;

/**
 * 将空对象放在每个position上
 * 虚位以待
 * 像是在设计草案
 *
 * @author crystal303
 */
public class Position {
    private String title;
    private Person person;
    public Position(String jobTitle, Person employee) {
        title = jobTitle;
        person = employee;
        if (person == null) {
            person = Person.NULL;
        }
    }

    public Position(String jobTitle) {
        title = jobTitle;
        person = Person.NULL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle (String newTitle) {
        title = newTitle;
    }

    public Person getPerson () { return person; }

    public void setPerson(Person newPersion) {
        person = newPersion;
        if (person == null) {
            person = Person.NULL;
        }
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", person=" + person +
                '}';
    }
}
