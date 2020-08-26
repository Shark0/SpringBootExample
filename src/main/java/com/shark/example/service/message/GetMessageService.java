package com.shark.example.service.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@Slf4j
@RequiredArgsConstructor
@Service
public class GetMessageService {

    private final MessageSource messageSource;

    public String getMessage() {
        log.info("start");
        return messageSource.getMessage("user.does.not.exist", null, getLocale());
    }
}
