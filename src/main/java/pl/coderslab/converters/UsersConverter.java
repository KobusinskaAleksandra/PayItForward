package pl.coderslab.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.Users;
import pl.coderslab.repository.UsersRepository;

public class UsersConverter implements Converter<String, Users> {

	@Autowired
	private UsersRepository user;

	@Override
	public Users convert(String source) {
		Users usr = user.findOne(Long.parseLong(source));
		return usr;
	}

}