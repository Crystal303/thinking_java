package chap11.queue;

public class Command {
    String s;

    public Command(String s) {
        this.s = s;
    }

    public void operate() {
        System.out.print(s);
    }
}

