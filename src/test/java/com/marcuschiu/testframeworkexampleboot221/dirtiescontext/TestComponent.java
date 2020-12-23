package com.marcuschiu.testframeworkexampleboot221.dirtiescontext;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TestComponent {
    public AtomicInteger i = new AtomicInteger(0);
}
