package shejimoshi.zerenlian;

import lombok.Builder;
import lombok.Data;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2019/10/10 18:46
 */

@Data
@Builder
public class LeaveRequest {

    /**
     * 请假姓名
     */
    private String username;

    /**
     * 请假原因
     */
    private String optionIdea;

    private int numOfDays;
}
