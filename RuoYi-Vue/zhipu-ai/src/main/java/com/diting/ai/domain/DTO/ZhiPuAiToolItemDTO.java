package com.diting.ai.domain.DTO;

import com.diting.ai.constants.ZhipuaiConstants;
import lombok.Data;

@Data
public class ZhiPuAiToolItemDTO {

    // 请求参数的字段名称
    private String name;

    // 请求参数的字段类型 String
    private String type = ZhipuaiConstants.DEFAULT_TYPE;

    //请求参数描述
    private String description;

    private ZhiPuAiToolItemDTO() {

    }

    public ZhiPuAiToolItemDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ZhiPuAiToolItemDTO(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

}
