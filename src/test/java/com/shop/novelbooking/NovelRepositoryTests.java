package com.shop.novelbooking;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class NovelRepositoryTests {

/**
 * Check when book record created it should return id
 * 
 */
@Autowired
 private NovelRepository underTest;
 
 @Test
 void itShouldReturnId(){

//given
//when
//then
    Novel latestNovel = new Novel(
        "Spring Boot for Beginner", 
        "Me");

       Novel responseNovel =  underTest.save(latestNovel);

       assertNotNull(responseNovel.getId());
 }



}



