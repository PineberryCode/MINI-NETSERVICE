package my.project.mininetservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import my.project.mininetservice.model.service.emailService;

/*@Controller
@RequestMapping("/contactUs")*/
public class emailController {
    
    /*private emailService mssger;

    public emailController (emailService mssger) {
        this.mssger = mssger;
    }*/

    /*@PostMapping("/send")
    public String sendMail (@RequestParam(value="file",required=false)
                            MultipartFile[] file, String to, String[] cc,
                            String subject, String body) {
        return mssger.sendMail(file, to, cc, subject, body);
    }*/
    /*@PostMapping("/sendRecommendation")
    public String sendRecomendation (@RequestBody email request) {
        return mssger.sendRecommendation(
            request.getEmail(),
            request.getLastname(),
            request.getNames(),
            request.getComment()
        );
    }*/

}
