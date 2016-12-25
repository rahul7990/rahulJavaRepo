package com.java.decoratordesignpattern;

public class SupportReport implements Report {

	@Override
	public Object[][] getReportData(String reportId) {
		return null;
	}

	@Override
	public String getFirstColumnData() {
		
		return "Data For Support Report:";
	}

}
