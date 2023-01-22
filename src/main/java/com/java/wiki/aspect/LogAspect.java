package com.java.wiki.aspect;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {

    private final static Logger LOG = LoggerFactory.getLogger(LogAspect.class);

    /*定义一个切点*/
    @Pointcut("execution(public * com.java.wiki.*.controller..*Controller.*(..))")
    public void controllerPointcut(){

    }

    @Before("controllerPointcut()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        //print request details
        LOG.info("--------------start----------------");
        LOG.info("request address:{} {}",request.getRequestURL().toString(),request.getMethod());
        LOG.info("class name:{}.{}",signature.getDeclaringTypeName(),name);

        //print request params
        Object[] args = joinPoint.getArgs();

        Object[] arguments = new Object[args.length];
        for(int i = 0; i < args.length; i++){
            if(args[i] instanceof ServletRequest ||
                args[i] instanceof ServletResponse ||
                args[i] instanceof MultipartFile){
                continue;
            }
            arguments[i] = args[i];
        }

        //exclude sensitive info
        String[] excludeProperties = {"password","file"};
        PropertyPreFilters filters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter excludeFilter = filters.addFilter();
        excludeFilter.addExcludes(excludeProperties);
        LOG.info("request params:{}", JSONObject.toJSONString(arguments,excludeFilter));
    }


}
