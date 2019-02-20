package testing;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.relyits.dummydb.DummyDB;
import com.relyits.rmbs.beans.registration.RegistrationBean;
import com.relyits.rmbs.beans.resources.AddressBean;
import com.relyits.rmbs.service.OrganizationService;


/**
 * @author Amar Errabelli
 *
 */
@Controller
public class AjaxCallsController {
	//-------------------------------auto complete------------

	@Autowired
	private OrganizationService organizationService;
	
	private static DummyDB dummyDB = new DummyDB();

/*	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {

		User userForm = new User();

		return new ModelAndView("index", "userForm", userForm);
	}
*/
//	@RequestMapping(value = "/get_country_list", 
				//	method = RequestMethod.GET, 
	//				headers="Accept=*/*")
//	public @ResponseBody List<String> getCountryList(@RequestParam("term") String query) {
//		List<String> countryList = dummyDB.getCountryList(query);
//		
//		return countryList;
//	}
	
	@RequestMapping(value = "/get_tech_list", 
					method = RequestMethod.GET, 
					headers="Accept=*/*")
	public @ResponseBody List<String> getTechList(@RequestParam("term") String query) {
		List<String> countryList = dummyDB.getTechList(query);
		
		return countryList;
	}
	//---------------------------------------------------------
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public @ResponseBody RegistrationBean add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		RegistrationBean user = new RegistrationBean();
		AddressBean address = new AddressBean();

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		address.setEmail(email);

		user.setAddressBean(address);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		System.out.println(firstName+"--"+lastName);
		return user;
	}
	
}
