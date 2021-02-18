package com.chatbot.sample.request;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.http.ForestResponse;

import java.util.Map;

public interface IRequest {

    @Get(url = "https://v1.alapi.cn/api/acg?format=json")
    ForestResponse<Map> acg();

    @Get(url = "https://v1.alapi.cn/api/shici?type=all")
    ForestResponse<Map> poetry();

}
