package com.baitapjava.trangtintuc.Service;

import java.util.List;

import com.baitapjava.trangtintuc.Entity.User;

public interface UserService {
	
	public User themuser(User user);
	
	public User suauser(int id,User user);
	
	public void xoauser(int id);
	
	public List<User> alluser();
	
	public User oneuser(int id);
	
	public User userLogin(String taikhoan,String matkhau);
	
	public String userSigup(User user);
	
	public void xoaUser(int id);

	String resetPassword (String username, String email);
}
