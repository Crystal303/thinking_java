package chap14.robot;

/**
 * 命令模式
 * Robot接口关联
 *
 * @author crystal303
 */
public interface Operation {
    String description();
    void command();
}
