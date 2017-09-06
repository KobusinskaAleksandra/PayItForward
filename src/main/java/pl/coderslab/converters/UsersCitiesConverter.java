package pl.coderslab.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.Cities;
import pl.coderslab.repository.CitiesRepository;

public class UsersCitiesConverter implements Converter<String, Cities> {

	@Autowired
	private CitiesRepository cities;
	
	@Override
	public Cities convert(String source) {
	Cities city = cities.findOne(Long.parseLong(source));
	return city;
	}

}