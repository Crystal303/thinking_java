package chap10.exercise;

import chap10.Event;
import chap10.GreenhouseControls;

public class GreenhouseControls25 extends GreenhouseControls {
    private boolean waterMist = false;
    public class WaterMistOn extends Event {

        public WaterMistOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterMist = true;
        }

        @Override
        public String toString() {
            return "Water mist generator on";
        }
    }

    public class WaterMistOff extends Event {

        public WaterMistOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterMist = false;
        }

        @Override
        public String toString() {
            return "Water mist generator off";
        }
    }

    public static void main(String[] args) {
        GreenhouseControls25 gc = new GreenhouseControls25();
        gc.addEvent(gc.new Bell(1000));
        Event[] events = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new WaterOn(800),
                gc.new WaterMistOn(800),
                gc.new WaterMistOff(1000),
                gc.new WaterOff(1000),
                gc.new LightOff(1600),
                gc.new ThermostatDay(2000),
        };
        gc.addEvent(gc.new Restart(2000, events));
        if(args.length == 1) {
            gc.addEvent(new GreenhouseControls25.Terminate(new Integer(args[0])));
            gc.run();
        }
    }
}
