package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldHaveAllMethodsFromSuper() {
        Book book = new Book();

    }
    @Test
    public void shouldUseEquals() {
        Book book1 =new Book(2,"Java",100,"Syerra");
        Book book2 =new Book(2,"Java",100,"Syerra");


        assertEquals(book1,book2);

    }

}
