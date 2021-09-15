package com.example.inflearn_springboot_api.learning_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class LearningTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void test1() {
        boolean assignableFrom = Object.class.isAssignableFrom(MyClass.class);
        System.out.println("assignableFrom = " + assignableFrom);
    }

    @Test
    public void jacksonTest() throws JsonProcessingException {
        MyClass myClass = new MyClass("asdfasdf");
//        myClass.setMyString("asdfasdf");
        String json = mapper.writeValueAsString(myClass);
        System.out.println("json = " + json);
    }

    static class MyClass {
        private String myString;

        public MyClass(String myString) {
            this.myString = myString;
        }

        public void setMyString(String myString) {
            this.myString = myString;
        }
    }
}
