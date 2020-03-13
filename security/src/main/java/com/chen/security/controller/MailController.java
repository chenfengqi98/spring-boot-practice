package com.chen.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/email")
public class MailController {

    @Autowired
    private JavaMailSender jms;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private TemplateEngine templateEngine;

    @RequestMapping("send")
    public String sendSimpleEmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo("1549093745@qq.com");
        simpleMailMessage.setSubject("邮件发送测试");
        simpleMailMessage.setText("哈哈哈哈哈哈");
        jms.send(simpleMailMessage);
        return "success";
    }

    @RequestMapping("sendHtml")
    public String sendHtmlEmail() {
        MimeMessage mimeMessage = jms.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo("1549093745@qq.com");
            helper.setSubject("邮件发送测试--HTML");
            StringBuilder stringBuilder = new StringBuilder("<h1 style='color:#42b983'>啊哈哈哈哈哈</h1>");
            helper.setText(stringBuilder.toString(), true);
            jms.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "success";
    }

    @RequestMapping("sendFile")
    public String sendFile() {
        MimeMessage mimeMessage = jms.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo("1549093745@qq.com");
            helper.setSubject("邮件发送测试--FILE");
            helper.setText("详情参见附件内容");
            FileSystemResource file = new FileSystemResource("/Users/space/Documents/note/课设第一稿.docx");
            helper.addAttachment("课设第一稿.docx", file);
            jms.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "success";
    }

    @RequestMapping("sendInline")
    public String sendInlineMail() {
        MimeMessage mimeMessage = jms.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo("1549093745@qq.com");
            helper.setSubject("邮件发送测试--STATIC");
            helper.setText("<html><body>图片：<img src='cid:img'/></body></html>", true);
            FileSystemResource file = new FileSystemResource("/Users/space/Documents/guidao/Sea.jpg");
            helper.addInline("img", file);
            jms.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "success";
    }

    @RequestMapping("sendTemp")
    public String sendTemplateEmail(String code) {
        MimeMessage mimeMessage = jms.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo("1549093745@qq.com");
            helper.setSubject("邮件模板测试");
            Context context = new Context();
            context.setVariable("code", code);
            String template = templateEngine.process("emailTemplate", context);
            helper.setText(template, true);
            jms.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "success";
    }
}
