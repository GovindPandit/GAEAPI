package com.niit.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController
{
	@RequestMapping(value = "/getstudent/{id}")
	public Student m1(@PathVariable("id") String id)
	{
		if(id.equals("p001"))
		{
			Student s=new Student();
			s.setStudentid(123);
			s.setStudentname("Sagar");
			return s;
		}
		else
		{
			return null;
		}	
	}
	
	@RequestMapping("/getstudents")
	public List<Student> m2()
	{
		Student s1=new Student();
		s1.setStudentid(123);
		s1.setStudentname("Prakash");
		
		Student s2=new Student();
		s2.setStudentid(124);
		s2.setStudentname("Manoj");
		
		List<Student> students=new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		
		return students;
	}
	
	@RequestMapping(value = {"/getusers"})
	public List<User> m3()
	{
		List<User> users=new ArrayList<User>();
		try 
		{
			Connection con=DataSource.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				User user=new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				
				users.add(user);
			}
		}
		catch (Exception e) 
		{
		
			
		}
		return users;
	}
	
	@RequestMapping(value = {"/getuser/{un}"})
	public User m3(@PathVariable("un") String username)
	{
		User user=new User();
		try 
		{
			Connection con=DataSource.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users where username=?");
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}
		}
		catch (Exception e) 
		{
		
			
		}
		return user;
	}
}
