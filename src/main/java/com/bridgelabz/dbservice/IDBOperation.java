package com.bridgelabz.dbservice;

public interface IDBOperation {
	public void createTable();
	
	public int insertRecordsInTable();
	
	public int updateRecordInTable();
	
	public void fetchAllRecords();
	

}
