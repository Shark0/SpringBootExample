package com.shark.example.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Slf4j
@Service
public class MessageService {


    @Autowired
    private MessageSource messageSource;

    public void printMessage() {
        log.info("start");
        String message = messageSource.getMessage("user.does.not.exist", null, Locale.US);
        System.out.println(message);
    }
}
