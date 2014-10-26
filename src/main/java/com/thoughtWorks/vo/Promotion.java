package com.thoughtWorks.vo;

import java.util.ArrayList;
import java.util.List;

public class Promotion {

    private int promotionId;
    private String promotionDescribe;
    private int type;

    private List<Item> itemList = new ArrayList<Item>();//取决于业务逻辑；

    public int getPromotionId() {
        return promotionId;
    }
    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionDescribe() {
        return promotionDescribe;
    }
    public void setPromotionDescribe(String promotionDescribe) {
        this.promotionDescribe = promotionDescribe;
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public Promotion(){

    }

    public Promotion(int promotionId, String promotionDescribe, int type) {
        this.promotionId = promotionId;
        this.promotionDescribe = promotionDescribe;
        this.type = type;
    }

    public Promotion(int promotionId, String promotionDescribe, int type, List<Item> itemList) {
        this.promotionId = promotionId;
        this.promotionDescribe = promotionDescribe;
        this.type = type;
        this.itemList = itemList;
    }
}
