package com.bridgelabz.dbservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.config.DBConfiguration;

public class DBOpertionUsingStatement implements IDBOperation {
	DBConfiguration dbConfiguration =new DBConfiguration();
	Connection conn = dbConfiguration.getConnection();
	Statement statement = null;
	
	final String CREATE_TABLE_QUERY ="create table IF NOT EXISTS employee(id int,name varchar(255),salary int)";	
	 final String INSERT_QUERY ="INSERT INTO employee(id ,name ,salary)VALUES (1,'Rahul',12000)";
	 final String SELECT_QUERY="SELECT * FROM employee";
	final String UPDATE_QUERY="UPDATE employee set salary =15000 WHERE employee.id =1";
	 
	public void createTable() {
		try {
			statement=conn.createStatement();
			statement.execute(CREATE_TABLE_QUERY);
			System.out.println("Table Created Sucessfully!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int insertRecordsInTable() {
		try {
			statement=conn.createStatement();
			statement.execute(INSERT_QUERY);
			System.out.println("Record inserted Sucessfully!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public int updateRecordInTable() {
		/*try {
			statement=conn.createStatement();
			statement.execute(UPDATE_QUERY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		return 0;
	}

	public void fetchAllRecords() {
		/*try {
			statement=conn.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
			while(resultSet.next()) {
				System.out.println("Name:"+resultSet.getString(2));
				System.out.println("Salary :"+resultSet.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		}
	
	
	
}
