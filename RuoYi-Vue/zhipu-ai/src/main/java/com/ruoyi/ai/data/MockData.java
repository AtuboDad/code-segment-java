package com.ruoyi.ai.data;

import java.util.HashMap;
import java.util.Map;

public class MockData {

    public static Map<String, String> getFlightNumber(String src1, String src2) {
        Map<String, Map<String, String>> dataMap = new HashMap<>();

        Map<String, String> dataItem = new HashMap<>();

        dataItem.put("上海", "1234");
        dataItem.put("广州", "8321");
        dataMap.put("北京", dataItem);

        Map<String, String> dataItem2 = new HashMap<>();

        dataItem2.put("北京", "1233");
        dataItem2.put("广州", "8123");
        dataMap.put("上海", dataItem2);

        Map<String, String> result = new HashMap<>();
        result.put("flight_number", dataMap.get(src1).get(src2));
        return result;

    }

    public static String getTicketPrice(String flightNumber, String date) {
        return "1000";
    }

}
