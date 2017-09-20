package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.UsersDetails;

@Repository
public interface UsersDetailsRepository extends JpaRepository<UsersDetails, Long>  {
	
	public UsersDetails findById(long id);
	public UsersDetails findByUserId(long id);
	
	@Modifying
	@Query("update UsersDetails u set u.firstName = ?1, u.lastName = ?2 where u.id = ?3")
	void setUserInfoById(String firstname, String lastname, Long userId);
	}