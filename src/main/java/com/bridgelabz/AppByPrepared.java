package com.bridgelabz;


import com.bridgelabz.dbservice.DBOpertionUsingPreparedStatement;

public class AppByPrepared {
	public static void main(String[] args) {
		
		DBOpertionUsingPreparedStatement dbOpertionUsingPreparedStatement=new DBOpertionUsingPreparedStatement();
		dbOpertionUsingPreparedStatement.createTable();
		dbOpertionUsingPreparedStatement.insertRecordsInTable();
		dbOpertionUsingPreparedStatement.updateRecordInTable();
	}
	

}
