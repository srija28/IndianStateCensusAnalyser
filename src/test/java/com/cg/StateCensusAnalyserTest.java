package com.cg;

import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyserTest {

	private static String CSV_CENSUS_FILE = "src/test/java/com/cg/IndianStateCensusData.csv";
	private static String CSV_FILE = "src/test/java/com/cg/IndianStateCensusDataExceptionDemo.csv";
	private static String CSV_CENSUS_FILE_INVALID_DELIMITER = "src/test/java/com/cg/IndianStateCensusInvalidDelimiter.csv";
	private static String CSV_CENSUS_FILE_INVALID_HEADER = "src/test/java/com/cg/IndianStateCensusInvalidHeader.csv";
	private static String CSV_CENSUS_FILE_INVALID_TYPE = "src/test/java/com/cg/IndianStateCensusInvalidType.txt";
	
	@Test
	public void givenNumberOfEntriesInACSVFile_ShouldReturnExactlytheSameWhileReading()
			throws StateCensusAnalyserException {
		StateCensusAnalyser obj = new StateCensusAnalyser();
		int entries = obj.readData(CSV_CENSUS_FILE);
		Assert.assertEquals(30, entries);
	}
	

	@Test
	public void givenWrongFileLocationsthrowsCustomeException_ForInvalidFilePath() {
		StateCensusAnalyser obj = new StateCensusAnalyser();
		try {
			obj.readData(CSV_FILE);
		} catch (StateCensusAnalyserException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			Assert.assertEquals(StateCensusAnalyserException.ExceptionType.INVALID_FILE_PATH, e.type);
		}
	}

	@Test
	public void givenInvalidDelimiter_ShouldThrowCustomException() {
		StateCensusAnalyser obj = new StateCensusAnalyser();
		try {
			obj.readData(CSV_CENSUS_FILE_INVALID_DELIMITER);
		} catch (StateCensusAnalyserException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			Assert.assertEquals(StateCensusAnalyserException.ExceptionType.INVALID_DELIMITER, e.type);
		}
	}
	// this test case checks for invalid delimiter in the csv file while reading

	@Test
	public void givenInvalidHeader_ShouldThrowCustomException() {
		StateCensusAnalyser obj = new StateCensusAnalyser();
		try {
			obj.readData(CSV_CENSUS_FILE_INVALID_HEADER);
		} catch (StateCensusAnalyserException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			Assert.assertEquals(StateCensusAnalyserException.ExceptionType.INVALID_HEADER, e.type);
		}
	}
	// this test case checks for invalid header in csv file while reading

	@Test
	public void givenWrongFiletypethrowsCustomeException() {
		StateCensusAnalyser obj = new StateCensusAnalyser();
		try {
			obj.readData(CSV_CENSUS_FILE_INVALID_TYPE);
		} catch (StateCensusAnalyserException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			Assert.assertEquals(StateCensusAnalyserException.ExceptionType.INVALID_TYPE, e.type);
    }
   
}
}
