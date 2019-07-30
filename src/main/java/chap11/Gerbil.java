package chap11;

import java.util.*;

public class Gerbil {
    int gerbilNumber;
    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }
    
    public void hop() {
        System.out.println(gerbilNumber + "号沙鼠正在跳跃！");
    }

    public static void main(String[] args) {
        List<Gerbil> gerbilList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            gerbilList.add(new Gerbil(i));
        }

        for (Gerbil g :
                gerbilList) {
            g.hop();
        }
    }
}
