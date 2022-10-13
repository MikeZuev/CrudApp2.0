package com.zuev.view;

import com.zuev.controllers.LabelController;
import com.zuev.controllers.PostController;
import com.zuev.entities.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostView {
    private final PostController postCon = new PostController();
    private final LabelController labelCon = new LabelController();

    Scanner scanner = new Scanner(System.in);


    public void postViewHandler() {
        System.out.println("Press - 1 if you want to add new post \n" +
                "Press - 2 if you want to get the post by id \n" +
                "Press - 3 if you want to get all posts" +
                "Press - 4 if you want to update the post " +
                "Press - 5 if you want to delete the post");

        int num = scanner.nextInt();

        switch(num) {
            case 1:
                System.out.println("Enter the content of the post");
                String contentPost = new Scanner(System.in).nextLine();
                System.out.println("Enter the label of the post");
                String labelName = new Scanner(System.in).nextLine();


                addPost(contentPost, labelName);

                break;
            case 2:
                System.out.println("Enter the post's id ");
                long id = new Scanner(System.in).nextLong();

                postById(id);
                break;
            case 3:
                getFullListOfPosts();
                break;
            case 4:
                updatePost();
                break;
            case 5:
                System.out.println("Enter the post's id you want to delete");
                long postId = new Scanner(System.in).nextLong();
                deletePost(postId);
                break;

        }

    }

    public void addPost(String content, String labelName) {
        List<Label> labels = new ArrayList<>();


        Label label = labelCon.createLabel(labelName);
        postCon.createPost(content, labels);

    }

    public void postById(Long id){
        postCon.getPostById(id);

    }

    public void getFullListOfPosts() {
        postCon.getAllPosts();

    }

    public void updatePost() {
        postCon.updatePost();

    }

    public void deletePost(long id) {
        postCon.deletePost(id);
    }
}
