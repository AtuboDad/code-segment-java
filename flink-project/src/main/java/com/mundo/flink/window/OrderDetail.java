package com.mundo.flink.window;

import java.util.Date;

/**
 * @author mundo
 */
public class OrderDetail {

    private Long order_id;

    private Date create_time;

    private String type;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
