package com.travel.travelAgency.commissions.controller;
import com.travel.travelAgency.commissions.models.Commission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travel.travelAgency.commissions.interfaces.ICommission;

import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
public class CommissionController {

        @Autowired
        ICommission commInterface;

    @RequestMapping(value = "/commission")
    public ModelAndView get() throws SQLException {
        ModelAndView mav = new ModelAndView("commission");
        List<Commission> list = commInterface.fetchData();
        boolean isInserted = commInterface.putData(list);
        List<Commission> display = commInterface.displayData();
        mav.addObject("list", display);
        return mav;
    }

    }

