package com.fine.service.impl;

import com.fine.bean.Employee;
import com.fine.dao.FineDAO;
import com.fine.dao.impl.FineDAOImpl;
import com.fine.exception.InvalidOIDException;
import com.fine.service.FineService;

public class FineServiceImpl implements FineService {

	@Override
	public double addFine(int oID) throws InvalidOIDException{
		// TODO Auto-generated method stub
		double fine = 0;
		FineDAO fineService = new FineDAOImpl();
		fine = fineService.addFine(oID);
		return fine;
	}

	@Override
	public Employee viewFine(int oID) throws InvalidOIDException{
		// TODO Auto-generated method stub
		
		FineDAO fineChecker = new FineDAOImpl();
		Employee employee = fineChecker.viewFine(oID);
		return employee;
	}

	@Override
	public boolean editFine(int oID, double newFine) throws InvalidOIDException{
		// TODO Auto-generated method stub
		boolean flag = false;
		FineDAO fineEdit = new FineDAOImpl();
		flag = fineEdit.editFine(oID, newFine);
		return flag;
	}

}
