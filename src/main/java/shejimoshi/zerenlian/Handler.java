package shejimoshi.zerenlian;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2019/10/10 18:44
 */
public abstract class Handler {


    protected String name;

    protected Handler nextHandler;

    public Handler(String handlerName) {
        this.name = handlerName;
    }


    public abstract boolean process(LeaveRequest leaveRequest);
}
