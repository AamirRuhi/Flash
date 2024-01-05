package max;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import location.LocationDAO;

@Controller
public class ViewController {
	@Autowired
	LocationDAO locationDAO;
	/*
	 * // view ke liye stcode pr dist code
	 * 
	 * @RequestMapping(value="view" , method=RequestMethod.GET)
	 *  public ModelAndView view() {
	 *  List<RegistDTO> list = locationDAO.viewDetail();
	 *   return new ModelAndView("view","ok",list);
	 * 
	 * 
	 * }
	 */
	
	
    //distcode pr state name lana hai
   // @RequestMapping(value="view" , method=RequestMethod.GET)
    //public ModelAndView view() 
    //{
    //	List<RegistDTO> list = locationDAO.viewDetail();
    	//List<RegistDTO> nlist = new ArrayList<RegistDTO>();
    //	for(RegistDTO p:list)
    	//{
    		
 // String stName = locationDAO.getStateNameByCode(Integer.parseInt(p.getStCode()));
    		//p.setStCode(stName);
    		//nlist.add(p);
    //	}    	
    	//return new ModelAndView("view","ok",nlist);	
   // }
    
    //ye distcode ke base pe dist name lake ana hai
    @RequestMapping(value="view" , method=RequestMethod.GET)
    public ModelAndView view() 
    {
    	List<RegistDTO> list = locationDAO.viewDetail();
    	List<RegistDTO> nlist = new ArrayList<RegistDTO>();
    	for(RegistDTO p:list)
    	{
    		
 // String stName = locationDAO.getStateNameByCode(Integer.parseInt(p.getStCode()));
    		//p.setStCode(stName);
    		p.setDistCode(locationDAO.getDistNameByCode(p.getDistCode()));
    		nlist.add(p);
    	}    	
    	return new ModelAndView("view","ok",nlist);	
    }
   
    
    
}
