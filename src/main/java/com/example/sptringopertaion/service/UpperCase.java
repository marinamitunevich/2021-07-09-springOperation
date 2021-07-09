package com.example.sptringopertaion.service;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UpperCase implements IOperation{

    @Override
    public String operate(String text) {
        return text.toUpperCase();
    }

    @Override
    public String getName() {
        return "to_upperCase";
    }
}
