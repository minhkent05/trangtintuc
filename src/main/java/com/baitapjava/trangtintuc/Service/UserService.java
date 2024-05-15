package com.baitapjava.trangtintuc.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.baitapjava.trangtintuc.Entity.User;

public interface UserService {
	
	public User themuser(User user);
	
	public User suauser(int id,User user);
	
	public List<User> alluser();
	
	public User oneuser(int id);
	
	public User userLogin(String taikhoan,String matkhau);
	
	public String userSigup(User user);
	
	public void xoaUser(int id);


	String resetPassword (String username, String email);

	String changePassword (String username, String newpassword) throws Exception;

	String resetPassword (String username, String email); 
	
	public Page<User> listUserPaging (String search,int pageNumber, int pageSize);
	
	public List<Object> listRole(int idUser);
	
	public int insertRoleinUser (int idUser,int idRole);

}
