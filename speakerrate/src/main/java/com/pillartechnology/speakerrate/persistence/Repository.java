package com.pillartechnology.speakerrate.persistence;

import java.util.Set;

public interface Repository<E> {

	public Set<E> findAll();
	
	public E findById(long id);
	
	public void persist(E transientEntity);
	
}
