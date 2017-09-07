package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Requests;
import pl.coderslab.entity.Responses;

@Repository
public interface ResponseRepository extends JpaRepository<Responses, Long>  {

	List<Responses> findAllByUserId(long id);

	}