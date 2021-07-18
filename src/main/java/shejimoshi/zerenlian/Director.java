package shejimoshi.zerenlian;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO 今天完成任务
 * @date 2019/10/10 20:38
 */
public class Director extends Handler {
    public Director(String handlerName) {
        super(handlerName);
    }


   /* public Director(String hanldernam) {
        super(hanldernam);
    }*/

    @Override
    public boolean process(LeaveRequest leaveRequest) {
        return false;
    }
}
