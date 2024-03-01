package com.dorjear.training.fundamental.popularity;

interface MostPopular {

    void increasePopularity(Integer contentId);

    Integer mostPopular();

    Integer mostPopularContentId();

    void decreasePopularity(Integer contentId);
}