package com.baitapjava.trangtintuc.ultil;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

    @Autowired
    JavaMailSender mailSender;

    public String sendNewPassword(String userMail,String username, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("FIS.auto.service@gmail.com");
        message.setTo(userMail);
        message.setSubject("Tài khoản " + username + " đã reset mật khẩu thành công");
        message.setText("Mật khẩu mới là: " + password);
        mailSender.send(message);
        return "Gửi mail reset mật khẩu thành công !";
    }

}
