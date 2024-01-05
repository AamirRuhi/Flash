package max;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import location.DistBean;
import location.LocationDAO;
//http://localhost:8080/Tiles3springmvc/dist.do?stcode=
@Controller
public class DistController {
	@Autowired
	LocationDAO locationDAO;
@RequestMapping(value="dist",method=RequestMethod.GET)
	public @ResponseBody String getDistList(@RequestParam("stcode") String stcode) throws JsonGenerationException, JsonMappingException, IOException
	{
	
	List<DistBean> list = locationDAO.getDistList(stcode);
	//ab  list ko direct bhej nhi skt, convert krna json me fir send krna hai, objectmapper list,set,map ko convert kr deta h json me
	 ObjectMapper m = new ObjectMapper();
	String jstring = m.writeValueAsString(list);
	return jstring;
	
	}
	
}
