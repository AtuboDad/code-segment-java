package com.diting.ai.enums;

import com.diting.ai.constants.ZhipuaiConstants;
import lombok.Getter;

@Getter
public enum ChatToolFunctions {

    /**
     * 预定义在使用智谱AI大模型的过程中，chat tool定义列表
     */
    EXAMPLE(ZhipuaiConstants.TOOL_FUNCTION_EXAMPLE, "示例"),
    TOOL_FUNCTION_BILL(ZhipuaiConstants.TOOL_FUNCTION_BILL, "计算账单"),
    TOOL_FUNCTION_CAL_LENGTH(ZhipuaiConstants.TOOL_FUNCTION_CAL_LENGTH, "计算桥梁长度"),
    ;

    private final String name;

    private final String desc;

    private ChatToolFunctions(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

}
