package pl.lewandowski.ebookdeliveryservice;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ebook-delivery-service")
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping("/send-email")
    public void sendEmail(@RequestParam String email) {
        try {
            mailService.sendEmail(email);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get-email")
    public String getEmail() {
        return "example email";
    }
}
