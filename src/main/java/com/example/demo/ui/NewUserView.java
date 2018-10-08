package com.example.demo.ui;


import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;

import com.example.demo.entities.User;
import com.example.demo.service.CreateUserService;
import com.vaadin.data.Binder;
import com.vaadin.data.Validator;
import com.vaadin.data.validator.BigDecimalRangeValidator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.StringLengthValidator;
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
public class NewUserView {
	
	@Autowired
	LoginFormFactory lff;
	
	@Autowired
	CreateUserService cus;
	
	private class NewUserPage
	{
		private VerticalLayout root,centeringLayout;
		private Button create;
		private TextField username,mobile,email;
		private PasswordField pass1,pass2;
		CssLayout buttons;
		//private Label validationStatus;
		
	
		private Button back;
		
		
		public NewUserPage init()
		{
			root = new VerticalLayout();
			root.setMargin(true);
			root.setHeight("100%");
			root.setStyleName("signup");
			
			create = new Button("Login");
			create.setStyleName("friendly");
			
			buttons = new CssLayout();
            buttons.setStyleName("buttons");
			
			
			username = new TextField("Username");
			pass1 = new PasswordField("Password");
			pass2 = new PasswordField("Re-Enter Password");
			mobile = new TextField("Phone");
			email = new TextField("Email");
			
			username.setWidth(12, Unit.EM);
            pass1.setWidth(12, Unit.EM);
            pass2.setWidth(12, Unit.EM);
            mobile.setWidth(12, Unit.EM);
            email.setWidth(12, Unit.EM);
			//validationStatus = new Label("Hi");
         
	        back = new Button("Back");
	        back.setStyleName("friendly");
			
			return this;
		}
		
		public Component layout()
		{
			
			
			FormLayout loginLayout = new FormLayout();
			loginLayout.addStyleName("login-form");
			loginLayout.setWidth("400px");
			loginLayout.setHeight("250px");
			loginLayout.setMargin(false);
			loginLayout.addComponent(username);
			loginLayout.addComponent(pass1);
			loginLayout.addComponent(pass2);
			loginLayout.addComponent(mobile);
			loginLayout.addComponent(email);
			loginLayout.addComponent(create);
			loginLayout.addComponent(buttons);
			
			centeringLayout= new VerticalLayout();
            centeringLayout.setStyleName("centering-layout");
            centeringLayout.addComponents(loginLayout);
            centeringLayout.setComponentAlignment(loginLayout,
                    Alignment.MIDDLE_CENTER);
			
			Binder<User> binder = new Binder<>();
			
			binder.forField(username)
            .asRequired("Name may not be empty")
            .bind(User::getUsername, User::setUsername);
			
			binder.forField(email)
            .asRequired("Email may not be empty")
            .withValidator(new EmailValidator("Not a valid email address"))
            .bind(User::getEmail, User::setEmail);
			
			binder.forField(mobile)
            .asRequired("mobile may not be empty")
			.withValidator(new StringLengthValidator(
                    "Mobile must be at least 10 characters long", 10, 10))
			.bind(User::getMobileS, User::setMobileS);
			
			binder.forField(pass1)
            .asRequired("Password may not be empty")
            .withValidator(new StringLengthValidator(
                    "Password must be at least 7 characters long", 7, 15))
            .bind(User::getPassword, User::setPassword);
			
			binder.forField(pass2)
            .asRequired("Must confirm password")
            .bind(User::getPassword, (person, password) -> {});
			
			 /*binder.withValidator(Validator.from(use -> {
		            if (pass1.isEmpty() || pass2.isEmpty()) {
		                return true;
		            } else {
		                return Objects.equals(pass1.getValue(),
		                        pass2.getValue());
		            }
		        }, "Entered password and confirmation password must match"));
			 
			 
		        binder.setStatusLabel(validationStatus);
		        loginLayout.addComponent(validationStatus);*/
			back.addClickListener(event -> UI.getCurrent().setContent(lff.createComponent()));
		        create.setEnabled(false);
		        binder.addStatusChangeListener(
		                event -> create.setEnabled(binder.isValid()));
			
			create.addClickListener(new ClickListener() {
				public void buttonClick(ClickEvent event) {
					
					
						/*User user= new User();
						user.setRole("ADMIN");
						user.setUsername(username.getValue());
						user.setPassword(pass1.getValue());
						user.setMobile(new BigDecimal(mobile.getValue().toString()));
						user.setEmail(email.getValue());
						
						if(pass1.getValue()==pass2.getValue())
						{
							cus.addUser(user);
						}else
						{
							Notification.show("Error!", "Password Not Match", Type.ERROR_MESSAGE);
						}
						
						if(username.getValue().length()<5 && username.getValue().length()>11)
						{
							Notification.show("Error!", "username length should be 6-10;", Type.ERROR_MESSAGE);
						}
						
						if(pass1.getValue().length()<5 && pass1.getValue().length()>11)
						{
							Notification.show("Error!", "password length should be 6-10;", Type.ERROR_MESSAGE);
						}
						
						if(mobile.getValue().length()<11)
						{
							Notification.show("Error!", "Ivalid Mobile Number;", Type.ERROR_MESSAGE);
						}
						*/
						
//						binder.setBean(new User());
//						System.out.println("h1");
//						User user=binder.getBean();
//						System.out.println("h5");
					try {
						User user= new User();
						user.setRole("ADMIN");
						user.setUsername(username.getValue());
						user.setPassword(pass1.getValue());
						user.setMobile(new BigDecimal(mobile.getValue().toString()));
						user.setEmail(email.getValue());
				        
						if(pass1.getValue().equals(pass2.getValue()) || user.getMobile().intValue()<999999999)
						{
							System.out.println("h3");
							cus.addUser(user);
							UI.getCurrent().setContent(lff.createComponent());
							
						}
						else if(user.getMobile().intValue()<999999999)
						{
							System.out.println("h4");
							Notification.show("Error!", "Invalid MobileNumber", Type.ERROR_MESSAGE);
							username.setValue(user.getUsername());
							email.setValue(user.getEmail());
						}
						else
						{
							System.out.println("h4");
							Notification.show("Error!", "Password Not Match", Type.ERROR_MESSAGE);
							username.setValue(user.getUsername());
							email.setValue(user.getEmail());
						}
						
						
					} catch (Exception e) {
						
						Notification.show("Error!", "Save fail! Try again", Type.ERROR_MESSAGE);
						System.out.println(e.getMessage());
					}
					
				}
			});
			
			root.addComponent(centeringLayout);
            root.setComponentAlignment(centeringLayout, Alignment.MIDDLE_CENTER);
            root.addComponent(back);
			root.setComponentAlignment(back, Alignment.BOTTOM_LEFT);
			return root;
		}
	}
	
	public Component createComponent() {
		return new NewUserPage().init().layout();
	}

}
