package com.pccc.sip.ivrclient.core;

import com.pccc.sip.ivrclient.bean.InputProtocol;
import com.pccc.sip.ivrclient.bean.OutputProtocol;
import com.pccc.sip.ivrclient.bean.SessionData;
import com.pccc.sip.ivrclient.constant.ProtocolConstant;
import com.pccc.sip.ivrclient.util.HttpUtil;
import io.leaderli.litil.meta.Lino;

public class CoreService {

    /**
     * 1.输入输出实体类
     * 2.与IVR交互的类似sipsession的实体类
     * 3.缓存：callid为key，sipsession为value
     * 4.状态转移函数
     * 5.遇到终止事件时，将这一通会话结束并删除相应的缓存
     */

    public OutputProtocol launch(InputProtocol inputProtocol) {
        String callId = Lino.of(inputProtocol).map(InputProtocol::getCallid).get();
        return null;
    }

    public OutputProtocol interaction(SessionData session) {
        boolean flag = true;
        while (flag) {
            switch (session.getType()) {
                case ProtocolConstant.START:
//                    HttpUtil.postForSip()
                case ProtocolConstant.EVENT:
                    flag = false;
                    break;
            }
        }
        return null;
    }

    /**
     * 根据功能码去查取本通会话中的动态菜单进入此功能的按键序列，查取不到则本次交互失败。
     * @param callId
     * @param flowCode
     * @return
     */
    public String fetchMenuSeq(String callId, String flowCode) {
        return null;
    }
}
