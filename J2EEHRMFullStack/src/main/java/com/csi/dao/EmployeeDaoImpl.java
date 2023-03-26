package com.csi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csi.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection connection = null;

	public EmployeeDaoImpl() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrmfullstackapplication", "root",
						"root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void signUp(Employee employee) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into employee(empid, empname, empaddress, empcontactnumber, empage, empsalary, empgender, empdob, empemailid, emppassword) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setString(3, employee.getEmpAddress());
			preparedStatement.setLong(4, employee.getEmpContactNumber());
			preparedStatement.setInt(5, employee.getEmpAge());
			preparedStatement.setDouble(6, employee.getEmpSalary());
			preparedStatement.setString(7, employee.getEmpGender());
			
			
			preparedStatement.setDate(8, new java.sql.Date(employee.getEmpDOB().getTime()));
			preparedStatement.setString(9, employee.getEmpEmailId());
			preparedStatement.setString(10, employee.getEmpPassword());

			preparedStatement.executeUpdate();

			System.out.println("Signup Done Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub

		boolean flag = false;

		for (Employee employee : getAllData()) {
			if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
				flag = true;
			}
		}

		return flag;
	}

	@Override
	public Employee getDataById(int empId) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where empid=?");

			preparedStatement.setInt(1, empId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpAddress(resultSet.getString(3));
				employee.setEmpContactNumber(resultSet.getLong(4));
				employee.setEmpAge(resultSet.getInt(5));
				employee.setEmpSalary(resultSet.getDouble(6));
				employee.setEmpGender(resultSet.getString(7));
				employee.setEmpDOB(resultSet.getDate(8));
				employee.setEmpEmailId(resultSet.getString(9));
				employee.setEmpPassword(resultSet.getString(10));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public List<Employee> getAllData() {
		// TODO Auto-generated method stub

		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpAddress(resultSet.getString(3));
				employee.setEmpContactNumber(resultSet.getLong(4));
				employee.setEmpAge(resultSet.getInt(5));
				employee.setEmpSalary(resultSet.getDouble(6));
				employee.setEmpGender(resultSet.getString(7));
				employee.setEmpDOB(resultSet.getDate(8));
				employee.setEmpEmailId(resultSet.getString(9));
				employee.setEmpPassword(resultSet.getString(10));

				employees.add(employee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public void updateData(int empId, Employee employee) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update employee set empname=?, empaddress=?, empcontactnumber=?, empage=?, empsalary=?, empgender=?, empdob=?, empemailid=?, emppassword=? where empid=?");

			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setString(2, employee.getEmpAddress());
			preparedStatement.setLong(3, employee.getEmpContactNumber());
			preparedStatement.setInt(4, employee.getEmpAge());
			preparedStatement.setDouble(5, employee.getEmpSalary());
			preparedStatement.setString(6, employee.getEmpGender());
			preparedStatement.setDate(7, new java.sql.Date(employee.getEmpDOB().getTime()));
			preparedStatement.setString(8, employee.getEmpEmailId());
			preparedStatement.setString(9, employee.getEmpPassword());
			preparedStatement.setInt(10, employee.getEmpId());

			preparedStatement.executeUpdate();

			System.out.println("Data Updated Successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteDataById(int empId) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where empid=?");

			preparedStatement.setInt(1, empId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
