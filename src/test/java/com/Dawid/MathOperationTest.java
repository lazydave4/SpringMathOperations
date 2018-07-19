package com.Dawid;

import org.junit.Assert;
import org.junit.Test;

public class MathOperationTest {

 @Test
    public void mathOperationTest_correctOperation(){

     MathOperation mathOperation =new MathOperation() ;
     int correctOperation= mathOperation.execut(2,3);
     Assert.assertEquals(-26,correctOperation);
 }
 @Test(expected = BiggerNumbersThanThousand.class)
    public void mathOperationTest_incorrectOperation(){

    MathOperation mathOperation =new MathOperation() ;
    int correctOperation= mathOperation.execut(Integer.MAX_VALUE,Integer.MAX_VALUE);
    Assert.assertEquals(26,correctOperation);
 }
}
