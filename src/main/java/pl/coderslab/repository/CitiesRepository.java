package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Cities;

@Repository
public interface CitiesRepository extends JpaRepository<Cities, Long>  {

		
	}