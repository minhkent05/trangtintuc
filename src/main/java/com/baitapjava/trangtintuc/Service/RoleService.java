package com.baitapjava.trangtintuc.Service;

import java.util.List;

import com.baitapjava.trangtintuc.Entity.Role;

public interface RoleService  {
	
	public Role themrole(Role role);
	
	public Role suarole(int id, Role role);
	
	public void xoarole(int id);
	
	public List<Role> allrole();
	
	public Role onerole(int  id);
}
