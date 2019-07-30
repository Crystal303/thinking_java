package chap14.robot;

import chap14.nullobject.Null;

import java.util.List;

/**
 * Robot接口
 *
 * @author crystal303
 */
public interface Robot {
    String name();
    String model();
    List<Operation> operations();

    /**
     * 嵌套类Test执行测试
     *
     * @author crystal303
     */
    class Test {
        public static void test(Robot r) {
            if (r instanceof Null) {
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name: " + r.name());
            System.out.println("Robot model: " + r.model());
            for (Operation operation : r.operations()) {
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
