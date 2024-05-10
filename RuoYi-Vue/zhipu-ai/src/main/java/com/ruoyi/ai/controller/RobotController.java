package com.ruoyi.ai.controller;


import com.ruoyi.ai.domain.QuestionDomainQuery;
import com.ruoyi.ai.service.ModelService;
import com.ruoyi.common.core.controller.BaseController;
import com.zhipu.oapi.service.v4.model.ChatMessageAccumulator;
import com.zhipu.oapi.service.v4.model.ModelApiResponse;
import com.zhipu.oapi.service.v4.model.ModelData;
import io.reactivex.Flowable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/robot")
public class RobotController extends BaseController {

    @Resource
    private ModelService modelService;
    @PostMapping("/test")
    public String test()
    {
        return "111";
    }

    @GetMapping("/question")
    public void question(String question, HttpServletResponse response) throws IOException {
        QuestionDomainQuery questionDomainQuery = new QuestionDomainQuery();
        questionDomainQuery.setQuestion(question);
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        // 禁用缓存
        response.setHeader("Cache-Control", "no-cache");

        ServletOutputStream outputStream = response.getOutputStream();
        // 创建AI请求封装对象
        ModelApiResponse sseModelApiResp = modelService.reply(questionDomainQuery);

        mapStreamToAccumulator(sseModelApiResp.getFlowable())
            .doOnNext(accumulator -> {
                {
                    if (accumulator.getDelta() != null && accumulator.getDelta().getContent() != null) {
                        outputStream.write(accumulator.getDelta().getContent().getBytes());
                        outputStream.flush();
                    }
                }
            })
            .doOnComplete(System.out::println)
            .lastElement()
            .blockingGet();

    }

    public static Flowable<ChatMessageAccumulator> mapStreamToAccumulator(Flowable<ModelData> flowable) {
        return flowable.map(chunk -> {
            return new ChatMessageAccumulator(chunk.getChoices().get(0).getDelta(), null, chunk.getChoices().get(0), chunk.getUsage(), chunk.getCreated(), chunk.getId());
        });
    }

}
