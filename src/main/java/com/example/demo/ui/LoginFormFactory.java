package com.example.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.server.ThemeResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class LoginFormFactory {
	
	@Autowired
	ThemeView tv;
	
	@Autowired
	QuestionView qv;
	
	@Autowired
	NewUserView nuv;
	
	@Autowired
	TabView tabv;
	
	@Autowired
	private DaoAuthenticationProvider daoAuthenticationProvider;
//	
	
	private class LoginForm {
		private VerticalLayout layout ;
		HorizontalLayout hl;
		TextField username;
	     Button login_button,signup_button;
	     PasswordField password;
	     CssLayout buttons;
	     VerticalLayout centeringLayout;
	     CssLayout loginInformation;
	     ThemeResource logoResourse1;
	     Image logo1;
	     Label loginInfoText ;
		
		public LoginForm init() {
			
			layout=new VerticalLayout();
			hl = new HorizontalLayout();
	        layout.setStyleName("login");
	      
	            username=new TextField("Username");
	            password=new PasswordField("Password");
	            username.setWidth(17, Unit.EM);
	            password.setWidth(17, Unit.EM);
	           login_button=new Button("LOGIN");
	            login_button.setStyleName("friendly");
	            signup_button=new Button("SIGN UP");
	            signup_button.setStyleName("friendly");
	            buttons = new CssLayout();
	            buttons.setStyleName("buttons");
	        
	            loginInformation = new CssLayout();
	           logoResourse1= new ThemeResource("../../themes/mytheme/images/Logo.png");
	            logo1= new Image("", logoResourse1);
	            logo1.setStyleName("image");
	            logo1.setWidth("218px");
	           
	            loginInformation.setStyleName("login-information");
	           loginInfoText = new Label("",
	                    ContentMode.HTML);
	           
	            loginInformation.addComponents(logo1,loginInfoText);
	            layout.addComponent(loginInformation);
			
			return this;
		}
		
		public Component layout() {
			
			FormLayout login=new FormLayout();
            login.addStyleName("login-form");
            login.setWidth("400px");
            login.setHeight("200px");
            login.setMargin(false);
            login.addComponent(buttons);
            hl.addComponent(login_button);
            hl.addComponent(signup_button);
            login.addComponents(username,password,hl);
            
            centeringLayout= new VerticalLayout();
            centeringLayout.setStyleName("centering-layout");
            centeringLayout.addComponents(login);
            centeringLayout.setComponentAlignment(login,
                    Alignment.MIDDLE_CENTER);
			signup_button.addClickListener(new ClickListener() {
				public void buttonClick(ClickEvent event) {
					
					try {

						UI.getCurrent().setContent(nuv.createComponent());
					} catch (AuthenticationException e) {
						
						Notification.show("Error!", "Login fail! Try again", Type.ERROR_MESSAGE);
						System.out.println(e.getMessage());
					}
					
				}
			});
			login_button.addClickListener(new ClickListener() {
				public void buttonClick(ClickEvent event) {
					
					try {
						Authentication auth = new UsernamePasswordAuthenticationToken(username.getValue(), password.getValue());
						Authentication authenticated = daoAuthenticationProvider.authenticate(auth);
						SecurityContextHolder.getContext().setAuthentication(authenticated);

						UI.getCurrent().setContent(tabv.createComponent(username.getValue()));
					} catch (AuthenticationException e) {
						
						Notification.show("Error!", "Login fail! Try again", Type.ERROR_MESSAGE);
						System.out.println(e.getMessage());
					}
					
					username.clear();
					password.clear();
				}
			});
			
			
			
			layout.addComponent(centeringLayout);
            layout.setComponentAlignment(centeringLayout, Alignment.MIDDLE_CENTER);
			return layout;
		}
	}
	
	public Component createComponent() {
		return new LoginForm().init().layout();
	}
}
