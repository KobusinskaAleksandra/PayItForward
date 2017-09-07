package pl.coderslab.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Requests;


@Repository
public interface RequestsRepository extends JpaRepository<Requests, Long>  {
	
	public Requests findById(long id);

	public List<Requests> findAllByUserId(long id); 
	}