package chap10.exercise;

class Word {
    private String word;

    public Word(String s) {
        word = s;
    }

    @Override
    public String toString() {
        return word;
    }
}

interface Selector {
    boolean end();
    Object current();
    void next();
}

public class Sequence2 {
    private Object[] items;
    private int next = 0;

    public Sequence2(int size) {
        items = new Object[size];
    }

    public void add(Word word) {
        if (next < items.length) {
            items[next++] = word;
        }

    }

    private class Sequence2Selector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new Sequence2Selector();
    }

    public static void main(String[] args) {
        Sequence2 sequence2 = new Sequence2(10);
        for (int i = 0; i < 10; i++) {
            sequence2.add(new Word(Integer.toString(i)));
        }
        Selector selector = sequence2.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        Word w1 = new Word("peace");
        Word w2 = new Word("Love");
        Word w3 = new Word("Easter");
        Sequence2 message = new Sequence2(3);
        message.add(w1);
        message.add(w2);
        message.add(w3);
        Selector sel = message.selector();
        while (!sel.end()) {
            System.out.print(sel.current() + " ");
            sel.next();
        }
    }
}
