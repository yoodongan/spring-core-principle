package com.yoo.core.singleton;

// stateful 한 객체 생성, 이렇게 설계하면 뭐가 문제인지 알아보자.
public class StatefulService {
    private int price;

    public int order(String name, int price) {
        System.out.printf("%s가 %d만큼 주문했습니다.",name, price);
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

}
