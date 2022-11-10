package com.zuev.testjunit;

import com.zuev.repositories.sqlimpl.MySqlPostRepositoryImpl;
import org.junit.Test;


public class TestMySqlPostRepositoryImpl {

    @Test
    public void testGetAll(){
        MySqlPostRepositoryImpl mySqlPostRepository = new MySqlPostRepositoryImpl();
        System.out.println(mySqlPostRepository.getAll()) ;

    }

}
