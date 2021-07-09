package com.example.sptringopertaion;

import com.example.sptringopertaion.service.IOperation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

@Component

public class StringHandle {

    private final OperationContext operationContext;
    private final PrintWriter printWriter;

    public StringHandle(OperationContext operationContext, PrintWriter getPrintWriter) {
        this.operationContext = operationContext;
        this.printWriter = getPrintWriter;
    }


    @Async
    public void handleLine(String line) {

        System.out.println(Thread.currentThread().getName());

        String result;
        String[] strings = line.split("#");

        if (strings.length != 2) {
            result = line + " Error! wrong format";
            System.out.println("Wrong Format");
            printWriter.println(result);

            return;
        }

        String stringToOperate = strings[0];
        String stringOperationName = strings[1];

        IOperation operation = operationContext.getOperation(stringOperationName);
        if (operation != null) {
            result = operation.operate(stringToOperate);
            printWriter.println(result);

            return;
        } else {
            System.out.println("Wrong operation");
            result = "Error! wrong operation";
        }

        printWriter.println(result);


    }
}
