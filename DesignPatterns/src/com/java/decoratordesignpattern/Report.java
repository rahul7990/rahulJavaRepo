package com.java.decoratordesignpattern;

public interface Report {
	public Object[][] getReportData(final String reportId);
    public String getFirstColumnData();
	
}

