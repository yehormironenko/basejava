package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");

        //Contacts
        resume.addContact(ContactType.PHONE, "1234");
        resume.addContact(ContactType.SKYPE, "grigory.kislin");
        resume.addContact(ContactType.MAIL, "gkislin@yandex.ru");
        resume.addContact(ContactType.LINKEDIN, "linked");
        resume.addContact(ContactType.GITHUB, "gitHub");
        resume.addContact(ContactType.STATCKOVERFLOW, "stackoverflow");
        resume.addContact(ContactType.HOME_PAGE, "homepage");

        System.out.println(resume.getContacts());
        //Text
        resume.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры"));
        resume.addSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));

        //List
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection(new ArrayList<>(Arrays.asList
                ("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                        "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk."))));
        resume.addSection(SectionType.QUALIFICATIONS, new ListSection(new ArrayList<>(Arrays.asList
                ("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                        "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,"))));


        Organization organization = new Organization("New Organization", "url", LocalDate.of(2020, 1, 1),
                LocalDate.now(), "Tittle for new org", "description" );

        resume.addSection(SectionType.EXPERIENCE, new OrganizationSection(new ArrayList<>(Collections.singletonList(organization))));

        System.out.println(resume.getSections());
    }
}
