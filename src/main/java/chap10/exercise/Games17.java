package chap10.exercise;

import java.util.Random;

interface Games {
    void play();
}

interface GamesFactory {
    Games getGames();
}

class CoinToss implements Games {
    private CoinToss() {}
    @Override
    public void play() {
        System.out.println("Toss Coin: ");
        Random random = new Random();
        switch (random.nextInt(2)) {
            case 0 : System.out.println("Heads"); return;
            case 1 : System.out.println("Tails"); return;
            default: System.out.println("OnEdge"); return;
        }
    }
    public static GamesFactory factory = new GamesFactory() {
        @Override
        public Games getGames() {
            return new CoinToss();
        }
    };
}

class DiceThrow implements Games {
    private DiceThrow() {}
    Random random = new Random();
    @Override
    public void play() {
        System.out.println("Throw Dice: " + (random.nextInt(6) + 1));
    }
    public static GamesFactory factory = new GamesFactory() {
        @Override
        public Games getGames() {
            return new DiceThrow();
        }
    };
}
public class Games17 {
    public static void playGame(GamesFactory factory) {
        Games g = factory.getGames();
        g.play();
    }

    public static void main(String[] args) {
        playGame(CoinToss.factory);
        playGame(DiceThrow.factory);
    }
}
