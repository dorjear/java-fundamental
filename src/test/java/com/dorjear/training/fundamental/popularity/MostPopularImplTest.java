package com.dorjear.training.fundamental.popularity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MostPopularImplTest {

    @Test
    public void testGetPopularityWhenMapIsNull() {
        MostPopular toTest = new MostPopularImpl();
        assertEquals(-1, toTest.mostPopular());
    }

    @Test
    public void testDecreasePopula_decreateFirstTime() {
        MostPopular toTest = new MostPopularImpl();
        toTest.decreasePopularity(1);
        Integer result = toTest.mostPopular();
        assertEquals(-1, result);
    }

    @Test
    public void testDecreasePopula_decreateTwice() {
        MostPopular toTest = new MostPopularImpl();
        toTest.decreasePopularity(1);
        toTest.decreasePopularity(1);
        Integer result = toTest.mostPopular();
        assertEquals(-1, result);
    }

    @Test
    public void testIncreasePopula_iecreateFirstTime() {
        MostPopular toTest = new MostPopularImpl();
        toTest.decreasePopularity(1);
        Integer result = toTest.mostPopular();
        assertEquals(-1, result);
    }

    @Test
    public void testIncreasePopula_increateTwice() {
        MostPopular toTest = new MostPopularImpl();
        toTest.increasePopularity(1);
        toTest.increasePopularity(1);
        Integer result = toTest.mostPopular();
        assertEquals(1, result);
    }

    @Test
    public void integrationTest() {
        MostPopular popularityTracker = new MostPopularImpl();

        popularityTracker.increasePopularity(7);

        popularityTracker.increasePopularity(7);

        popularityTracker.increasePopularity(8);

        assertEquals(7, popularityTracker.mostPopularContentId());

        popularityTracker.increasePopularity(8);

        popularityTracker.increasePopularity(8);

        assertEquals(8, popularityTracker.mostPopularContentId());        // returns 8

        popularityTracker.decreasePopularity(8);

        popularityTracker.decreasePopularity(8);

        assertEquals(7, popularityTracker.mostPopularContentId());

        popularityTracker.decreasePopularity(7);

        popularityTracker.decreasePopularity(7);

        popularityTracker.decreasePopularity(8);

        popularityTracker.increasePopularity(7);

        popularityTracker.increasePopularity(7);

        popularityTracker.increasePopularity(8);

        assertEquals(7, popularityTracker.mostPopularContentId());

        popularityTracker.increasePopularity(8);

        popularityTracker.increasePopularity(8);

        assertEquals(8, popularityTracker.mostPopularContentId());

        popularityTracker.decreasePopularity(8);

        popularityTracker.decreasePopularity(8);

        assertEquals(7, popularityTracker.mostPopularContentId());

        popularityTracker.decreasePopularity(7);

        popularityTracker.decreasePopularity(7);

        popularityTracker.decreasePopularity(8);

        assertEquals(-1, popularityTracker.mostPopularContentId());

    }
}
