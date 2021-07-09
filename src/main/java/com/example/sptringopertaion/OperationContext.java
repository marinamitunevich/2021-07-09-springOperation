package com.example.sptringopertaion;

import com.example.sptringopertaion.service.IOperation;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component

public class OperationContext {

    private final Map<String, IOperation> operationMap = new HashMap<>();

    public OperationContext(List<IOperation> operationsPath) {
        for (IOperation operationsPat : operationsPath) {

            operationMap.put(operationsPat.getName(), operationsPat);

        }
    }

    public IOperation getOperation(String operationName) {

        return operationMap.get(operationName);
    }
}

