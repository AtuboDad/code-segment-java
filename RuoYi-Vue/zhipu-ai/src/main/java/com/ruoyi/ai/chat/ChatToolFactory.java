package com.ruoyi.ai.chat;


import com.ruoyi.ai.chat.tools.CalculateBillTool;
import com.ruoyi.ai.constants.ZhipuaiConstants;

/**
 * 智谱AI，调用参数 chat tools
 */
public class ChatToolFactory {

    /**
     * 计算方法
     * @param toolName 调用方法名称
     * @see ZhipuaiConstants
     */
    public LocalChatTool getTool(String toolName){
        if(toolName == null){
            return null;
        }
        if(toolName.equalsIgnoreCase(ZhipuaiConstants.TOOL_FUNCTION_BILL)){
            return new CalculateBillTool();
        }
        return null;
    }
}
