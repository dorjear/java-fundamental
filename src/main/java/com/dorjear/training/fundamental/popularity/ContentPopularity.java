package com.dorjear.training.fundamental.popularity;

public class ContentPopularity {
    private Integer contentId;
    private Integer popularity;

    public ContentPopularity(Integer contentId, Integer popularity) {
        this.contentId = contentId;
        this.popularity = popularity;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }
}
