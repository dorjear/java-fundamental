package com.dorjear.training.fundamental.popularity;

import java.util.*;

public class MostPopularImpl implements MostPopular {

    private Map<Integer, ContentPopularity> popularityMap = new HashMap<>();

    private Integer max = -1;
    private Integer maxId = -1;

    private final Object lock = new Object(); // For synchronizing max tracking

    @Override
    public void increasePopularity(Integer contentId) {
        popularityMap.compute(contentId, (id, existing) -> {
            if (existing == null) {
                existing = new ContentPopularity(id, 0);
            }
            existing.setPopularity(existing.getPopularity() + 1);
            return existing;
        });

        ContentPopularity updated = popularityMap.get(contentId);

        synchronized (lock) {
            if (updated.getPopularity() > max ||
                    (updated.getPopularity() == max && contentId < maxId)) {
                max = updated.getPopularity();
                maxId = contentId;
            }
        }
    }

    public int getMostPopularContentId() {
        synchronized (lock) {
            return maxId;
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
        ContentPopularity updated = popularityMap.compute(contentId, (id, existing) -> {
            if (existing == null) {
                return new ContentPopularity(id, 0);
            }
            int current = existing.getPopularity();
            if (current > 0) {
                existing.setPopularity(current - 1);
            }
            return existing;
        });

        synchronized (lock) {
            if (contentId.equals(maxId)) {
                // Recalculate max only if current max may have changed
                ContentPopularity newMax = popularityMap.values().stream()
                        .max(Comparator.comparingInt(ContentPopularity::getPopularity))
                        .orElse(null);

                if (newMax == null || newMax.getPopularity() <= 0) {
                    max = -1;
                    maxId = -1;
                } else {
                    max = newMax.getPopularity();
                    maxId = newMax.getContentId();
                }
            }
        }
    }
}
