package Oyoprod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tcontroller {
	
     @Autowired 
     private Translation translation;
    @RequestMapping(value = "/find/{fromLang}/{toLang}/{text}",method=RequestMethod.GET)
    public String gettext(@PathVariable("fromLang") String fromLang,  @PathVariable("toLang") String toLang,@PathVariable("text") String text, Model model) throws Exception{
    	return translation.translate(fromLang, toLang, text);
		
    	
    }
}


