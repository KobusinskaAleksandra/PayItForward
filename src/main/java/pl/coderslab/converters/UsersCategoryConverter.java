package pl.coderslab.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;

public class UsersCategoryConverter implements Converter<String, Category> {

	@Autowired
	private CategoryRepository category;
	
	@Override
	public Category convert(String source) {
		Category cat = category.findOne(Long.parseLong(source));
	return cat;
	}

}