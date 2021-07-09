package com.example.sptringopertaion.service;

import org.springframework.stereotype.Component;

@Component

public class LowerCase implements IOperation{
    @Override
    public String operate(String text) {

        return text.toLowerCase();
    }

    @Override
    public String getName() {
        return "to-lowercase";
    }
}
