package com.printonline.demo.security;

import com.alibaba.fastjson.JSON;
import com.printonline.demo.tools.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author niran
 */
@Component
public class CustomInvalidSessionStrategy  implements InvalidSessionStrategy {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        logger.info("进入过期处理");
        ResponseHandle.responseHandle(response);
        response.getWriter().write( JSON.toJSONString(new Result(false,"登陆过期")));
//        response.getWriter().print(returnObj.toJSONString());
//        response.flushBuffer();
    }

}