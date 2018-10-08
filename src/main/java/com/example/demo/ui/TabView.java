package com.example.demo.ui;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;

@org.springframework.stereotype.Component
public class TabView {
	
	@Autowired
	LoginFormFactory lff;
	
	@Autowired
	ThemeView tv;
	
	@Autowired
	QuestionView qv;
	
	private class TabPage
	{
		private HorizontalLayout hroot;
		private Image qi,ti;
		private Label q,t;
		private VerticalLayout v1,v2,root;
		
		private HorizontalLayout title;
		private Button back;
		private Label user,name;
		
		public TabPage init()
		{
			root = new VerticalLayout();
	        root.setSizeFull();
	        root.setStyleName("tab");
	        
	        hroot = new HorizontalLayout();
	        hroot.setHeight("100%");
	        hroot.setSizeFull();
	        
	        v1= new VerticalLayout();
	        v2= new VerticalLayout();
	        
	        q= new Label("Question");
	        q.setStyleName("whicol");
	        t= new Label("Theme");
	        t.setStyleName("whicol");
	        
	        title = new HorizontalLayout();
	        title.setWidth("100%");
	        back = new Button("Back");
	        back.setStyleName("friendly");
	        name = new Label("Smart Planner");
	        user = new Label();
	        
			return this;
		}
		
		public Component layout(String n)
		{
			
			qi= new Image("",new ThemeResource("../../themes/mytheme/images/Ques.jpg"));
	        ti= new Image("",new ThemeResource("../../themes/mytheme/images/Them.jpg"));
			qi.setWidth("200px");
	        qi.setHeight("150px");
			ti.setWidth("200px");
	        ti.setHeight("150px");
	        v1.addComponent(qi);
	        v1.addComponent(q);
	        v1.setComponentAlignment(qi, Alignment.MIDDLE_CENTER);
	        v1.setComponentAlignment(q, Alignment.MIDDLE_CENTER);
	        v2.addComponent(ti);
	        v2.addComponent(t);
	        v2.setComponentAlignment(ti, Alignment.MIDDLE_CENTER);
	        v2.setComponentAlignment(t, Alignment.MIDDLE_CENTER);
	        hroot.addComponent(v1);
	        hroot.addComponent(v2);
	        hroot.setComponentAlignment(v1, Alignment.MIDDLE_CENTER);
	        hroot.setComponentAlignment(v2, Alignment.MIDDLE_CENTER);
	        
	        back.addClickListener(event -> UI.getCurrent().setContent(lff.createComponent()));
	        /*user.setCaption(n);
	        title.addComponent(back);
			title.addComponent(name);
			title.addComponent(user);
			title.setComponentAlignment(back, Alignment.MIDDLE_LEFT);
			title.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
			title.setComponentAlignment(user, Alignment.MIDDLE_RIGHT);
			root.addComponent(title);
			//root.setComponentAlignment(title, Alignment.TOP_CENTER);*/
			
	        
	        root.addComponent(hroot);
	        //root.setComponentAlignment(hroot, Alignment.MIDDLE_CENTER);
	        qi.addClickListener(event -> UI.getCurrent().setContent(qv.createComponent(n)));
	        ti.addClickListener(event -> UI.getCurrent().setContent(tv.createComponent(n)));
	        root.addComponent(back);
	        root.setComponentAlignment(back, Alignment.BOTTOM_LEFT);
			return root;
		}
	}
	
	public Component createComponent(String n) {
		return new TabPage().init().layout(n);
	}

}
