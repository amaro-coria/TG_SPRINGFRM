package net.tecgurus.service;

import net.tecgurus.persistence.PersistenceException;

public class ServiceException extends Exception {

	public ServiceException(){}
	
	public ServiceException(String string, PersistenceException e) {
		super(string, e);
	}

}
