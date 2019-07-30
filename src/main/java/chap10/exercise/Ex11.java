package chap10.exercise;

import chap10.exercise.pack1.Ex11Interface;

class Test {
   private class Inner implements Ex11Interface {

      @Override
      public void say(String s) {
         System.out.println(s);
      }
   }

   Ex11Interface f() {
       return new Inner();
   }
}

public class Ex11 {
    public static void main(String[] args) {
        Test t = new Test();
        t.f().say("hi");
        //! ((Inner)t.f()).say("hello");
    }
}
