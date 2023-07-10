package org.fi.boot.jpabootapp.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.fi.boot.jpabootapp.dto.MobileDTO;
import org.fi.boot.jpabootapp.entity.Mobile;
import org.fi.boot.jpabootapp.repository.MobileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	MobileRepository mobileRepository;
	
	
	
	@Override
	public boolean addNewMobile(MobileDTO objMobileDTO) {
		Mobile objMobile = new Mobile();
		BeanUtils.copyProperties(objMobileDTO, objMobile);
		if (mobileRepository.save(objMobile)!=null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterator<MobileDTO> allMobile() {
		Iterator<Mobile> iter = mobileRepository.findAll().iterator();
		ArrayList<MobileDTO> list = new ArrayList<>();
		
		while (iter.hasNext()) {
			Mobile objMobile = iter.next();
			MobileDTO mobileDTO= new MobileDTO();
			BeanUtils.copyProperties(objMobile, mobileDTO);
			list.add(mobileDTO);
		}
		return list.iterator();
	}

	@Override
	public MobileDTO getMobileByID(int phoneid) {
		Optional<Mobile> optMobile= mobileRepository.findById(phoneid);
		if (optMobile.isPresent()) {
			Mobile objMobile = optMobile.get();
			MobileDTO mobileDTO= new MobileDTO();
			BeanUtils.copyProperties(objMobile, mobileDTO);
			return mobileDTO;
		}
		return null;
	}

	@Override
	public Iterator<MobileDTO> updateByMobileId(int phoneId) {
		Iterator<Mobile> iter = mobileRepository.updateMobile(phoneId).iterator();
		ArrayList<MobileDTO> list = new ArrayList<>();
		
		while (iter.hasNext()) {
			Mobile objMobile = iter.next();
			MobileDTO mobileDTO= new MobileDTO();
			BeanUtils.copyProperties(objMobile, mobileDTO);
			list.add(mobileDTO);
		}
		return list.iterator();
	}

}
