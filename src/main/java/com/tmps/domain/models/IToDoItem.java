package com.tmps.domain.models;

public interface IToDoItem {
	String getDescription();
	boolean isCompleted();
	void setCompleted(boolean completed);
}
