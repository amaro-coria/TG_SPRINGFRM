package net.tecgurus.service;

import javax.persistence.PersistenceException;

import net.tecgurus.persistence.PersistenceExcepcion;

public class ServiceException extends Exception {

	public ServiceException(){}
	
	public ServiceException(String string, PersistenceExcepcion e) {
		super(string, e);
	}

	public ServiceException(String string, PersistenceException e) {
		// TODO Auto-generated constructor stub
	}

}
