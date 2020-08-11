package com.imooc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME: com.imooc.aspect
 * @NAME: ServiceLogAspect
 * @USER: code.rookie
 * @DATE: 2020/6/22
 * @TIME: 11:39 上午
 * @DAY_NAME_SHORT: 周一
 * @PROJECT_NAME: foodie-dev
 */
@Aspect
@Component
public class ServiceLogAspect {
    /**
     * 1、前置通知
     * 2、后置通知
     * 3、环绕通知
     * 4、异常通知
     * 5、最终通知
     * 切面表达式
     * execution 代表所有要执行的表达式主题
     * 第一处 * 代表返回类型 *代表所有类型
     * 第二处 代表aop监控所代表的包
     * 第三处 .. 代表该包以及以下的所有类方法
     * 第四处 * 代表类名 *代表所有类
     * 第五次*（..）*代表类中的方法名，（..）表示方法中的任何参数
     */

    public static final Logger log = LoggerFactory.getLogger(ServiceLogAspect.class);
    @Around("execution(* com.imooc.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("=======  开始执行 {}.{} ========",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());
        //记录开始时间
        long begin =System.currentTimeMillis();
        //执行目标 service
        Object result = joinPoint.proceed();
       //记录结束时间
        long end = System.currentTimeMillis();
        long takeTime = end - begin;
        if (takeTime > 3000){
            log.error("======== 执行结束,耗时：{} 毫秒 =======",takeTime);
        }else if (takeTime > 2000){
            log.warn("======== 执行结束,耗时：{} 毫秒 =======",takeTime);
        }else {
            log.info("======== 执行结束,耗时：{} 毫秒 =======",takeTime);
        }
        return result;


    }
}
