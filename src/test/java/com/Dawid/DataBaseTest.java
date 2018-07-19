package com.Dawid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class DataBaseTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    OperationReader operationReader;

    @Autowired
    OperationLogger operationLogger;

    @Test
    public void deleteTestRecordsWhenFirstColumnIsLessThanFive() {
        //given
        assertEquals(operationReader.getOperationList().size(), 0);
        //when
        OperationData delete = new OperationData("delete", 2, 1);
        operationLogger.log(delete);
        assertEquals(operationReader.getOperationList().size(), 1);
        operationReader.deleteRecords();
        operationReader.getOperationList();
        //then
        assertEquals(operationReader.getOperationList().size(), 0);
    }

    @Test
    public void addRecordsWhenFirstColumnIsAboveThanFive() {
        OperationData adding = new OperationData("adding", 6, 2);
        operationLogger.log(adding);
        operationReader.deleteRecords();
        assertEquals(operationReader.getOperationList().size(), 1);

    }

    @Test
    public void updateTestWhenFirstColumnIsEqualsEight() {
        //given
        assertEquals(operationReader.getOperationList().size(), 0);
        //when
        OperationData adding = new OperationData("adding", 8, 2);
        OperationData addingTwo = new OperationData("adding", 8, 2);
        operationLogger.log(adding);
        operationLogger.log(addingTwo);
        operationReader.updateRecords("adding");
        //then
        List<OperationData> operationDataList = operationReader.getOperationList();
        assertEquals(operationDataList.size(), 2);

        operationDataList.forEach(operationData -> {
            assertEquals(operationData.getOperation(), "adding");
            assertEquals(operationData.getFirst(), 8);
        });
    }

    @Test
    public void updateTestWhenSecondColumnIsEqualsSeven() {
        //given
        OperationData substract = new OperationData("substract", 8, 2);
        OperationData substractTwo = new OperationData("substract", 8, 2);
        operationLogger.log(substract);
        operationLogger.log(substractTwo);
        //when
        operationReader.updateRecords("substract");
        //then
        List<OperationData> operationDataList = operationReader.getOperationList();
        assertEquals(operationDataList.size(), 2);

        operationDataList.forEach(operationData -> {
            assertEquals(operationData.getOperation(), "substract");
            assertEquals(operationData.getSecond(), 7);
        });
    }

    @Test
    public void selectTestCorrectList() {
        OperationData select = new OperationData("adding", 2, 6);
        operationLogger.log(select);
        operationReader.selectRecord();
        assertEquals(operationReader.selectRecord().size(), 0);
    }

    @Test
    public void selectTestCorrectConditions() {
        assertEquals(operationReader.selectRecord().size(), 0);
        OperationData select = new OperationData("adding", 2, 6);
        OperationData selectTwo = new OperationData("adding", 2, 6);
        operationLogger.log(select);
        operationLogger.log(selectTwo);
        operationReader.selectRecord();

        List<OperationData> operationDataList = operationReader.selectRecord();
        assertEquals(operationReader.selectRecord().size(), 0);
        operationDataList.forEach(operationData -> {
            assertEquals(operationData.getFirst(), 2);
            assertEquals(operationData.getSecond(), 6);
        });
    }

    @Test
    public void selectRecord_test() {
        OperationData select = new OperationData("select", -1, 8);
        OperationData select2 = new OperationData("select", 2, -5);
        operationLogger.log(select);
        operationLogger.log(select2);

        List<OperationData> operationData = operationReader.selectRecord();
        assertEquals(1, operationData.size());
    }

    @Test
    public void selectRecord_testNull() {
        OperationData select = new OperationData(null, 2, 8);
        OperationData select2 = new OperationData(null, 2, 6);
        operationLogger.log(select);
        operationLogger.log(select2);

        List<OperationData> operationData = operationReader.selectRecord();
        assertEquals(0, operationData.size());
    }
}
