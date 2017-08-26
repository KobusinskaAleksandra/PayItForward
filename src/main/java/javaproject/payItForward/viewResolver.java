package javaproject.payItForward;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class viewResolver {

	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages	=	"javaproject.payItForward")
	public	class	AppConfig	extends	WebMvcConfigurerAdapter	{
			@Bean
			public	ViewResolver viewResolver()	{
					InternalResourceViewResolver	viewResolver	=
					new	InternalResourceViewResolver();
					viewResolver.setPrefix("/WEB-INF/");
					viewResolver.setSuffix(".jsp");
					return	viewResolver;
			}
			
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
					registry.addResourceHandler("/resources/**")
			                .addResourceLocations("/resources/");
		    }
	}
}