package com.dsj.zhipuai.demo.util;

import com.dsj.zhipuai.demo.enums.ChatToolFunctionType;
import com.zhipu.oapi.service.v4.model.ChatFunction;
import com.zhipu.oapi.service.v4.model.ChatFunctionParameters;
import com.zhipu.oapi.service.v4.model.ChatTool;
import com.zhipu.oapi.service.v4.model.ChatToolType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataUtil {

    public static ChatTool createCommonTool(String name, String desc, Map<String, Object> params) {

        ChatTool chatTool = new ChatTool();
        chatTool.setType(ChatToolType.FUNCTION.value());

        ChatFunctionParameters chatFunctionParameters = new ChatFunctionParameters();
        chatFunctionParameters.setType(ChatToolFunctionType.OBJECT.value());

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

    public static ChatTool createGetTicketPrice(String name, String desc) {
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
