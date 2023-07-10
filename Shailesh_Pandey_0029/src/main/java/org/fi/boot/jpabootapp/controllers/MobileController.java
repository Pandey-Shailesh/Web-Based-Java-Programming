package org.fi.boot.jpabootapp.controllers;

import java.util.Iterator;

import org.fi.boot.jpabootapp.dto.MobileDTO;
import org.fi.boot.jpabootapp.services.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileController {
	@Autowired
	MobileService mobileService;

	@RequestMapping("/allMobile/mobile_0029/getAllMobiles_0029")
	public Iterator<MobileDTO> getAllMobiles_0029() {
		return mobileService.allMobile();
	}

	@GetMapping("/addMobile/mobile_0029/create_0029")
	public boolean addMobile(@RequestBody MobileDTO objMobileDTO) {
		return mobileService.addNewMobile(objMobileDTO);
	}
	@GetMapping("/findByMobile/mobile_0029/getMobileDetail_0029/{mid}")
	public MobileDTO getMobileDetail(@PathVariable("mid")int phoneId) {
		return mobileService.getMobileByID(phoneId);
	}
	@GetMapping("/updateMobile/mobile_0029/updateMobileDetail_0029/{mobileid}")
	public Iterator<MobileDTO> updateMobileDetail(@PathVariable("mobileid")int phoneId )
	{
		return mobileService.updateByMobileId(phoneId);
	}
}
