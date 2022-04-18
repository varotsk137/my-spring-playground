package com.playground.mail.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playground.mail.model.Room;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class RoomService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @SneakyThrows
    public Room sendSimpleMail(String to, String subject, Room room){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("no-reply@icegreen.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(objectMapper.writeValueAsString(room));
        mailSender.send(message);
        log.info("Send Email to message");
        return room;

    }

    @SneakyThrows
    public void sendThemedMail(String to, String subject, String htmlBody){

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        mailSender.send(message);
        log.info("Send Email to message");

    }

    @SneakyThrows
    public void sendThymeleafThemedMail(String to, String subject, Room room){

        Map<String, Object> templateModel = new HashMap<>();

        templateModel.put("roomId", room.getRoomId());
        templateModel.put("typeId", room.getRoomType().getTypeId());
        templateModel.put("name", room.getRoomType().getName());
        templateModel.put("price", room.getRoomType().getPrice());

        templateModel.forEach((s, o) -> log.info("S: {}, O: {}",s, o));

        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);

        String htmlBody = templateEngine.process("template-thymeleaf.html", thymeleafContext);

        sendThemedMail(to, subject, htmlBody);

    }

}
