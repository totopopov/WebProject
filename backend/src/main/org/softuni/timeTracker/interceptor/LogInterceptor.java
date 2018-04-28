package org.softuni.timeTracker.interceptor;

import org.softuni.timeTracker.annotations.GetIP;
import org.softuni.timeTracker.areas.logger.entity.model.LoggerDto;
import org.softuni.timeTracker.areas.logger.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * Created by Todor Popov using Lenovo on 28.4.2018 г. at 11:03.
 */

@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

    private LoggerService loggerService;

    @Autowired
    public LogInterceptor(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logData(request, handler);
        return Boolean.TRUE;
    }

    private void logData(HttpServletRequest request, Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.hasMethodAnnotation(GetIP.class)) {
                LocalDateTime date = LocalDateTime.now();
                String remoteAddr = request.getRemoteAddr();
                LoggerDto loggerDto = new LoggerDto(date, remoteAddr);
                this.loggerService.log(loggerDto);
            }
        }
    }
}
