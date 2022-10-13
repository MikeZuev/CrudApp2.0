package com.zuev.controllers;

import com.zuev.entities.Label;
import com.zuev.entities.Post;
import com.zuev.repositories.PostRepository;
import com.zuev.repositories.impl.JsonPostRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PostController {
    private final PostRepository postRepo = new JsonPostRepositoryImpl();

    private final LabelController labelCon = new LabelController();

    Scanner scanner;

    public void createPost (String content, List<Label> labels) {

        Post post = new Post(content, new Date(), new Date(), labels);


        postRepo.save(post);
    }

    public void getPostById(Long id) {
        Post post = postRepo.getByld(id);
        System.out.println(post.toString());
    }

    public void getAllPosts() {
        List<Post> all = postRepo.getAll();
        for(Post post : all){
            System.out.println(post.toString());
        }
    }

    public void updatePost() {
        System.out.println("Enter the post's id: ");
        long postId = scanner.nextLong();

        Post newPost = postRepo.getByld(postId);

        System.out.println("Press - 1 if you want to change post's content\n" +
                "Press - 2 if you want to change post's label" );

        int number = scanner.nextInt();

        switch(number) {
            case 1:
                System.out.println("Enter new content for the post");
                String newContent = new Scanner(System.in).nextLine();

                newPost.setContent(newContent);
                postRepo.update(newPost);
                break;
            case 2:
                System.out.println("Enter new label for the post");
                String labelName = new Scanner(System.in).nextLine();
                Label label = labelCon.createLabel(labelName);
                newPost.getLabels().add(label);
                postRepo.update(newPost);


        }

        System.out.println(newPost);


    }

    public void deletePost(long id) {
        postRepo.deleteByld(id);
    }
}
