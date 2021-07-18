package shejimoshi.zerenlian.chainOfResponsity;

import java.util.List;

/**
 * DESC:责任链抽象类
 *
 * @author :RuleChain
 * @date 2021/5/16-17:30
 */

public interface RuleChain {
    
    /**
     * 规则匹配
     */
    void doMatch();

    /**
     * 获取规则Id,后续只会使用规则Id;
     *
     * @return
     */
    List<Long> getRuleIdList();


}
