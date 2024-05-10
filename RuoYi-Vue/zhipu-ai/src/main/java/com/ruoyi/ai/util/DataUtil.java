package com.ruoyi.ai.util;

import com.ruoyi.ai.constants.ZhipuaiConstants;
import com.ruoyi.ai.domain.DTO.ZhiPuAiToolDTO;
import com.ruoyi.ai.domain.DTO.ZhiPuAiToolItemDTO;
import com.ruoyi.ai.enums.ChatToolFunctionType;
import com.ruoyi.ai.enums.ChatToolFunctions;
import com.zhipu.oapi.service.v4.model.ChatFunction;
import com.zhipu.oapi.service.v4.model.ChatFunctionParameters;
import com.zhipu.oapi.service.v4.model.ChatTool;
import com.zhipu.oapi.service.v4.model.ChatToolType;

import java.util.*;

public class DataUtil {

    public static ChatTool createTool(ChatToolFunctions tool, ZhiPuAiToolItemDTO... items) {

        String name = tool.getName();
        String desc = tool.getDesc();

        ZhiPuAiToolDTO params = new ZhiPuAiToolDTO();

        List<ZhiPuAiToolItemDTO> paramsList = new ArrayList<>(Arrays.asList(items));

        params.setName(name);
        params.setDesc(desc);
        params.setParameters(paramsList);

        return createCommonTool(params);
    }
    private static ChatTool createCommonTool(ZhiPuAiToolDTO params) {

        String name = params.getName();
        String desc = params.getDesc();

        ChatTool chatTool = new ChatTool();
        chatTool.setType(ChatToolType.FUNCTION.value());

        ChatFunctionParameters chatFunctionParameters = new ChatFunctionParameters();
        chatFunctionParameters.setType(ChatToolFunctionType.OBJECT.value());

        Map<String,Object> properties = new HashMap<>();
        List<String> requiredParams = new ArrayList<>();

        List<ZhiPuAiToolItemDTO> paramsList = params.getParameters();
        for (ZhiPuAiToolItemDTO zhiPuAiToolItem : paramsList) {
            properties.put(zhiPuAiToolItem.getName(), new HashMap<String, Object>() {{
                put(ZhipuaiConstants.DEFAULT_TYPE_STRING, zhiPuAiToolItem.getType());
                put(ZhipuaiConstants.DEFAULT_DESC_STRING, zhiPuAiToolItem.getDescription());
            }});

            requiredParams.add(zhiPuAiToolItem.getName());
        }

        chatFunctionParameters.setProperties(properties);
        chatFunctionParameters.setRequired(requiredParams);

        ChatFunction chatFunction = ChatFunction.builder()
                .name(name)
                .description(desc)
                .parameters(chatFunctionParameters)
                .build();

        chatTool.setFunction(chatFunction);

        return chatTool;
    }

    public static ChatTool createGetFlightNumber(String name, String desc) {

        ChatTool chatTool = new ChatTool();
        chatTool.setType(ChatToolType.FUNCTION.value());

        ChatFunctionParameters chatFunctionParameters = new ChatFunctionParameters();
        chatFunctionParameters.setType("object");

        Map<String,Object> properties = new HashMap<>();
        properties.put("departure",new HashMap<String,Object>(){{
            put("type","string");
            put("description","出发地");
        }});
        properties.put("destination",new HashMap<String,Object>(){{
            put("type","string");
            put("description", "目的地");
        }});
        properties.put("date",new HashMap<String,Object>(){{
            put("type","string");
            put("description", "日期");
        }});

        chatFunctionParameters.setProperties(properties);

        List<String> requiredParams = new ArrayList<>();
        requiredParams.add("departure");
        requiredParams.add("destination");
        requiredParams.add("date");
        chatFunctionParameters.setRequired(requiredParams);

        ChatFunction chatFunction = ChatFunction.builder()
                .name("get_flight_number")
                .description("根据始发地、目的地和日期，查询对应日期的航班号")
                .parameters(chatFunctionParameters)
                .build();

        chatTool.setFunction(chatFunction);
        return chatTool;
    }

    private static ChatTool createGetTicketPrice(String name, String desc) {
        ChatTool chatTool = new ChatTool();
        chatTool.setType(ChatToolType.FUNCTION.value());

        ChatFunctionParameters chatFunctionParameters = new ChatFunctionParameters();
        chatFunctionParameters.setType("object");

        Map<String,Object> properties = new HashMap<>();
        properties.put("flight_number",new HashMap<String,Object>(){{
            put("type","string");
            put("description","航班号");
        }});
        properties.put("date",new HashMap<String,Object>(){{
            put("type","string");
            put("description", "日期");
        }});

        chatFunctionParameters.setProperties(properties);

        List<String> requiredParams = new ArrayList<>();
        requiredParams.add("flight_number");
        requiredParams.add("date");
        chatFunctionParameters.setRequired(requiredParams);

        ChatFunction chatFunction = ChatFunction.builder()
                .name("get_ticket_price")
                .description("查询某航班在某日的票价")
                .parameters(chatFunctionParameters)
                .build();

        chatTool.setFunction(chatFunction);
        return chatTool;

    }



}
