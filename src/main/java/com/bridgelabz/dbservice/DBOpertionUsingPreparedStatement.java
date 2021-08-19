package com.bridgelabz.dbservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.config.DBConfiguration;
import com.bridgelabz.entity.Employee;

public class DBOpertionUsingPreparedStatement {
	DBConfiguration dbConfiguration =new DBConfiguration();
	 PreparedStatement preparedstatement = null;
	 // Connection connection=null;
	 Connection connection = dbConfiguration.getConnection();
	//Statement statement = null;
	
	final String CREATE_TABLE_QUERY ="create table IF NOT EXISTS employee(id int,name varchar(255),salary int)";	
	final String INSERT_QUERY ="INSERT INTO employee(id ,name ,salary)VALUES (?,?,?)";
	final String FETCH_QUERY="SELECT * FROM employee";
	final  String UPDATE_QUERY="UPDATE employee SET salary=? WHERE ID=?";
	

	public void createTable() {
		
		try {
			preparedstatement=connection.prepareStatement(CREATE_TABLE_QUERY);
			preparedstatement.execute();
			System.out.println("Table Created Sucessfully!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int insertRecordsInTable() {
		Scanner scanner = new Scanner(System.in);
		List<Employee>emp = new ArrayList<Employee>();
		Employee employee = new Employee(scanner.nextInt(),scanner.next(),scanner.nextInt());
		emp.add(employee);
	    
		try {
			preparedstatement = connection.prepareStatement(INSERT_QUERY);
			preparedstatement.setInt(1, id);
			preparedstatement.setString(2, name);
			preparedstatement.setInt(3, salary);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	/*	preparedstatement = connection.prepareStatement(INSERT_QUERY);
		preparedstatement.setInt(1, id);
		preparedstatement.setString(2, name);
		preparedstatement.setInt(3, salary);
		*/
		
		try {
			preparedstatement = connection.prepareStatement(INSERT_QUERY);
			Iterator<Employee> iterator= emp.iterator();
			while (iterator.hasNext()) {
			Employee employee1 =iterator.next();
			
			preparedstatement.setInt(1, employee1.getId());
			preparedstatement.setString(2, employee1.getName());
			preparedstatement.setInt(3, employee1.getSalary());
			
			}
			preparedstatement.addBatch();
		preparedstatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	
		
	/*try {
			statement=conn.createStatement();
			statement.execute(INSERT_QUERY);
			System.out.println("Record inserted Sucessfully!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;*/
	}

	
	public void updateEmployeeDetails() {
		try {
		connection.setAutoCommit(false);
		ResultSet resultSet =null;
		PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_QUERY);
		Savepoint sp = connection.setSavepoint("First Save Point");
		
		preparedStatement.setInt((1,20000);
		preparedStatement.setInt(2,1);
		preparedStatement.executeUpdate();
		
		System.out.println("After First Update:");
		resultSet =preparedStatement.executeQuery(FETCH_QUERY);
		while (resultSet.next()) {
			System.out.println("Name: " + resultSet.getString(2));
			System.out.println("Salary: "+resultSet.getInt(3) );
			System.out.println();
		}
		connection.rollback();
		connection.commit();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


	@Override
	public void fetchAllRecords() {
		int[] updateRow = null;
		
		try {
			updateRow =preparedstatement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("Number of updated row: "+updateRow);
		
		
		
		
	}

}
