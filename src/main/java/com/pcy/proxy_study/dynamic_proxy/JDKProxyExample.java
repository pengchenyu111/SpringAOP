package com.pcy.proxy_study.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 动态代理
 *
 *
 * InvocationHandler :通过一个代理实例调用处理程序实现的接口
 * ==> 解决：
 *          1.代理对象只服务于一种类型的对象，如果要服务多类型的对象。势必要为每一种对象都进行代理，静态代理在程序规模稍大时就无法胜任了。
 *          2.如果接口改变，那么代理类也要改变
 */
public class JDKProxyExample implements InvocationHandler {

    //真实对象
    private Object target = null;

    /**
     * 奖励真实对象和代理对象的的关系，并返回代理对象
     * @param target 真实对象
     * @return 代理对象
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //类加载器
                target.getClass().getInterfaces(), //接口
                this //调用处理程序
        );
    }

    /**
     * 在代理实例上处理方法调用，并返回结果。当在与它关联的代理实例上调用方法时，该方法将在调用处理程序上调用此方法。
     * @param proxy 代理对象，就是bind生成的代理对象
     * @param method 当前调度的方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理...");
        System.out.println("在代理前可提供其他增值服务！");
        Object o = method.invoke(target, args);//真实对象做自己的事
        System.out.println("真实对象做完后，代理提供之后的增值服务！");
        return o;
    }
}
