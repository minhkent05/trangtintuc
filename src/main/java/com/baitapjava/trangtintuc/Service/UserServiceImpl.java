package com.baitapjava.trangtintuc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baitapjava.trangtintuc.Entity.User;
import com.baitapjava.trangtintuc.Repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository res;
	@Override
	public User themuser(User user) {
		
		return res.save(user);
	}

	@Override
	public User suauser(int id, User user) {
		User useredit = res.findById(id).orElse(null);
		useredit.setTennguoidung(user.getTennguoidung());
		useredit.setTaikhoan(user.getTaikhoan());
		useredit.setMatkhau(user.getMatkhau());
		useredit = res.save(useredit);
		
		return useredit;
	}

	@Override
	public void xoauser(int id) {
		res.deleteById(id);
		
	}

	@Override
	public List<User> alluser() {
		
		return res.findAll();
	}

	@Override
	public User oneuser(int id) {
	
		return res.findById(id).orElse(null);
	}

	@Override
	public User userLogin(String taikhoan, String matkhau) {
		
		return res.userLogin(taikhoan, matkhau);
	}

	@Override
	public String userSigup(User user) {
		int checkUser = res.checkUser(user.getTaikhoan());
		if(checkUser == 1) {
			return "Người dùng đã tồn tại!";
		}
		else {
			res.save(user);
		}
		int id = res.getID(user.getTennguoidung());
		int kq = res.insertRole(id);
		 if(kq == 1) {
			 return "Thành công";
		}else{
			return "Thất bại";
		}
	}

	@Override
	public void xoaUser(int id) {
		res.deleteUserInUser_Role(id);
		res.deleteUser(id);
	}

}
