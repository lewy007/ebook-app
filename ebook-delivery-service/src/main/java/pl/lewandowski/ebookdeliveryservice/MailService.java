package pl.lewandowski.ebookdeliveryservice;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(String email) throws MessagingException {

        System.out.println("Sending email... for " + email);
        MimeMessage message = javaMailSender.createMimeMessage();
        //helper pozwala na wysylanie zalacznikow
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("hello@demomailtrap.com");
        helper.setTo(email);
        helper.setSubject("Your ebook");
        helper.setText("There is your ebook: " + "https://bykowski.pl/cv.pdf");

//        FileSystemResource file = new FileSystemResource(new File("/Users/attachment.jpeg"));
//        helper.addAttachment("attachment.jpg",file);

        javaMailSender.send(message);
    }
}
