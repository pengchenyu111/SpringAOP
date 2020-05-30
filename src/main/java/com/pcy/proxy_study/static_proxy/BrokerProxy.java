package com.pcy.proxy_study.static_proxy;

import com.pcy.proxy_study.PlayBasketBall;
import com.pcy.proxy_study.static_proxy.BasketBallPlayer;

/**
 * 经纪人
 */
public class BrokerProxy implements PlayBasketBall {

    private BasketBallPlayer basketBallPlayer;

    public void setBasketBallPlayer(BasketBallPlayer basketBallPlayer) {
        this.basketBallPlayer = basketBallPlayer;
    }

    @Override
    public void toPlayBasketBall() {
        System.out.println("赛前帮助球星！");
        basketBallPlayer.toPlayBasketBall();
        System.out.println("赛后帮助球星！");
    }
}
