package com.playground.mail.controller;

import com.playground.mail.model.Room;
import com.playground.mail.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

    @Value("${spring.mail.send_to}")
    private String EMAIL;
    private static final String SUBJECT = "Test send email to this mail naa";

    @Autowired
    private RoomService roomService;

    @PostMapping(value = "")
    public Room testSendEmail(@Validated @RequestBody Room room){
        return roomService.sendSimpleMail(EMAIL, SUBJECT, room);
    }

    @PostMapping(value = "/theme")
    public void testThemeEmail(@Validated @RequestBody Room room){
        roomService.sendThymeleafThemedMail(EMAIL, SUBJECT, room);
    }
}
