package com.Dawid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    @Autowired
    private List<Operation> operations;
    @Autowired
    private OperationReader operationReader;

    public Result execute(String first, String second, String third) {
        return new Result(operations.stream().filter(name -> name.name().equals(first)).map(operation -> operation.execut(Integer.parseInt(second), Integer.parseInt(third))).findFirst().get());
    }

    public HistoricOperation selectNewRecord() {
        HistoricOperation historicOperation = new HistoricOperation();
        historicOperation.operationDataList = operationReader.selectRecord();
        return historicOperation;
    }

    public void duplicationsList() {

        HistoricOperation historicOperation = selectNewRecord();
        for (OperationData operationData : historicOperation.operationDataList) {
            int count = 0;
            for (OperationData operationData1 : historicOperation.operationDataList) {
                if (operationData.equals(operationData1)) {
                    count++;
                }
            }
            if (count > 1) {
                throw new DuplicationsAreInTheListExpotion();
            }
        }

    }

}











