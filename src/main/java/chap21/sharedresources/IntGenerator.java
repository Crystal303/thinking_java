package chap21.sharedresources;

/**
 * 消费者任务的抽象方法
 * 产生一个int值 不能实现Generator接口（泛型不支持基本数据类型的参数
 *
 * @author crystal303
 */
public abstract class IntGenerator {
    /**
     * volatile 保证可视性
     */
    private volatile boolean canceled = false;
    public abstract int next();

    /**
     * allow this to be canceled:
     */
    public void cancle() {
        canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}
