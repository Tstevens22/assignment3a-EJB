package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@SessionScoped
public class FormController {
	
	
	@Inject
	OrdersBusinessInterface services;
	
	@EJB
	MyTimerService timer;
	
	public String onSubmit() {
		
		// get the user values from the input form 
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		// prints a message to the console to tell us which business service is currently selected in the beans.xml file as an alternative 
		services.test();
		
		//start a timer when the login is clicked
		timer.setTimer(10000);

		// puts the user object into a POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		// shows the next page
		return "TestResponse.xhtml";
	}
	
	public OrdersBusinessInterface getService() {
		return services;
		
	}
	
	/*
	 * public String onFlash(User user) { // get the user values from the input form
	 * Flash flash =
	 * FacesContext.getCurrentInstance().getExternalContext().getFlash();
	 * 
	 * //User user = context.getApplication().evaluateExpressionGet(context,
	 * "#{user}", User.class);
	 * 
	 * flash.put("#{user.firstName}", user); flash.put("#{user.lastName}", user);
	 * 
	 * // puts the user object into a POST request
	 * FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user",
	 * user);
	 * 
	 * return "TestResponse2.xhtml?faces-redirect=true";
	 * 
	 * }
	 */

}
