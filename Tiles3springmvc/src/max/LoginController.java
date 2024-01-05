package max;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	UserBean userBean;
@RequestMapping(value="open", method=RequestMethod.GET)
	public String open()
	{
		return "open";
	}
@RequestMapping(value="ulogin", method=RequestMethod.GET)
	public ModelAndView uloginn()
	{
	
	return new ModelAndView("log","lg",userBean);
	    }
	    
@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView loginn(@ModelAttribute("lg") UserBean userBean,HttpServletRequest req)
	{
	    if(userBean.getUid().equalsIgnoreCase("admin"))
	    {
	    	HttpSession s = req.getSession();
	    	 s.setAttribute("uid", userBean.getUid().toUpperCase());
	    	 return new ModelAndView("alog","lg",userBean);
	    }
	    
	    else
	    {
	    	HttpSession s = req.getSession();
	    	 s.setAttribute("uid", userBean.getUid().toUpperCase());
	    	 return new ModelAndView("ulog","lg",userBean);
	    	
	    }
		
	}

}
