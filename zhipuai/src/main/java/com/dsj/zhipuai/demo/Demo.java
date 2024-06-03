package com.dsj.zhipuai.demo;

import com.dsj.zhipuai.demo.models.ResultChoice;
import com.dsj.zhipuai.demo.net.ZhiPuAiAdapter;
import com.dsj.zhipuai.demo.util.DataUtil;
import com.zhipu.oapi.service.v4.model.*;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        String str = "bbb";

        testM(str);

        System.out.println(str);

    }

    public static void testM(String str) {
        str = "aaa";
        System.out.println(str);
    }




}
