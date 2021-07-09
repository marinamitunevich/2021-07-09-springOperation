package com.example.sptringopertaion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class LineReader implements ApplicationRunner {

    @Value("${filePath}")
    private String file;
    private final StringHandle stringHandle;

    public LineReader(StringHandle stringHandle) {
        this.stringHandle = stringHandle;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        try {
            while((line = br.readLine()) != null){

                stringHandle.handleLine(line);

            }
            br.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
