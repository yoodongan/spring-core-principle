package com.yoo.core.order;

public class Order {
    private long memberId;
    private String itemName;
    private int itempPrice;
    private int discountPrice;

    public Order(long memberId, String itemName, int itempPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itempPrice = itempPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice() {
        return itempPrice - discountPrice;
    }

    @Override
    public String toString() {  // 데이터 한 눈 에 볼 수 있도록.
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itempPrice=" + itempPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItempPrice() {
        return itempPrice;
    }

    public void setItempPrice(int itempPrice) {
        this.itempPrice = itempPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
}
