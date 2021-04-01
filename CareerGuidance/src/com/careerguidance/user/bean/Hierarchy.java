package com.careerguidance.user.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Hierarchy {
	
	String fname;
	String title;
	
	List<Hierarchy> children;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Hierarchy> getChildren() {
		return children;
	}
	public void setChildren(List<Hierarchy> children) {
		this.children = children;
	}
	
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Hierarchy children =new Hierarchy();
		children.setFname("mrunali");
		children.setTitle("Mumbai:");
		
		
		Hierarchy chil =new Hierarchy();
		chil.setFname("sakshi");
		chil.setTitle("mumbai:");
		
		List<Hierarchy> l2=new ArrayList<Hierarchy>();
		Hierarchy chil1 =new Hierarchy();
		chil1.setFname("sakshi1");
		chil1.setTitle("mumbai1");
		chil1.setChildren(null);
		
		Hierarchy chil2 =new Hierarchy();
		chil2.setFname("sakshi2");
		chil2.setTitle("mumbai2");
		chil2.setChildren(null);
		
		l2.add(chil1);
		l2.add(chil2);
		
		chil.setChildren(l2);

		

		List<Hierarchy> l=new ArrayList<Hierarchy>();
		
		l.add(chil);
		children.setChildren(l);
		
		
		
		
		ObjectMapper objectMapper=new ObjectMapper();
		String val=objectMapper.writeValueAsString(children);
		System.out.println(val);
		
		
		
		
		
		
		
		
		
	}

}
