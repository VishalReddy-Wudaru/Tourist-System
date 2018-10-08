package com.example.demo.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;

import com.example.demo.entities.Place;
import com.example.demo.entities.Theme;
import com.example.demo.service.PlaceThemeService;
import com.example.demo.service.ThemeService;
import com.vaadin.server.StreamResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;

@org.springframework.stereotype.Component
public class QuestionView {
	
	@Autowired
	ThemeService ts;
	
	@Autowired
	DisplayView dv;
	
	@Autowired
	PlaceThemeService pts;
	
	@Autowired
	TabView tv;
	
	
	private class QuestionPage
	{
		private VerticalLayout root,vl;
		private HorizontalLayout hl;
		private RadioButtonGroup<String>[] q= (RadioButtonGroup<String>[])new RadioButtonGroup [10];
		private Button search,back,front;
		int pos=0;
		
		private HorizontalLayout title;
		private Button back1;
		private Label user,name;
		
		public QuestionPage init()
		{
			root = new VerticalLayout();
			root.setMargin(true);
			root.setHeight("100%");
			root.setStyleName("ques");
			
			hl =  new HorizontalLayout();
			vl = new VerticalLayout();
			vl.setWidth("500px");
			vl.setStyleName("border");

			search=new Button("Search");
			search.setStyleName("friendly");
			front = new Button(">");
			front.setStyleName("friendly");
			back = new Button("<");
			back.setStyleName("friendly");
			
			title = new HorizontalLayout();
	        title.setWidth("100%");
	        back1 = new Button("Back");
	        back1.setStyleName("friendly");
	        name = new Label("Smart Planner");
	        user = new Label();
			
			List<String> data = Arrays.asList("yes","no");
			q[0]= new RadioButtonGroup<>("Do you like Nature?",data);
			q[1]= new RadioButtonGroup<>("Are you intrested in adventure sports like paragliding?",data);
			q[2]= new RadioButtonGroup<>("Is it a family trip?",data);
			q[3]= new RadioButtonGroup<>("Do you like to trek?",data);
			q[4]= new RadioButtonGroup<>("Intrested to know about ancient places or forst?",data);
			q[5]= new RadioButtonGroup<>("Do you like water sports like river rafting?",data);
			q[6]= new RadioButtonGroup<>("Intrested to visit wildlife sancutires?",data);
			q[7]= new RadioButtonGroup<>("Do you want us to take care of the transport?",data);
			q[8]= new RadioButtonGroup<>("Budget greater than 15K?",data);
			//q[9]= new RadioButtonGroup<>("Intrested to visit wildlife sancutires?",data);
			
			for(int i=0;i<9;i++)
			{
				q[i].setItemCaptionGenerator(item ->  item);
			}
			
			
			
			return this;
		}
		
		
		public Component layout(String n)
		{
			
			List<String> themes= new ArrayList<>();
			for(Theme temp:ts.getAllThemes())
			{
				themes.add(temp.getTheme());
			}
			
			Set<String> set = new HashSet<String>();
			
			Set<Place> pl = new HashSet<Place>();
			
			/*for(int i=0;i<9;i++)
			{
				root.addComponent(q[i]);
			}*/
			vl.addComponent(q[pos]);
			hl.addComponent(back);
			hl.addComponent(search);
			hl.addComponent(front);
			back.setEnabled(false);
			vl.addComponent(hl);
			vl.setComponentAlignment(q[pos], Alignment.MIDDLE_CENTER);
			vl.setComponentAlignment(hl, Alignment.MIDDLE_CENTER);
			
			front.addClickListener(new ClickListener() {
				public void buttonClick(ClickEvent event) {
					
					try {
						pos=pos+1;
						vl.removeAllComponents();
						vl.addComponent(q[pos]);
						hl.addComponent(back);
						hl.addComponent(search);
						hl.addComponent(front);
						if(pos==0)
						{
							back.setEnabled(false);
						}
						else
						{
							back.setEnabled(true);
						}
						
						if(pos==8)
						{
							front.setEnabled(false);
						}
						else
						{
							front.setEnabled(true);
						}
						vl.addComponent(hl);
						vl.setComponentAlignment(q[pos], Alignment.MIDDLE_CENTER);
						vl.setComponentAlignment(hl, Alignment.MIDDLE_CENTER);
					}
				//UI.getCurrent().setContent(new Label(pts.getPlacesByOneoftheThemes(sample.getValue()).toString()));
			 catch (AuthenticationException e) {
				
				Notification.show("Error!", "Login fail! Try again", Type.ERROR_MESSAGE);
				System.out.println(e.getMessage());
			}
			
			
		}
	});
			
			back.addClickListener(new ClickListener() {
				public void buttonClick(ClickEvent event) {
					
					try {
						pos=pos-1;
						vl.removeAllComponents();
						vl.addComponent(q[pos]);
						hl.addComponent(back);
						hl.addComponent(search);
						hl.addComponent(front);
						if(pos==0)
						{
							back.setEnabled(false);
						}
						else
						{
							back.setEnabled(true);
						}
						
						if(pos==8)
						{
							front.setEnabled(false);
						}
						else
						{
							front.setEnabled(true);
						}
						vl.addComponent(hl);
						vl.setComponentAlignment(q[pos], Alignment.MIDDLE_CENTER);
						vl.setComponentAlignment(hl, Alignment.MIDDLE_CENTER);
					}
				//UI.getCurrent().setContent(new Label(pts.getPlacesByOneoftheThemes(sample.getValue()).toString()));
			 catch (AuthenticationException e) {
				
				Notification.show("Error!", "Login fail! Try again", Type.ERROR_MESSAGE);
				System.out.println(e.getMessage());
			}
			
			
		}
	});
			search.addClickListener(new ClickListener() {
				public void buttonClick(ClickEvent event) {
					
					try {
						//panel.setWidth(100.0f, Unit.PERCENTAGE);
						//panel.setContent(root);
//						for(int i=0;i<7;i++)
//						{
//							System.out.println(q[i].getValue()+"  "+q[i].getCaption());
//						}
						set.clear();
						for(int i=0;i<9;i++)
						{
							System.out.println(i+"  "+q[i].getValue());
						}
						
						if(q[0].getValue()=="yes")
						{
							set.add(themes.get(5));
						}
						
						if(q[1].getValue()=="yes")
						{
							//set.add(themes.get(3));
							set.add(themes.get(9));
						}
						
						if(q[2].getValue()=="yes")
						{
							set.add(themes.get(2));
						}
						
						if(q[3].getValue()=="yes")
						{
							//set.add(themes.get(1));
							set.add(themes.get(6));
						}
						
						if(q[4].getValue()=="yes")
						{
							set.add(themes.get(8));
						}
						
						if(q[5].getValue()=="yes")
						{
							//set.add(themes.get(4));
							set.add(themes.get(7));
						}
						
						if(q[6].getValue()=="yes")
						{
							set.add(themes.get(0));
						}
					
						for(Place tmp:pts.getPlacesByOneoftheThemes(set))
						{
							System.out.println(tmp.getName());
							System.out.println(tmp.getTransport().toString());
							System.out.println(tmp.getPrice());
							int f=0;
							
							if(q[7].getValue()=="yes" && tmp.getTransport().toString().equals("YES"))
							{
								pl.add(tmp);
								f=1;
							}
							else if(q[7].getValue()=="no" && tmp.getTransport().toString().equals("NO"))
							{
								pl.add(tmp);
								f=1;
							}
							else
							{
								pl.add(tmp);
								f=1;
							}
							
							if(f==1)
							{
								if(q[8].getValue()=="yes" && tmp.getPrice().intValue()<15000)
								{
									pl.remove(tmp);
								}
								else if(q[8].getValue()=="no" && tmp.getPrice().intValue()>15000)
								{
									pl.remove(tmp);
								}
							}
							else
							{
								if(q[8].getValue()=="yes" && tmp.getPrice().intValue()>15000)
								{
									pl.add(tmp);
								}
								else if(q[8].getValue()=="no" && tmp.getPrice().intValue()<15000)
								{
									pl.add(tmp);
								}
								else
								{
									pl.add(tmp);
								}
							}
							
							
						}
						UI.getCurrent().setContent(dv.createComponent(pl,1,n));
					}
					//UI.getCurrent().setContent(new Label(pts.getPlacesByOneoftheThemes(sample.getValue()).toString()));
				 catch (AuthenticationException e) {
					
					Notification.show("Error!", "Login fail! Try again", Type.ERROR_MESSAGE);
					System.out.println(e.getMessage());
				}
				
				
			}
		});
			back1.addClickListener(event -> UI.getCurrent().setContent(tv.createComponent(n)));
	        /*user.setCaption(n);
	        title.addComponent(back1);
			title.addComponent(name);
			title.addComponent(user);
			title.setComponentAlignment(back1, Alignment.MIDDLE_LEFT);
			title.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
			title.setComponentAlignment(user, Alignment.MIDDLE_RIGHT);
			root.addComponent(title);*/
		root.addComponent(vl);
		root.setComponentAlignment(vl, Alignment.MIDDLE_CENTER);
		root.addComponent(back1);
        root.setComponentAlignment(back1, Alignment.BOTTOM_LEFT);
		return root;
		}
		
	}
	
	public Component createComponent(String n) {
		return new QuestionPage().init().layout(n);
	}

}
