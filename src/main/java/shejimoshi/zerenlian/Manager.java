package shejimoshi.zerenlian;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2019/10/10 20:49
 */
public class Manager extends Handler {

    public Manager(String handlerName) {
        super(handlerName);
    }

    @Override
    public boolean process(LeaveRequest leaveRequest) {
        return false;
    }
}
