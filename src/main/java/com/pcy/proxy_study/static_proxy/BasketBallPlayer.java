package com.pcy.proxy_study.static_proxy;

import com.pcy.proxy_study.PlayBasketBall;

/**
 * 真实对象
 */
public class BasketBallPlayer implements PlayBasketBall {

    private String name;

    public BasketBallPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BasketBallPlayer{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void toPlayBasketBall() {
        System.out.println(this.name + "球星只管打篮球就可！");
    }
}
