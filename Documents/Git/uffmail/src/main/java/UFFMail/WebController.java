package UFFMail;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Controller
public class WebController extends WebMvcConfigurerAdapter {
	public PersonForm pf;
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/options").setViewName("options");
    }

    @GetMapping("/")
    public String showForm(PersonForm personForm) { 
    	System.out.println("----------------------------------------showing form");
    	
    	
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
    	
    	pf = personForm;
        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/options";
    }
    
    @GetMapping("/options")
    public String showOptionsForm(PersonForm personForm) { 
    	personForm.setName(this.pf.getName());
    	personForm.setEmails(this.pf.getEmails());
        return "options";
    }
    
    @PostMapping("/options")
    public String showResults() {
    	return "redirect:/results";
    }
    
    @GetMapping("/results")
    public String results() {
    	return "results";
    }
  

}