package banker.model;

/**
 * @author: Hxh
 * @date: 2019/11/29
 * @description:
 */
public class NegotiationMessage {
    Integer order;
    Integer timeout;
    Integer clientNum;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getClientNum() {
        return clientNum;
    }

    public void setClientNum(Integer clientNum) {
        this.clientNum = clientNum;
    }
}
