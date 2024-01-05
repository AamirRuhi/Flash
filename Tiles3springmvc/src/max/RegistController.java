package max;

import java.util.List;

import location.LocationDAO;
import location.StateBean;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistController {
      @Autowired
	RegistDTO registDTO;
	
	@Autowired
	RegBean regBean;
	@Autowired
	LocationDAO locationDAO;
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public ModelAndView reg()
	{
		//System.out.println("Hello");
		return new ModelAndView("reg","r",regBean);
	}
	
	@ModelAttribute("lst")                  //jsp se controller ke method ko call kr rha hu
	public List<StateBean> getStateList()
	{
	
		List<StateBean> list = locationDAO.getState();
		return list;
	}
	
	@RequestMapping(value="reg", method=RequestMethod.GET)
	public String saveD(@ModelAttribute("r") RegBean regBean)
	{    
		
		BeanUtils.copyProperties(regBean, registDTO);
		if(locationDAO.saveDetail(registDTO))
		{
			return "B";
		}else {
			return "E";
		}
		
		
	}
}
