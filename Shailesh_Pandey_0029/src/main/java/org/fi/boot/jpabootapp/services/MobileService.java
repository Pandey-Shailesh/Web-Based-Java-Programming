package org.fi.boot.jpabootapp.services;

import java.util.Iterator;

import org.fi.boot.jpabootapp.dto.MobileDTO;

public interface MobileService {

	boolean addNewMobile(MobileDTO objMobileDTO);
	Iterator<MobileDTO> allMobile();
	public MobileDTO getMobileByID(int phoneid);
	public  Iterator<MobileDTO> updateByMobileId(int phoneId);
}
