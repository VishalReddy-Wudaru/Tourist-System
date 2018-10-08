package com.example.demo.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;

import com.example.demo.entities.Place;
import com.example.demo.service.PlaceService;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;

@org.springframework.stereotype.Component
public class DisplayView {
	
	@Autowired
	PlaceService ps;
	
	@Autowired
	QuestionView qv;
	
	@Autowired
	ThemeView tv;
	
	private class DisplayPage
	{
		VerticalLayout root;
		HorizontalSplitPanel sample;
		
		private HorizontalLayout title;
		private Button back;
		private Label user,name;
		
		public DisplayPage init()
		{
			root = new VerticalLayout();
			sample = new HorizontalSplitPanel();
	        sample.setSizeFull();
	        sample.setSplitPosition(300, Unit.PIXELS);
	        
	        title = new HorizontalLayout();
	        title.setWidth("100%");
	        back = new Button("Back");
	        back.setStyleName("friendly");
	        name = new Label("Smart Planner");
	        user = new Label();
	        
			return this;
		}
		
		public Component layout(Set<Place> pl,int f,String n)
		{
			root.addComponent(back);
			root.setComponentAlignment(back, Alignment.TOP_LEFT);
			for(Place tmp:pl)
			{
				Button bt = new Button(tmp.getName());
			VerticalLayout layout1 = new VerticalLayout();
			layout1.addStyleName("border");
			StreamResource.StreamSource source = new StreamResource.StreamSource() {
	            
	            public InputStream getStream() {
	            return new ByteArrayInputStream(tmp.getPhoto());
//	            	return null;
	            }
            };
	       StreamResource sr = new StreamResource( source, "");
	       Image i= new Image();
	        i.setSource(sr);
	        i.setWidth("150px");
	        i.setHeight("150px");
	        layout1.addComponent(i);
            layout1.addComponent(bt);
            layout1.setComponentAlignment(bt, Alignment.BOTTOM_CENTER);
            bt.addClickListener(new ClickListener() {
				public void buttonClick(ClickEvent event) {
					
					try {
						Place p= ps.getPlace(bt.getCaption());
						VerticalLayout vl =new VerticalLayout();
						vl.setSizeFull();
						//vl.setStyleName("dis2");
						Label la= new Label(p.getName());
						TextArea ta = new TextArea();
						//ta.setStyleName("dis1");
						ta.setValue(p.getInfo());
						ta.setRows(10);
						ta.setSizeFull();
						HorizontalLayout hr= new HorizontalLayout();
						hr.setSizeFull();
						Label la1= new Label("Days:"+p.getDays().toString());
						Label la2= new Label("Price:"+p.getPrice().toString());
						hr.addComponent(la1);
						hr.addComponent(la2);
						hr.setComponentAlignment(la1, Alignment.MIDDLE_LEFT);
						hr.setComponentAlignment(la2, Alignment.MIDDLE_RIGHT);
						HorizontalLayout hr1= new HorizontalLayout();
						StreamResource.StreamSource source = new StreamResource.StreamSource() {
				            
				            public InputStream getStream() {
				            return new ByteArrayInputStream(p.getPhoto());
//				            	return null;
				            }
			            };
				       StreamResource sr = new StreamResource( source, "");
				       Image i1= new Image();
				        i1.setSource(sr);
				        i1.setWidth("150px");
				        i1.setHeight("150px");
				        hr1.addComponent(i1);
				        vl.addComponent(la);
				        vl.addComponent(ta);
				        vl.addComponent(hr);
				        vl.addComponent(hr1);
						//layout1.setStyleName("border");
						sample.setSecondComponent(vl);
					}
					catch (AuthenticationException e) {
						
						Notification.show("Error!", "Login fail! Try again", Type.ERROR_MESSAGE);
						System.out.println(e.getMessage());
					}
					
					
				}
			});
            
            
            //layout2.addComponent(new Label(tmp.getPrice().toString()));
            
            root.addComponent(layout1);
			}
			root.setStyleName("dis1");
			 sample.setFirstComponent(root);
			 sample.setSecondComponent(new Label("Tourist System"));
			 
			 back.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
						if(f==1)
						{
							UI.getCurrent().setContent(qv.createComponent(n));
						}
						else
						{
							UI.getCurrent().setContent(tv.createComponent(n));
						}
					}
				});
		        /*user.setCaption(n);
		        title.addComponent(back);
				title.addComponent(name);
				title.addComponent(user);
				title.setComponentAlignment(back, Alignment.MIDDLE_LEFT);
				title.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
				title.setComponentAlignment(user, Alignment.MIDDLE_RIGHT);
				root.addComponent(title);
				//root.setComponentAlignment(title, Alignment.TOP_CENTER);*/
			 
			return sample;
		}
	}
	
	public Component createComponent(Set<Place> pl,int f,String n) {
		return new DisplayPage().init().layout(pl,f,n);
	}

}
