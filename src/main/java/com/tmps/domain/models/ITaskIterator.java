package com.tmps.domain.models;

public interface ITaskIterator {
	boolean hasNext();
	IToDoItem next();
}