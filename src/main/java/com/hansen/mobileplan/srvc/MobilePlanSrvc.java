package com.hansen.mobileplan.srvc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hansen.mobileplan.dao.MobilePlanDao;
import com.hansen.mobileplan.model.MobilePlan;

@Service
public class MobilePlanSrvc {

	@Autowired
	MobilePlanDao mobilePlanDao;

	public Object create(MobilePlan entity) {

		MobilePlan mobilePlan = mobilePlanDao.save(entity);
		return mobilePlan;

	}

	public Object read(Long id) {
		Optional<MobilePlan> person = mobilePlanDao.findById(id);
		if (person.isPresent()) {
			return person.get();
		} else {
			return null;
		}

	}

	public Iterable<MobilePlan> readAll() {
		Iterable<MobilePlan> mobilePlanList = mobilePlanDao.findAll();
		return mobilePlanList;
	}

	public Object update(MobilePlan tobemerged) {
		//TODO Homework... write the code to upgrade
		MobilePlan mobileplan = mobilePlanDao.save(tobemerged);
		
		return mobileplan;
	}

	public boolean delete(Long planid) {
		//TODO Homework... write the code to delete
		
		Optional<MobilePlan> person = mobilePlanDao.findById(planid);
		
		if (person.isPresent()) {
			mobilePlanDao.deleteById(planid);
			return true;
		}
		
		
		
		return false;
	}
}
