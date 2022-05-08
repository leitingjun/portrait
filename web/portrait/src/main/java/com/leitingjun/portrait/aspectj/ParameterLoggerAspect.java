package com.leitingjun.portrait.aspectj;

import com.leitingjun.portrait.anno.ParameterLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.ConstructorSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ParameterLoggerAspect {
    private final static Logger logger= LoggerFactory.getLogger(ParameterLoggerAspect.class);
    @Pointcut("@within(com.leitingjun.portrait.anno.ParameterLogger)")
    public void pointcut(){

    }
    @Before(value = "pointcut()")
    public void ParamLog(JoinPoint joinPoint){

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        ParameterLogger parameterLogger = signature.getMethod().getAnnotation(ParameterLogger.class);
        String name = signature.getMethod().getName();
        Object[] array = Arrays.stream(signature.getMethod().getParameters()).toArray();
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(signature.getMethod());
        StringBuffer params = new StringBuffer();
        if (args != null && paramNames != null) {
            for (int i = 0; i < args.length; i++) {
                params.append(paramNames[i]).append(":").append(args[i]).append("  ");
            }
        }
        logger.info("用户id:"+parameterLogger.userId()+",方法名:"+name+",入参:   "+ params);
    }
    @AfterReturning(value = "pointcut()",returning = "data")
    public void ResultLog(JoinPoint joinPoint,Object data){
        Signature signature = joinPoint.getSignature();
        logger.info("出参为:"+data.toString());
    }
}
