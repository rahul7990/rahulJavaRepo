package com.java.decoratordesignpattern;

public class SupportPopupDecorator extends ColumDecorator {

	SupportPopupDecorator(Report report) {
		super(report);
	}

	public String getFirstColumnData(){
		return addPopup(super.getFirstColumnData());
		
	}
	
	public String addPopup(String data){
		return data + "Support_Popup";
	}
}
