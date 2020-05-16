package ru.sofronov.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan ("ru.sofronov.springmvc")
public class ApplicationConfig {

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".html");		
		return resolver;
	}
	@Bean
	public SpringTemplateEngine templateEngine() {
		
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		engine.setEnableSpringELCompiler(true);		
		return engine;
	}
	@Bean
	public ThymeleafViewResolver viewResolver() {
		
		ThymeleafViewResolver tResolver = new ThymeleafViewResolver();
		tResolver.setTemplateEngine(templateEngine());
		tResolver.setOrder(1);
		tResolver.setViewNames(new String[] {"*"});		
		return tResolver;
	}
}
