package com.crud.tasks.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
/*@RequiredArgsConstructor  //Zadanie podstawowe
@AllArgsConstructor       //Zadanie podstawowe*/
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private final List<String> toCc;
    //private String toCc;  //Zadanie podstawowe

    public static class MailBuilder {
        private String mailTo;
        private String subject;
        private String message;
        private List<String> toCc = new ArrayList<>();

        public MailBuilder mailTo(String mailTo){
            this.mailTo = mailTo;
            return this;
        }

        public MailBuilder subject(String subject){
            this.subject = subject;
            return this;
        }

        public MailBuilder message(String message){
            this.message = message;
            return this;
        }

        public MailBuilder toCc(String cC){
            toCc.add(cC);
            return this;
        }

        public Mail build(){
            return new Mail(mailTo, subject, message, toCc);
        }
    }
}