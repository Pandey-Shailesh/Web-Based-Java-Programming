package org.fi.fullaplication.repository;


import org.fi.fullaplication.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
	@Query("update Users objUser set objuser.password=:pwd where objUser.userName=:uname")
	public boolean updatePassword(@Param("uname")String userName,@Param("pwd")String password);
}
