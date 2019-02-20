package com.relyits.rmbs.utilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
* 
 * @author Amar Errabelli
 */
public class ExposablePropertyPaceholderConfigurer extends PropertyPlaceholderConfigurer {

  private Map<String, String> resolvedProps;

  @Override
  protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,
      Properties props) throws BeansException {
      super.processProperties(beanFactoryToProcess, props);
      resolvedProps = new HashMap<String, String>();
      for (Object key : props.keySet()) {
          String keyStr = key.toString();
          resolvedProps.put(keyStr, parseStringValue(props.getProperty(keyStr), props,
                  new HashSet()));
         
      }
      System.out.println("**************resolvedProps.keySet()**********"+resolvedProps.keySet());
      System.out.println("**************resolvedProps.values()**********"+resolvedProps.values());
  }

  public Map<String, String> getProperties() {
      return Collections.unmodifiableMap(resolvedProps);
  }
	public int getRole(String Key){
		int role=Integer.parseInt(getProperties().get(Key.toLowerCase()));
		return role;
	}
	public String getMessage(String Key){
		String message=getProperties().get(Key.toLowerCase());
		return message;
	}
	public int getSubCategoryId(String Key){
		int subCatId=Integer.parseInt(getProperties().get(Key));
		return subCatId;
	}
	public int getCategoryId(String Key){
		int catId=Integer.parseInt(getProperties().get(Key.toLowerCase()));
		return catId;
	}
}