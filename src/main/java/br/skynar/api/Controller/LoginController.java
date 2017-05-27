package br.skynar.api.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.skynar.api.Entity.Role;
import br.skynar.api.Entity.User;
import br.skynar.api.Repository.RoleRepository;
import br.skynar.api.Service.UserService;
import br.skynar.api.Validator.UserValidator;

@RequestMapping("/")
@org.springframework.stereotype.Controller
public class LoginController extends Controller {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserValidator());
	}
	
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView loginForm() {
    	ModelAndView mv = this.getModelAndView();
    	
    	List<Role> roles = roleRepository.findAll();
    	
    	mv.setViewName("login");
    	
    	mv.addObject("roles", roles);
    	
        return mv;
    }
    
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	@CacheEvict(value="usersList", allEntries=true)
	public ModelAndView create(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			System.out.println(user);
			System.out.println(result.getFieldErrorCount());
			//return this.loginForm();
		}
		
		ModelAndView mv = this.getModelAndView();
    	
		List<Role> userRoleList = new ArrayList<Role>();
    	
    	redirectAttributes.addFlashAttribute("Sucesso", "Usuário criado com sucesso");
    	
		user.setPicturePath("NOPICTURE");
		
		user.setDob(new GregorianCalendar().getInstance());
		
		String password = user.getPassword();
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);	
		
		user.setRoles(new ArrayList<>(this.roleRepository.findAll()));
	
		user.setPassword(hashedPassword);
		
		this.userService.createUser(user);
		
		
		return new ModelAndView("redirect:login");

	}

}
