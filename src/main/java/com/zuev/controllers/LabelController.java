package com.zuev.controllers;

import com.zuev.entities.Label;
import com.zuev.repositories.LabelRepository;
import com.zuev.repositories.impl.JsonLabelRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class LabelController {

    private final LabelRepository labelRepo = new JsonLabelRepositoryImpl();

    Scanner scanner = new Scanner(System.in);

    public Label createLabel(String name) {
        Label label = new Label(name);
        labelRepo.save(label);

        return label;

    }

    public void getLabelById(long id){
        labelRepo.getByld(id);

    }

    public void getAllLabels(){
        List<Label> all = labelRepo.getAll();
        for(Label label : all){
            System.out.println(label.toString());
        }
    }

    public void deleteLabelById(Long id) {
        labelRepo.deleteByld(id);
    }

    public void updateLabel(){
        System.out.println("Enter the label's id to update");
        long labelId = scanner.nextLong();
        System.out.println("Enter label's name");
        String labelName = scanner.nextLine();
        Label newLabel = labelRepo.getByld(labelId);
        newLabel.setName(labelName);
        labelRepo.update(newLabel);
        
    }
}
