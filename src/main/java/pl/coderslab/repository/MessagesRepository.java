package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Messages;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long>  {

	public List< Messages> findByRecipientId(long id);
	public List <Messages> findBySenderId(long id);
}