package com.pcy.proxy_study;

import com.pcy.proxy_study.dynamic_proxy.CglibProxyExample;
import com.pcy.proxy_study.dynamic_proxy.JDKProxyExample;
import com.pcy.proxy_study.static_proxy.BasketBallPlayer;
import com.pcy.proxy_study.static_proxy.BrokerProxy;

/**
 * 相当于客户端
 */
public class NBA {

    public static void main(String[] args) {
        staticProxy();
        System.out.println("*************************************************");
        jdkProxy();
        System.out.println("*************************************************");
        cglibProxy();
    }

    private static void cglibProxy() {
        CglibProxyExample cglibProxy = new CglibProxyExample();
        PlayBasketBallImpl proxy = (PlayBasketBallImpl) cglibProxy.getProxy(PlayBasketBallImpl.class);
        proxy.toPlayBasketBall();
    }

    private static void jdkProxy() {
        BasketBallPlayer player = new BasketBallPlayer("彭陈宇");
        JDKProxyExample jdkProxy = new JDKProxyExample();
        PlayBasketBall proxy = (PlayBasketBall) jdkProxy.bind(player);
        proxy.toPlayBasketBall();
    }

    private static void staticProxy() {
        BasketBallPlayer basketBallPlayer = new BasketBallPlayer("彭陈宇");
        BrokerProxy proxy = new BrokerProxy();
        proxy.setBasketBallPlayer(basketBallPlayer);
        proxy.toPlayBasketBall();
    }
}
