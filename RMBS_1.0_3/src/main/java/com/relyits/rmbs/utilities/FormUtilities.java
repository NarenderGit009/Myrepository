package com.relyits.rmbs.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.relyits.rmbs.beans.registration.RegistrationBean;

public class FormUtilities {

	//creating initials 
	 static Map<String,String> property;
	private static String saveDirectory=null;

	 	 public static Map<String,String> getInitial(){
	 		property=new HashMap<String,String>();
	 		property.put("Mr","Mr");
	 		property.put("Mrs","Mrs");
	 		property.put("Other","Other");
		
        return (Map<String,String>) property;
 }
	 public static Map<String,String> getreportInitial(){
			
		 property=new HashMap<String,String>();
		 property.put("1", "Today");
		 property.put("2", "Monthly");
		 property.put("3", "Quarterly");
		 property.put("4", "Custom");
			return property;
		
		}
	 public static Map<String,String> getPeriodOfTime(){
			
		 property=new HashMap<String,String>();
		 property.put("Today", "Today");
		 property.put("Month", "Monthly");
		 property.put("Quarter", "Quarterly");
		 property.put("HalfYear", "Half Yearly");
		 property.put("Year", "Yearly");
		 property.put("Custom", "Custom");
			return property;
		
		}
	 
	 public static Map<String,String> getCategories(){
			
		 property=new HashMap<String,String>();
		 property.put("Sales", "Sales");
		 property.put("SalesReturns", "Sales Returns");
		 property.put("Purchase", "Purchase");
		 property.put("PurchaseReturns", "Purchase Returns");
		 property.put("PreSales", "PreSales");
		
			return property;
		
		}
	 public static void generateImagePath(HttpServletRequest request,RegistrationBean registrationBean,HttpSession session) throws IOException{
			List<MultipartFile> files=registrationBean.getImageData();
			List<String> fileUrl=new ArrayList<String>();
			saveDirectory=request.getRealPath("/");
			String path=saveDirectory+"OrgImages\\Images";
			File file=new File(path);
			System.out.println("****saveDirectory ImagesPath*****"+path);
			file.mkdirs();
			file.createNewFile();

			/*FileOutputStream outputStream=new FileOutputStream(file);
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(objectOutputStream);*/
			saveDirectory=request.getRealPath("OrgImages/Images");
			System.out.println("******saveDirectory****** "+saveDirectory);
			List<String> fileNames = new ArrayList<String>();
			if(null != files && files.size() > 0) {
				for (MultipartFile multipartFile : files) {

					String fileName = multipartFile.getOriginalFilename();
					System.out.println("filename  "+fileName);
					System.out.println("applied directory : "+saveDirectory+"\\"+fileName);
					if(!"".equalsIgnoreCase(fileName))
						try {
							{
								String[] names = new String[10];
								StringTokenizer st = new StringTokenizer(fileName,".");
								while(st.hasMoreElements()){
									String i = st.nextToken();
									for(int index = 0 ;index < names.length; index++){
										names[index]= i;
									}
								}
								/*for(int index = 0; index < names.length; index++){
									System.out.println("names values"+   names[index]);
								}
								System.out.println("names array "+names);
								for(String name: names){
									System.out.println("names  "+name);
								}*/
								session.setAttribute("id", registrationBean.getUserName());
								System.out.println("filetype  "+names[0]);
								String id=generateImageName(names[0], session);
								fileUrl.add(new String(saveDirectory+id));
								registrationBean.setImagePath("OrgImages/Images/"+id);
								multipartFile.transferTo(new File(saveDirectory+"\\"+ id));   //Here I Added
								fileNames.add(fileName);
								/*session.setAttribute("uploadFile",""+saveDirectory+"\\"
										+ id);*/
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
			}
		}
		public static String generateImageName(String fileType,HttpSession session){
			String val=(String) session.getAttribute("id");
			return val+"."+fileType;
		}
}
