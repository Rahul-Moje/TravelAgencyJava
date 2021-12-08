package com.travel.travelAgency.search.dao;

import com.travel.travelAgency.search.models.FareInterval;
import com.travel.travelAgency.search.repository.FareIntervalRepository;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author rahulmoje
 */
public class FareIntervalDaoTest {

    private FareIntervalRepository fareIntervalRepository = new FareIntervalDAO();


    @Test
    public void testRetrieveFareIntervals() throws SQLException {
        List<FareInterval> actualResults = fareIntervalRepository.retrieveFareIntervals();
        Assert.assertNotNull(actualResults);
        Assert.assertFalse(actualResults.isEmpty());
        for(FareInterval actualResult : actualResults) {
            Assert.assertNotNull(actualResult.getIntervalStart());
            Assert.assertNotNull(actualResult.getIntervalEnd());
            Assert.assertNotNull(actualResult.getPercentageIncrease());
        }
    }
}
