package com.travel.travelAgency.CommissionsTest;


import com.travel.travelAgency.commissions.DAO.CommissionDAO;
import com.travel.travelAgency.commissions.models.Commission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CommissionDaoTest {

    @Autowired
    private com.travel.travelAgency.commissions.DAO.CommissionDAO CommissionDao;

    @Test
    public void testCommissionDao() {
        assertNull(CommissionDao);
    }
    @Test void testDisplayMethod() throws SQLException {
        assertNotNull(CommissionDAO.displayData());
    }
    @Test
    public void testCommissionDaoMethods() throws SQLException {

        assertTrue(CommissionDAO.putData(CommissionDAO.fetchData()));

    }
}
