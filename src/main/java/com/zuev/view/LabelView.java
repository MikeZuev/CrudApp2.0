package com.zuev.view;

import com.zuev.controllers.LabelController;

import java.util.Scanner;

public class LabelView {
    private final LabelController labelCon = new LabelController();
    Scanner scanner = new Scanner(System.in);

    public void labelViewHandler() {
        System.out.println("Press - 1 if you want to add a new label \n" +
                "Press - 2 if you want to get a label by id \n" +
                "Press - 3 if you want to get all labels \n" +
                "Press - 4 if you want to update the label \n" +
                "Press - 5 if you want to delete the label");
        int number = scanner.nextInt();

        switch(number) {
            case 1:
                System.out.println("Enter label's name");
                String labelName = new Scanner(System.in).nextLine();
                addLabel(labelName);
                break;
            case 2:
                System.out.println("Enter the label's id: ");
                long labelId = new Scanner(System.in).nextLong();
                labelCon.getLabelById(labelId);
                break;
            case 3:
                labelCon.getAllLabels();
                break;
            case 4:
                labelCon.updateLabel();
                break;
            case 5:
                System.out.println("Enter label's id you want to delete");
                long deleteId = new Scanner(System.in).nextLong();
                labelCon.deleteLabelById(deleteId);




        }
    }



    public void addLabel(String name) {
        labelCon.createLabel(name);

    }

    public void deleteLabel(Long id){
        labelCon.deleteLabelById(id);
    }
}
