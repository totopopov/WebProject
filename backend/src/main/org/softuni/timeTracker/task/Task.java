package org.softuni.timeTracker.task;

import org.softuni.timeTracker.areas.logger.service.LoggerService;
import org.softuni.timeTracker.mailServices.EmailService;
import org.softuni.timeTracker.mailServices.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;

/**
 * Created by Todor Popov using Lenovo on 28.4.2018 г. at 12:56.
 */
@Configuration
@EnableAsync
@EnableScheduling
public class Task {

    private LoggerService loggerService;
    private EmailService emailService;


    @Autowired
    public Task(LoggerService loggerService, EmailService emailService) {
        this.loggerService = loggerService;
        this.emailService = emailService;
    }


    @Async
    @Scheduled(fixedRate = 86400000)
    public void aggregateData() {
        Integer dailyReport = this.loggerService.getDailyReport();

        Mail mail = new Mail();
        mail.setFrom("timeTracker.com");
        mail.setTo("totopopov@gmail.com");
        mail.setSubject("Daily Gowth Report");
        mail.setContent(String.format("Daily report for %s is %d",LocalDate.now(),dailyReport));

        emailService.sendSimpleMessage(mail);
    }
}
