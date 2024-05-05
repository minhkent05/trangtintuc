package com.baitapjava.trangtintuc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.baitapjava.trangtintuc.Entity.Role;
import com.baitapjava.trangtintuc.Repository.RoleRepository;

public class RoleServiceImpl implements RoleService {
	@Autowired 
	private RoleRepository res;
	@Override
	public Role themrole(Role role) {
		
		return res.save(role);
	}

	@Override
	public Role suarole(int id, Role role) {
		Role editRole = res.findById(id).orElse(null);
		editRole.setNamerole(editRole.getNamerole());
		editRole = res.save(role);
		return editRole;
	}

	@Override
	public void xoarole(int id) {
		res.deleteById(id);
		
	}

	@Override
	public List<Role> allrole() {
		
		return res.findAll();
	}

	@Override
	public Role onerole(int id) {
		// TODO Auto-generated method stub
		return res.findById(id).orElse(null);
	}

}
