package chap14.robot;

import chap14.nullobject.Null;

import java.lang.reflect.*;
import java.util.*;

/**
 * 假设存在许多类型的Robot
 * 对每一种类型的Robot都创建一个空对象用来执行特殊操作
 * Using a dynamic proxy to create a Null Object.
 *
 * @author crystal303
 */
public class NullRobot {
    public static Robot newNulllRobot(Class<? extends Robot> type) {
        return (Robot)Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[]{ Null.class, Robot.class},
                new NullRobotProxyHandler(type)
        );
    }

    public static void main(String[] args) {
        Robot[] robots = {
                new SnowRemovalRobot("SnowBee"),
                newNulllRobot(SnowRemovalRobot.class)
        };
        for (Robot robot : robots) {
            Robot.Test.test(robot);
        }
    }
}

class NullRobotProxyHandler implements InvocationHandler {

    private String nullName;
    private Robot proxied = new NRobot();
    NullRobotProxyHandler(Class<? extends Robot> type) {
        nullName = type.getSimpleName();
    }

    private class NRobot implements Null, Robot {

        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // System.out.println("args: " + args);
        return method.invoke(proxied, args);
    }
}
