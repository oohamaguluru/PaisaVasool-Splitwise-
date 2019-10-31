//@author pavithra
package com.fine.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fine.bean.Employee;
import com.fine.bean.User;
import com.fine.dao.UserDAO;
import com.fine.exception.InvalidOIDException;

public class UserDAOImpl implements UserDAO {
	static Connection connection;

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		connection = ModelDAO.openConnection();
		// String name = employee.getName();
		int id = user.getoID();

		String sql = "insert into employeeTable values (?,?,?,?)";

		String sql1 = "insert into userTable(name,oracleID) values(?,?) ";

		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		try {

			statement = connection.prepareStatement(sql);
			statement1 = connection.prepareStatement(sql1);
			statement.setInt(1, user.getoID());
			statement.setString(2, user.getName());
			statement.setDouble(3, 0);
			statement.setInt(4, 0);
			statement1.setString(1, user.getName());
			statement1.setInt(2, user.getoID());
			statement.execute();
			statement1.execute();

			System.out.println("Query executed in addUser");

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
				if (statement1 != null)
					statement1.close();
				ModelDAO.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}

	@Override
	public boolean deleteUser(int oID) throws InvalidOIDException {
		connection = ModelDAO.openConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		// String insertQuery
		try {

			String insertQuery = "delete from employeeTable where oID =?";
			preparedStatement = connection.prepareStatement(insertQuery, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String insertQuery2 = "delete from usertable where oID=?";
			preparedStatement2 = connection.prepareStatement(insertQuery2, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			preparedStatement.setInt(1, oID);
			preparedStatement.executeQuery();
			
			preparedStatement2.setInt(1, oID);
			preparedStatement2.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (preparedStatement2 != null)
					preparedStatement2.close();
				ModelDAO.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
		
		return true;

	}

	@Override
	public List<Employee> viewUsers() {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<Employee>();
		connection = ModelDAO.openConnection();
		PreparedStatement preparedStatement = null;
		String select = "select * from employeeTable";

		try {
			preparedStatement = connection.prepareStatement(select);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				int id = rs.getInt("oID");
				double fine = rs.getDouble("fine");
				int late = rs.getInt("late");
				// Course course = new Course();
				Employee employee = new Employee();
				employee.setName(name);
				employee.setoID(id);
				employee.setFine(fine);
				employee.setTimeslate(late);

				list.add(employee);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
				ModelDAO.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean logInUser(User user) {

		connection = ModelDAO.openConnection();
		String UserName = user.getName();
		String UserPassword = user.getPassword();
		int OID = user.getoID();
		// System.out.println(UserName+UserPassword);
		String sql = "select * from userTable where oracleID=? and password=?";

		PreparedStatement statement = null;
		try {
			PreparedStatement p1 = null;
			p1 = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			p1.setInt(1, user.getoID());
			p1.setString(2, user.getPassword());
			ResultSet rs = p1.executeQuery();
			if(!rs.next()) {
				return false;
			}
			

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} finally {
			try {

				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
				ModelDAO.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public Employee getEmployeeByID(int oID) {
		Employee employee = new Employee();
		PreparedStatement preparedStatement = null;
		connection = ModelDAO.openConnection();
		String viewQuery = "select * from employeetable where oid = ?";

		try {
			preparedStatement = connection.prepareStatement(viewQuery);
			preparedStatement.setInt(1, oID);
			ResultSet result = preparedStatement.executeQuery();

			if (result.next()) {
				employee.setName(result.getString("name"));
				employee.setTimeslate(result.getInt("late"));
				employee.setoID(oID);
				employee.setFine(result.getInt("fine"));
			} else {
				System.out.println("no such user found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
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

	@Override
	public boolean changePassword(int oID, String newPassword) throws InvalidOIDException{
		// TODO Auto-generated method stub
		boolean flag = false;
		connection = ModelDAO.openConnection();

		PreparedStatement preparedStatement2 = null;

		String updateQuery = "update usertable set password = ? where oracleid = ?";

		try {


				
				preparedStatement2 = connection.prepareStatement(updateQuery);
				preparedStatement2.setString(1, newPassword);
				preparedStatement2.setInt(2, oID);
				preparedStatement2.execute();
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement2 != null)
					preparedStatement2.close();
				ModelDAO.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public User getUserByID(int oID) {
		connection = ModelDAO.openConnection();
		User user = new User();
		PreparedStatement preparedStatement = null;
		String sql = "select * from usertable where oracleid = ?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, oID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user.setoID(oID);
				user.setName(resultSet.getString("name"));
				user.setImageName(resultSet.getString("imagename"));
				
			}
			else {
				System.out.println("No such user");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public boolean uploadImage(String imageName, int oID) {
		connection = ModelDAO.openConnection();
		PreparedStatement preparedStatement = null;
		String sql = "update usertable set imagename=? where oracleid=?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, imageName);
			preparedStatement.setInt(2, oID);
			preparedStatement.executeUpdate();
			System.out.println("Entered image name into db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}

}
