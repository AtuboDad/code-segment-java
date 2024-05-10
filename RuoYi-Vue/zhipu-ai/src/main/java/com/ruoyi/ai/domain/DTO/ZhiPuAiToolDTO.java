package com.ruoyi.ai.domain.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ZhiPuAiToolDTO {

    private String name;

    private String desc;

    private List<ZhiPuAiToolItemDTO> parameters;

}
