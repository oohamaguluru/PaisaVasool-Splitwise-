//@author foram

package com.fine.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fine.bean.Employee;
import com.fine.dao.FineDAO;
import com.fine.exception.InvalidOIDException;

public class FineDAOImpl implements FineDAO {

	static Connection connection;

	/*-------------------------------------------------------------------------------------------------------------------------------
	 * This method is used to add the fine of the employee with given Oracle id. It will search for the oracle ID in the database and get the
	 * old fine. Based on the current time the fine is calculated and it is added to the old fine. The database is then updated and the
	 * total fine is then added to the database. The total fine that is calculated is returned to the service layer and from there to the servlet. 
	 * If the Oracle ID is not found in the database then the method will throw InvalidOIDException. 
	---------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public double addFine(int oID) throws InvalidOIDException {
		// TODO Auto-generated method stub
		double newFine = 0;
		
		connection = ModelDAO.openConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;

		String addFineQuery = "select fine, late from employeetable where oid = ?";
		String updateQuery = "update employeetable set fine = ?, late = ? where oid = ?";

		try {
			preparedStatement = connection.prepareStatement(addFineQuery);
			preparedStatement.setInt(1, oID);
			ResultSet result = preparedStatement.executeQuery();
			
			if (result.next()) {
				// logic for newFine
				DateFormat dateFormat = new SimpleDateFormat("hh");
				DateFormat dateFormat2 = new SimpleDateFormat("mm");
				DateFormat dateFormat3 = new SimpleDateFormat("a");
				Date date = new Date();
				String hour = dateFormat.format(date);
				String min = dateFormat2.format(date);
				String am = dateFormat3.format(date);
				int hours = Integer.parseInt(hour);
				int mins = Integer.parseInt(min);
				if((am.equals("PM")&& hours>=5) || (am.equals("AM")&&hours<8) || (am.equals("AM")&&hours==12)){
					newFine = 0;
				}else if((am.equals("AM")&& hours==8)){
					if(mins<=10){
						newFine = 10;
					}else if(mins>10 && mins<=20){
						newFine =20;
					}else{
						newFine =30;
					}
				}else if ((am.equals("AM")&& hours==8 && mins>30) || (am.equals("PM")&& hours <5) || (am.equals("AM")&& hours>8) || (am.equals("PM")&&hours==12)){
					newFine =100;
				}
				
				double oldFine = result.getDouble("fine"); // Retrieves the old fine
				int late = result.getInt("late");
				if(newFine!=0) late++;
				double totalFine = newFine + oldFine; // Calculates the total fine
				preparedStatement2 = connection.prepareStatement(updateQuery);
				preparedStatement2.setDouble(1, totalFine);
				preparedStatement2.setInt(2, late);
				preparedStatement2.setLong(3, oID);
				preparedStatement2.execute();
			}else{
				throw new InvalidOIDException("No such Oracle ID found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (preparedStatement2 != null)
					preparedStatement.close();
				ModelDAO.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newFine;
	}

	/*-------------------------------------------------------------------------------------------------------------------------------
	 * This method is used to view the fine of the employee with given Oracle id. It will search for the oracle ID in the database and project
	 * the fine of that particular id. The fine will be stored in a temporary variable and it would be returned to the service layer. If the 
	 * Oracle ID is not found in the database then the method will throw InvalidOIDException. 
	---------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public Employee viewFine(int oID) throws InvalidOIDException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		connection = ModelDAO.openConnection();
		String viewQuery = "select * from employeetable where oid = ?";
		Employee employee = new Employee();
		try {
			preparedStatement = connection.prepareStatement(viewQuery);
			preparedStatement.setInt(1, oID);
			ResultSet result = preparedStatement.executeQuery();

			if (result.next()) {
				
				String name = result.getString(2);
				double fine = result.getDouble(3);
				int late = result.getInt(4);
				
				employee.setFine(fine);
				employee.setName(name);
				employee.setoID(oID);
				employee.setTimeslate(late);
			} else {
				throw new InvalidOIDException("No such Oracle ID found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				ModelDAO.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
	}

	/*-------------------------------------------------------------------------------------------------------------------------------
	 * This method is used to edit the fine of the employee in case of any discrepancies in fine. The oracle id and the newfine amount will 
	 * be passed as parameters. First will check whether the oracle id is there in the database. If it is there then the newfine is updated
	 * to the database. If the oracle id is not found then InvalidOIDException will be thrown. 
	---------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public boolean editFine(int oID, double newFine) throws InvalidOIDException {
		// TODO Auto-generated method stub
		boolean flag = false;

		connection = ModelDAO.openConnection();

		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;

		String addFineQuery = "select late from employeetable where oid = ?";
		String updateQuery = "update employeetable set fine = ?, late = ? where oid = ?";

		try {

			preparedStatement = connection.prepareStatement(addFineQuery);
			preparedStatement.setInt(1, oID);
			ResultSet result = preparedStatement.executeQuery();

			if (result.next()) {
				flag = true;
				int late = result.getInt("late");
				late--;
				preparedStatement2 = connection.prepareStatement(updateQuery);
				preparedStatement2.setDouble(1, newFine);
				preparedStatement2.setInt(2, late);
				preparedStatement2.setLong(3, oID);
				preparedStatement2.execute();
			} else {
				throw new InvalidOIDException("No such Oracle ID found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (preparedStatement2 != null)
					preparedStatement2.close();
				ModelDAO.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

}
