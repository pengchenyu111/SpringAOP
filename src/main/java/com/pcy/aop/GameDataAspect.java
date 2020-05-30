package com.pcy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class GameDataAspect {

    /**
     * 定义切入点，
     * 通过@Pointcut注解声明频繁使用的切点表达式
     * && args(object)) 传递参数
     *
     */
    @Pointcut("execution(public * com.pcy.controller.PlayerController.*(..)) && args(object))")
    public void GameDataAspect(Object object){

    }

    /**
     * @description  使用环绕通知
     */
    @Around("GameDataAspect(object)")
    public void doAroundGameData(ProceedingJoinPoint pjp, Object object) throws Throwable {
        try{
            System.out.println("球星上场前热身！");
            pjp.proceed();
            System.out.println("球星本场得到" + object + "分" );
        }
        catch(Throwable e){
            System.out.println("异常通知：球迷要求退票！");
        }
    }
}
