package com.chatbot.sample;

import cn.hutool.core.util.StrUtil;
import com.chatbot.core.anno.MsgPlugin;
import com.chatbot.core.entity.UserMessage;
import com.chatbot.core.handler.MessageProcess;
import com.chatbot.core.request.vo.SmallProgramVo;
import org.springframework.stereotype.Component;

@MsgPlugin
@Component
public class MiniProgramPlugin extends MessageProcess {
    @Override
    protected void process(UserMessage userMessage) {
        if (isGroupMessage(userMessage.getFromUser())) {
            String groupContent = userMessage.getGroupContent();
            if (StrUtil.startWith(groupContent,"小程序")) {
                SmallProgramVo smallProgramVo = new SmallProgramVo()
                        .setToUser(userMessage.getFromUser())
                        .setThumbUrl("http://mmbiz.qpic.cn/mmbiz_png/SE9ICmPPKWiaibdENZqwnjeIWiblOvnX4QFZMr2PJ704lOyphLBicqjwYbt9Rsiak2mYM8UBtTX91XgMg3lqs98DMMA/640?wx_fmt=png&wxfrom=200")
                        .setTitle("肯德基自助点餐")
                        .setDes("肯德基+")
                        .setUrl("https://mp.weixin.qq.com/mp/waerrpage?appid=wx23dde3ba32269caa&type=upgrade&upgradetype=3#wechat_redirect")
                        .setSourceUsername("gh_50338e5b8c9d")
                        .setSourceDisplayName("肯德基+")
                        .setUsername("gh_50338e5b8c9d")
                        .setAppid("wx23dde3ba32269caa")
                        .setType(2)
                        .setVersion(92)
                        .setIconUrl("http://mmbiz.qpic.cn/mmbiz_png/SE9ICmPPKWiaibdENZqwnjeIWiblOvnX4QFZMr2PJ704lOyphLBicqjwYbt9Rsiak2mYM8UBtTX91XgMg3lqs98DMMA/640?wx_fmt=png&wxfrom=200")
                        .setPagePath("pages/home/home.html");

                this.sender().sendSmallProgram(smallProgramVo);
            }
        }
    }
}
