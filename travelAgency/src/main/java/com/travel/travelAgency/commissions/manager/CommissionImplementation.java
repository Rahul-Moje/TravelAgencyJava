package com.travel.travelAgency.commissions.manager;
import com.travel.travelAgency.commissions.DAO.CommissionDAO;
import  com.travel.travelAgency.commissions.interfaces.ICommission;
import com.travel.travelAgency.commissions.models.Commission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class CommissionImplementation implements ICommission{

    @Autowired
    private CommissionDAO commissionDAO;

    @Transactional
    @Override
    public List<Commission> fetchData() throws SQLException {

        return CommissionDAO.fetchData();
    }

    @Transactional
    @Override
    public boolean putData(List<Commission> list){

        return CommissionDAO.putData( list);
    }
    @Transactional
    @Override
    public List<Commission> displayData() throws SQLException {

        return CommissionDAO.displayData();


    }
}
