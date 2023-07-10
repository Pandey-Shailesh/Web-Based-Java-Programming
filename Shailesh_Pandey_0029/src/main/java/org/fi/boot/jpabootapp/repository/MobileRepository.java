package org.fi.boot.jpabootapp.repository;


import java.util.List;

import org.fi.boot.jpabootapp.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface MobileRepository extends JpaRepository<Mobile, Integer> {

	
	
	@Query(value="update Mobile objMobile set objMobile.phoneName=:phonename,objMobile.phoneMemory=:phonememory,objMobile.phoneOS=:phoneos"
			+ ",objMobile.phoneSize=:phonesize where phoneId=:phoneid",nativeQuery = true)
	public List<Mobile> updateMobile(@Param("phoneid")int phoneId);
	
	
	
}
