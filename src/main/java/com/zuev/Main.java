package com.zuev;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zuev.controllers.WriterController;
import com.zuev.entities.Writer;
import com.zuev.repositories.impl.JsonWriterRepositoryImpl;
import com.zuev.view.LabelView;
import com.zuev.view.PostView;
import com.zuev.view.WriterView;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        WriterView writerView = new WriterView();
        PostView postView = new PostView();
        LabelView labelView = new LabelView();

        System.out.println("Enter entity you want to work with: \n" +
                "Press - 1 if yuo want to work with Writer\n" +
                "Press - 2 if you want to work with Post \n" +
                "Press - 3 if you want to work with Label");

        int number = scanner.nextInt();

        switch(number) {

            case 1:
                writerView.writerViewHandler();
                break;
            case 2:
                postView.postViewHandler();
                break;
            case 3:
                labelView.labelViewHandler();
                break;
        }

        

    }
}