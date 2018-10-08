package com.example.demo.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;

import com.example.demo.entities.Place;
import com.example.demo.entities.Theme;
import com.example.demo.service.PlaceThemeService;
import com.example.demo.service.ThemeService;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.server.StreamResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBoxGroup;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextArea;

@org.springframework.stereotype.Component
public class ThemeView {
	
	@Autowired
	ThemeService ts;
	
	@Autowired
	TabView tv;
	
	@Autowired
	DisplayView dv;
	
	@Autowired
	PlaceThemeService pts;
	
	private class ThemePage
	{
		private VerticalLayout root,layout;
		private CheckBoxGroup<String> sample;
		private Button search;
		List<String> themes= new ArrayList<>();
		int count=0;
		int n[];
		
		
		private HorizontalLayout title;
		private Button back;
		private Label user,name;
		
		public ThemePage init()
		{
			
			root = new VerticalLayout();
			root.setStyleName("thm");
			layout = new VerticalLayout();

			search=new Button("Search");
			search.setStyleName("friendly");
			
			title = new HorizontalLayout();
	        title.setWidth("100%");
	        back = new Button("Back");
	        back.setStyleName("friendly");
	        name = new Label("Smart Planner");
	        user = new Label();

			return this;
		}
		
		
		public Component layout(String na)
		{
			root.addComponent(back);
	        root.setComponentAlignment(back, Alignment.TOP_LEFT);
	        HorizontalLayout[] hl= (HorizontalLayout[])new HorizontalLayout [10];
	        hl[0]=new HorizontalLayout();
			for(Theme tmp:ts.getAllThemes())
			{
				
				if(count%4==0 && count>1)
				{
					root.addComponent(hl[(count-1)/4]);
					hl[count/4]=new HorizontalLayout();
				}
				themes.add(tmp.getTheme());
				
				Button bt = new Button(tmp.getTheme());
				bt.setStyleName("friendly");
				VerticalLayout layout1 = new VerticalLayout();
				layout1.addStyleName("noborder");
				StreamResource.StreamSource source = new StreamResource.StreamSource() {
		            
		            public InputStream getStream() {
		            return new ByteArrayInputStream(tmp.getPhoto());
//		            	return null;
		            }
	            };
		       StreamResource sr = new StreamResource( source, "");
		       Image i= new Image();
		        i.setSource(sr);
		        i.setWidth("150px");
		        i.setHeight("150px");
		        layout1.addComponent(i);
	            layout1.addComponent(bt);
	            bt.addClickListener(new ClickListener() {
					public void buttonClick(ClickEvent event) {
						
						try {
							System.out.println(layout1.getStyleName());
							if(layout1.getStyleName().equals("noborder"))
							{
								System.out.println("enterd if");
								layout1.setStyleName("border");
							}
							else
							{
								layout1.setStyleName("noborder");
							}
							//layout1.setStyleName("border");
							n[themes.indexOf(bt.getCaption())]++;
						}
						catch (AuthenticationException e) {
							
							Notification.show("Error!", "Login fail! Try again", Type.ERROR_MESSAGE);
							System.out.println(e.getMessage());
						}
						
						
					}
				});
				count++;
				hl[(count-1)/4].addComponent(layout1);
			}
			if(count%4!=0)
			{
				root.addComponent(hl[count/4]);
			}
			
			n = new int[count];
			for(int j=0;j<count;j++)
			{
				n[j]=0;
			}
			
			search.addClickListener(new ClickListener() {
				public void buttonClick(ClickEvent event) {
					
					try {
						Set<String> pla= new HashSet<String>();
						for(int k=0;k<count;k++)
						{
							if(n[k]%2==1)
							{
								pla.add(themes.get(k));
							}
						}
						Set<Place> pl = new HashSet<Place>();
						for(Place tmp:pts.getPlacesByOneoftheThemes(pla))
						{
							pl.add(tmp);
		                    UI.getCurrent().setContent(dv.createComponent(pl,2,na));
						}
						//UI.getCurrent().setContent(new Label(pts.getPlacesByOneoftheThemes(sample.getValue()).toString()));
					} catch (AuthenticationException e) {
						
						Notification.show("Error!", "Login fail! Try again", Type.ERROR_MESSAGE);
						System.out.println(e.getMessage());
					}
					
					
				}
			});
			back.addClickListener(event -> UI.getCurrent().setContent(tv.createComponent(na)));
	        /*user.setCaption(na);
	        title.addComponent(back);
			title.addComponent(name);
			title.addComponent(user);
			title.setComponentAlignment(back, Alignment.MIDDLE_LEFT);
			title.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
			title.setComponentAlignment(user, Alignment.MIDDLE_RIGHT);
			root.addComponent(title);
			//root.setComponentAlignment(title, Alignment.TOP_CENTER);*/
			root.addComponent(search);
			return root;
		}
		
	}
	
	public Component createComponent(String na) {
		return new ThemePage().init().layout(na);
	}

}
