package com.marcuschiu.testframeworkexampleboot221.junit.extendwith;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ExampleExtension implements BeforeAllCallback, BeforeEachCallback {

    private static Integer i = 0;

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        i++;
        System.setProperty("string.one", "" + i);
        System.out.println("ExampleExtension.beforeEach(): string.one = " + i);
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        i++;
        System.setProperty("string.one", "" + i);
        System.out.println("ExampleExtension.beforeAll(): string.one = " + i);
    }
}
