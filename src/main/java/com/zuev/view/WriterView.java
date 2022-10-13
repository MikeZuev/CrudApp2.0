package com.zuev.view;

import com.zuev.controllers.WriterController;

import java.util.Scanner;

public class WriterView {
    private final WriterController c = new WriterController();
    private final Scanner scanner = new Scanner(System.in);

    int number;

    public void writerViewHandler() {
        System.out.println("Press - 1 if you want to add new writer.\n " +
                "Press - 2 if yuu want to get a writer from array\n" +
                "Press - 3 if you want to get a list of all writers" +
                "Press -4 if you want to get");
        switch (number = scanner.nextInt()) {
            case 1:
                createWriter();
                break;
            case 2:
                getWriter();
                break;
            case 3:
                getAllWriters();
                break;
            case 4:
                deleteWriterById();
                break;
            case 5:
                updateWriter();
                break;



        }
    }




    public void createWriter() {
        System.out.println("Adding a new Writer's first name");
        String name = scanner.nextLine();
        System.out.println("Adding a new Writer's last name");
        String surname = scanner.nextLine();
        c.create(name, surname);
    }

    public void getWriter() {
        System.out.println("Enter the writer's id you want to get");
        int id = scanner.nextInt();
        c.getWriterById(id);
    }

    public void getAllWriters() {
        c.getAllWriters();
    }

    public void deleteWriterById() {
        System.out.println("Enter the writer's id you want to delete");
        int id = scanner.nextInt();
        c.deleteWriterById(id);
    }

    public void updateWriter() {

        c.updateWriter();
    }


}
