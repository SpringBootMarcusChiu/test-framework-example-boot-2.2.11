package com.marcuschiu.testframeworkexampleboot221.junit.order;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JUnit5Test {

    @Test
    @Order(1)
    void a_givenString_whenChangedtoInt_thenTrue() {
        System.out.println(1);
    }

    @Test
    @Order(2)
    void b_givenInt_whenChangedtoString_thenTrue() {
        System.out.println(2);
    }

}