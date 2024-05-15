package com.baitapjava.trangtintuc.Service;

import com.baitapjava.trangtintuc.Entity.User;
import com.baitapjava.trangtintuc.Repository.UserRepository;
import com.baitapjava.trangtintuc.ultil.GenerateRandomString;
import com.baitapjava.trangtintuc.ultil.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository res;

    @Autowired
    private GenerateRandomString randomString;

    @Autowired
    private SendEmail sendEmail;

    @Override
    public User themuser(User user) {

        return res.save(user);
    }

    @Override
    public User suauser(int id, User user) {
        User useredit = res.findById(id).orElse(null);
        useredit.setTaikhoan(user.getTaikhoan());
        useredit.setMatkhau(user.getMatkhau());
        useredit.setEmail(user.getEmail());
        useredit = res.save(useredit);

        return useredit;
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
        int checkMail = res.checkMail(user.getEmail());
        if (checkUser == 1) {
            return "Người dùng đã tồn tại!";
        } else if(checkMail == 1) {
        	return "Email đã được sử dụng";
        }
        else {
            res.save(user);
        }
        int id = res.getID(user.getTaikhoan());
        int kq = res.insertRole(id);
        if (kq == 1) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public void xoaUser(int id) {
        res.deleteUserInUser_Role(id);
        res.deleteUser(id);
    }

    @Override
    public String resetPassword(String username, String email) {
        User resetUser = res.findBytaikhoan(username);
        if(resetUser == null) {
        	return "Tài khoản không chính xác";
        }
        else if (email.equals(resetUser.getEmail())) {
            String matKhauMoi = randomString.generateRandomCode(5);
            resetUser.setMatkhau(matKhauMoi);
            res.save(resetUser);
            sendEmail.sendNewPassword(resetUser.getEmail(), resetUser.getTaikhoan(), matKhauMoi);
            return "Reset mật khẩu thành công";
        } else {
            return "Email không đúng với email đã đăng ký";
        }
    }

	@Override
	public Page<User> listUserPaging(String search, int pageNumber, int pageSize) {
		Pageable pagingUser = PageRequest.of(pageNumber, pageSize);
				
		return res.listUserPaging(search, pagingUser);
	}

	@Override
	public List<Object> listRole(int idUser) {
		
		return res.listRole(idUser);
	}

	@Override
	public int insertRoleinUser(int idUser, int idRole) {
		res.insertRoleinUser(idUser,idRole);
		return 1;
	}

}