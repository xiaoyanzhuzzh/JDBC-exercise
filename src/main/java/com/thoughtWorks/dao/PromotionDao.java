package com.thoughtWorks.dao;

import com.thoughtWorks.vo.Promotion;

import java.util.List;

public interface PromotionDao {
    Promotion getPromotionById(int id);
    List<Promotion> getPromotions();
    void insertPromotion(Promotion promotion);
    void deletePromotionById(int id);
    void updatePromtion(Promotion promotion);
}
