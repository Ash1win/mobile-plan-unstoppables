package com.hansen.mobileplan.srvc;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hansen.mobileplan.dao.EmployeeDao;
import com.hansen.mobileplan.dao.MobilePlanDao;
import com.hansen.mobileplan.model.Employee;
import com.hansen.mobileplan.model.MobilePlan;

@Service
public class EmployeeSrvc {
	
	@Autowired
	EmployeeDao empDao;
	
	@Autowired
	MobilePlanDao mobilePlanDao;
	
	@Autowired
	MobilePlanSrvc mpSrvc;
	
	public Object create(Employee entity, long planid) {
		
		MobilePlan mp = (MobilePlan) mpSrvc.read(planid);
		entity.setMobilePlan(mp);
		Object emp = empDao.save(entity);
		
		return emp;
	}
	
	public Object update(Employee entity, long planid) {
		MobilePlan mp = (MobilePlan) mpSrvc.read(planid);
		entity.setMobilePlan(mp);
		Object emp = empDao.save(entity);
		
		return emp;
	}
	
}
