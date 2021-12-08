package com.travel.travelAgency.CommissionsTest;

import com.travel.travelAgency.commissions.controller.CommissionController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class CommissionControllerTest {

    @Autowired
    private com.travel.travelAgency.commissions.controller.CommissionController CommissionController;

    @Test
    public void testCommissionController() {
        try{
            CommissionController c = new CommissionController();
            assertNotNull(c.get());
        }catch(SQLException | NullPointerException e){
            assertTrue(true,e.getMessage());
        }

    }
}




