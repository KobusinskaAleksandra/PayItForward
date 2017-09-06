package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>  {
	public Users findByLogin(String login);
	public Users findById(long id);
	}