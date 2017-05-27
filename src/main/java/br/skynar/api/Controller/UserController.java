package br.skynar.api.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.skynar.api.Entity.User;
import br.skynar.api.Infrastructure.FileSaver;
import br.skynar.api.Service.UserService;
import br.skynar.api.Validator.UserValidator;

@org.springframework.stereotype.Controller
@RequestMapping("/dashboard/users")
public class UserController extends Controller {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FileSaver fileSaver;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserValidator());
	}
	
	@RequestMapping("/signup")
	public ModelAndView index(User user) {
		ModelAndView modelAndView = new ModelAndView("users/signup");
		
		//modelAndView.addObject("userLevel", UserLevel.values());
		
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public ModelAndView loginPage(User user) {
		ModelAndView modelAndView = new ModelAndView("users/login-page");
		
		//modelAndView.addObject("userLevel", UserLevel.values());
		
		return modelAndView;
	}
	
	@RequestMapping("/report")
	public ModelAndView listPage(User user) {
		ModelAndView modelAndView = new ModelAndView("users/sprint-report");
		
		//modelAndView.addObject("userLevel", UserLevel.values());
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@CacheEvict(value="usersList", allEntries=true)
	public ModelAndView create(MultipartFile picture, @Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			return this.index(user);
		}
		
		String path = this.fileSaver.write("uploads", picture);
		
		user.setPicturePath(path);
		
		this.userService.createUser(user);
				
		redirectAttributes.addFlashAttribute("success", "Usuário cadastrado com sucesso");
			
		return new ModelAndView("redirect:user");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@Cacheable(value="usersList")
	public ModelAndView find() {
		List<User> users = this.userService.findAll();
		
		ModelAndView modelAndView = new ModelAndView("users/list");
		
		modelAndView.addObject("users", users);
		
		return modelAndView;
	}
		
}
