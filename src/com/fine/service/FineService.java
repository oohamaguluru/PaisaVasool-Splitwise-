//@author foram
package com.fine.service;

import com.fine.bean.Employee;
import com.fine.exception.InvalidOIDException;

public interface FineService {

	double addFine(int oID) throws InvalidOIDException;
	
	Employee viewFine(int oID) throws InvalidOIDException;
	
	boolean editFine(int oID, double newFine) throws InvalidOIDException;
}
