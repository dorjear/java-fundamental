package com.dorjear.training.fundamental.popularity;

import java.util.*;

public class MostPopularImpl implements MostPopular {

    private Map<Integer, ContentPopularity> popularityMap = new HashMap<>();

    private Integer max = -1;
    private Integer maxId = -1;

    @Override
    public void increasePopularity(Integer contentId) {
        ContentPopularity theOne = popularityMap.get(contentId);
        if (theOne == null) {
            popularityMap.put(contentId, new ContentPopularity(contentId, 0));
            return;
        }
        theOne.setPopularity(theOne.getPopularity() + 1);
        if (theOne.getPopularity() >= max) {
            max = theOne.getPopularity();
            maxId = theOne.getContentId();
        }
    }

    private ContentPopularity getContentPopularity(Integer contentId) {
        ContentPopularity theOne = popularityMap.get(contentId);
        if (theOne == null) {
            popularityMap.put(contentId, new ContentPopularity(contentId, 0));
        }
        return theOne;
    }

    @Override
    public Integer mostPopular() {
        return max > 0 ? max : -1;
    }

    @Override
    public Integer mostPopularContentId() {
        return maxId > 0 ? maxId : -1;
    }

    @Override
    public void decreasePopularity(Integer contentId) {
        ContentPopularity theOne = popularityMap.get(contentId);
        if (theOne == null) {
            popularityMap.put(contentId, new ContentPopularity(contentId, 0));
            return;
        }
        if (theOne.getPopularity() > 0) theOne.setPopularity(theOne.getPopularity() - 1);

        if (theOne.getContentId() == maxId) {
            ContentPopularity mostPopular = popularityMap.values().stream().max(Comparator.comparingInt(ContentPopularity::getPopularity)).get();
            if (mostPopular.getPopularity() <= 0) {
                max = -1;
                maxId = -1;
            } else {
                max = mostPopular.getPopularity();
                maxId = mostPopular.getContentId();
            }
        }
    }
}
