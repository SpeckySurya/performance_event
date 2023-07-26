package com.speckyfox.performanceevent.service.domain;

import com.speckyfox.performanceevent.entity.Events;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
@Slf4j
public class NotificationService {


    @Autowired
    private Environment env;


    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Value("${spring.mail.from_email}")
    private String fromEmail;


    private final static String EMAIL_SUBJECT = "You Are Invited Performance Event";
    private static final SimpleDateFormat iCalendarDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmm'00'");

    private static final String EMAIL_SUMMARY = "Webinar module for performance event";

    // Method 1
    // To send a simple email
    public String sendEmail(String to, String from, String subject) {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(to);
            mailMessage.setText("hi There");
            mailMessage.setSubject(subject);

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }



    @SneakyThrows
    public Boolean sendCalendarInvite(String toEmail, Events events)  {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessage.addHeaderLine("method=REQUEST");
        mimeMessage.addHeaderLine("charset=UTF-8");
        mimeMessage.addHeaderLine("component=VEVENT");

        mimeMessage.setFrom(new InternetAddress(fromEmail));
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        mimeMessage.setSubject(EMAIL_SUBJECT);
//        mimeMessage.setReplyTo("surya.srivastav@speckyfox.com");

        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(buildCalendarPart(events));

        mimeMessage.setContent(multipart, "text/html; charset=utf-8");

        javaMailSender.send(mimeMessage);
        log.info("Calendar invite sent");
        return Boolean.TRUE;

    }


    private BodyPart buildCalendarPart(Events events) throws Exception {

        BodyPart calendarPart = new MimeBodyPart();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date start = events.getDate();
        cal.add(Calendar.HOUR_OF_DAY, 1);
        Date end = cal.getTime();

        //check the icalendar spec in order to build a more complicated meeting request
        String calendarContent =
                "BEGIN:VCALENDAR\n" +
                        "METHOD:REQUEST\n" +
                        "PRODID: BCP - Meeting\n" +
                        "VERSION:2.0\n" +
                        "BEGIN:VEVENT\n" +
                        "DTSTAMP:" + iCalendarDateFormat.format(start) + "\n" +
                        "DTSTART:" + iCalendarDateFormat.format(start)+ "\n" +
                        "DTEND:"  + iCalendarDateFormat.format(end)+ "\n" +
                        "SUMMARY:"+EMAIL_SUMMARY+"\n" +
                        "UID:324\n" +
                        "ATTENDEE;ROLE=REQ-PARTICIPANT;PARTSTAT=NEEDS-ACTION;RSVP=TRUE:MAILTO:"+events +"\n" +
                        "ORGANIZER:MAILTO:"+fromEmail+"\n" +
                        "LOCATION:"+events.getLocation()+"\n" +
                        "DESCRIPTION:"+ events.getDescription()+"\n" +
                        "SEQUENCE:0\n" +
                        "PRIORITY:5\n" +
                        "CLASS:PUBLIC\n" +
                        "STATUS:CONFIRMED\n" +
                        "TRANSP:OPAQUE\n" +
                        "BEGIN:VALARM\n" +
                        "ACTION:DISPLAY\n" +
                        "DESCRIPTION:REMINDER\n" +
                        "TRIGGER;RELATED=START:-PT00H15M00S\n" +
                        "END:VALARM\n" +
                        "END:VEVENT\n" +
                        "END:VCALENDAR";

        calendarPart.addHeader("Content-Class", "urn:content-classes:calendarmessage");
        calendarPart.setContent(calendarContent, "text/calendar;method=CANCEL");

        return calendarPart;
    }


}
