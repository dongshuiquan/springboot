package dsq.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import dsq.entity.LoggerEntity;
import dsq.jpa.LoggerJPA;
import dsq.util.LoggerUtil;
import org.springframework.lang.Nullable;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by aa on 2019/7/14.
 */
public class LoggerInterceptor implements HandlerInterceptor {

    private static final String LOGGER_SEND_TIME = "_send_time";

    private static final String LOGGER_ENTITY = "_logger_entity";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoggerEntity loggerEntity = new LoggerEntity();
        String sessionId = request.getRequestedSessionId();
        String url = request.getRequestURI();
        String paramData = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue
        );

        loggerEntity.setClientIp(LoggerUtil.getCliectIp(request));
        loggerEntity.setMethod(request.getMethod());
        loggerEntity.setType(LoggerUtil.getRequestType(request));
        loggerEntity.setParamData(paramData);
        loggerEntity.setUrl(url);
        loggerEntity.setSessoinId(sessionId);
        request.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());
        request.setAttribute(LOGGER_ENTITY, loggerEntity);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        int status = response.getStatus();
        long currentTime = System.currentTimeMillis();
        long time = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        LoggerEntity loggerEntity = (LoggerEntity) request.getAttribute(LOGGER_ENTITY);
        loggerEntity.setTimeConsuming(Long.valueOf(currentTime - time) + "");
        loggerEntity.setReturnTime(currentTime + "");
        loggerEntity.setHttpStatusCode(status + "");
        loggerEntity.setReturnData(JSON.toJSONString(
                request.getAttribute(LoggerUtil.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue
        ));

        LoggerJPA loggerJPA = getDAO(LoggerJPA.class, request);
        loggerJPA.save(loggerEntity);
    }

    private <T> T getDAO(Class<T> clazz, HttpServletRequest request) {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        T bean = context.getBean(clazz);
        return bean;
    }
}
