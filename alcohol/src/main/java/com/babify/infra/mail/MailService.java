package com.babify.infra.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.babify.infra.members.MembersDto;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
    public void sendMailSimple(MembersDto dto) {
    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    	
    	simpleMailMessage.setTo(dto.getMembersEmail());
    	simpleMailMessage.setSubject("babify의 회원이 되신 것을 환영합니다!");
//    	simpleMailMessage.setFrom("wjsgusfhr324@gmail.com"); 
    	simpleMailMessage.setText("안녕하세요, " + dto.getMembersName() + "님! \n\n babify의 회원이 되어주셔서 감사합니다.");

    	javaMailSender.send(simpleMailMessage);

    }
	
	
}
