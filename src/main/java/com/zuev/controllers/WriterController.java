package com.zuev.controllers;

import com.zuev.entities.Post;
import com.zuev.entities.Writer;
import com.zuev.repositories.WriterRepository;
import com.zuev.repositories.impl.JsonWriterRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class WriterController {

    private final WriterRepository repoWriter = new JsonWriterRepositoryImpl();
    Scanner scanner = new Scanner(System.in);

    public Writer create(String name, String surname) {
        Writer writer = new Writer(name, surname);

        return repoWriter.save(writer);
    }

    public void getWriterById(Integer id) {
        Writer writer = repoWriter.getByld(id);
        System.out.println(writer.toString());
    }
    
    public void getAllWriters() {
        List<Writer> all = repoWriter.getAll();
        for (Writer writer : all) {
            System.out.println(writer.toString());
            
        }
    }

    public void deleteWriterById(Integer id) {

        repoWriter.deleteByld(id);
    }

    public void updateWriter() {
        System.out.println("Enter writer's id: ");
        int id = scanner.nextInt();
        Writer writer = repoWriter.getByld(id);

        System.out.println("Options you want to update: \n" +
                "Press 1 - if you want to update writer's name \n" +
                "Press 2 - if you want to update writer's surname \n" +
                "Press 3 - if you want to update writer's name and surname");
        int number = scanner.nextInt();



        switch(number) {
            case 1:
                System.out.println("Enter name: ");
                String name = new Scanner(System.in).nextLine();
                writer.setFirstName(name);
                repoWriter.update(writer);
                break;
            case 2:
                System.out.println("Enter surname: ");
                String surname = new Scanner(System.in).nextLine();
                writer.setLastName(surname);
                repoWriter.update(writer);
                break;
            case 3:
                System.out.println("Enter name: ");
                String firstName = new Scanner(System.in).nextLine();
                writer.setFirstName(firstName);
                System.out.println("Enter surname: ");
                String lastName = new Scanner(System.in).nextLine();
                writer.setLastName(lastName);
                repoWriter.update(writer);
        }





    }




}
