package com.Dawid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @RequestMapping("/adding")
    public int adding(@RequestParam(value = "first") String first, @RequestParam(value = "second") String second) {

        return Integer.parseInt(first) + Integer.parseInt(second);

    }

    @RequestMapping("/substract")
    public int substract(@RequestParam(value = "first") String first, @RequestParam(value = "second") String second) {

        return Integer.parseInt(first) - Integer.parseInt(second);

    }

    @RequestMapping("/multiply")
    public int multiply(@RequestParam(value = "first") String first, @RequestParam(value = "second") String second) {

        return Integer.parseInt(first) * Integer.parseInt(second);

    }

    @RequestMapping("/division")
    public int division(@RequestParam(value = "first") String first, @RequestParam(value = "second") String second) {

        return Integer.parseInt(first) / Integer.parseInt(second);

    }

    @RequestMapping("/exponentiation")
    public double exponentiation(@RequestParam(value = "first") double first, @RequestParam(value = "second") double second) {

        return Math.pow(first, second);

    }

    @Autowired
    private OperationLogger operationLogger;

    @RequestMapping(value = "/operation")
    public Result operation(@RequestParam(value = "operation") String operation, @RequestParam(value = "first") String first, @RequestParam(value = "second") String second) {
        OperationData operationData = new OperationData();
        operationData.setOperation(operation);
        operationData.setFirst(Integer.parseInt(first));
        operationData.setSecond(Integer.parseInt(second));
        operationLogger.log(operationData);
        return (operationService.execute(operation, first, second));

    }

    @Autowired
    private OperationService operationService;

    @Autowired
    private OperationReader operationReader;

    @RequestMapping("/operationData")
    public List<OperationData> getOperationList() {

        return operationReader.getOperationList();

    }

    @ExceptionHandler({BiggerNumbersThanThousand.class})
    public ErrorDescription comeBackFirstException(BiggerNumbersThanThousand ex) {
        return ex.getDetailedException();

    }

    @ExceptionHandler({NumberFromZero.class})
    public ErrorDescription comeBackSecondException(NumberFromZero ex) {
        return ex.getErrorDescription();
    }


}


