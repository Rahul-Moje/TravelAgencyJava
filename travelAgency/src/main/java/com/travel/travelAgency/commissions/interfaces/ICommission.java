package com.travel.travelAgency.commissions.interfaces;

import com.travel.travelAgency.commissions.models.Commission;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface ICommission {


    List<Commission> fetchData() throws SQLException;


    @Transactional
    boolean putData(List<Commission> list);

     List<Commission> displayData() throws SQLException;
}
