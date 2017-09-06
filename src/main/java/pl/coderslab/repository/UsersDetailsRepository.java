package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.UsersDetails;

@Repository
public interface UsersDetailsRepository extends JpaRepository<UsersDetails, Long>  {
	
	public UsersDetails findById(long id);
	public UsersDetails findByUserId(long id);
	}