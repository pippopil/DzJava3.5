package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    @Test
    public void shouldHaveAllMethodsFromSuper() {
        Smartphone smartphone = new Smartphone();

    }
    @Test
    public void shouldEUseEquals() {
        Smartphone smartphone1 =new Smartphone(2,"Sony",1000,"RRR");
        Smartphone smartphone2 =new Smartphone(2,"Sony",1000,"RRR");

        assertEquals(smartphone1,smartphone2);

    }

}
