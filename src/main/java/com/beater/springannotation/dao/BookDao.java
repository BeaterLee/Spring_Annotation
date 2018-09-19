package com.beater.springannotation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	private String Label = "label1";

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	@Override
	public String toString() {
		return "BookDao [Label=" + Label + "]";
	}
	
}
