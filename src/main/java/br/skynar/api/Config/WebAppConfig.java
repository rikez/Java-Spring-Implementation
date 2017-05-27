package br.skynar.api.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.skynar.api.Controller.HomeController;
import br.skynar.api.Entity.TeamList;
import br.skynar.api.Infrastructure.FileSaver;
import br.skynar.api.Repository.RoleRepository;
import br.skynar.api.Repository.TeamListRepository;
import br.skynar.api.Repository.TeamRepository;
import br.skynar.api.Repository.UserRepository;
import br.skynar.api.Service.ApiService;
import br.skynar.api.Service.ParametersService;
import br.skynar.api.Service.SprintReportsService;
import br.skynar.api.Service.TeamService;
import br.skynar.api.Service.UserApiService;
import br.skynar.api.Service.UserService;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, 
									UserService.class, 
									FileSaver.class,
									UserService.class,
									TeamService.class,
									UserRepository.class,
									TeamRepository.class,
									SprintReportsService.class,
									ParametersService.class,
									UserApiService.class,
									TeamListRepository.class,
									RoleRepository.class
									})
@EnableCaching
public class WebAppConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public InternalResourceViewResolver internalViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	

	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = 
					new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasename("/WEB-INF/messages/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		
		return messageSource;
	}
	
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = 
						new DefaultFormattingConversionService();
		
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		registrar.registerFormatters(conversionService);
		
		return conversionService;
	}
	
	@Bean
	public MultipartResolver multipartResolver() {	
		return new StandardServletMultipartResolver();	
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}
	
	@Bean
	public ModelAndView modelAndView() {
		return new ModelAndView();
	}
	
	/*@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		List<ViewResolver> viewResolvers = new ArrayList<>();
		
		viewResolvers.add(internalViewResolver());
		//viewResolvers.add(new JsonViewResolver());
		
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(viewResolvers);
		resolver.setContentNegotiationManager(manager);
		
		return resolver;
		
	}*/
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	}
	
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
	
}
