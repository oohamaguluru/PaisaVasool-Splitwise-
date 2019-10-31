package com.fine.dao;

import com.fine.bean.Employee;
import com.fine.exception.InvalidOIDException;

public interface FineDAO {

	double addFine(int oID) throws InvalidOIDException;
	
	Employee viewFine(int oID)throws InvalidOIDException;
	
	boolean editFine(int oID, double newFine) throws InvalidOIDException;
}
