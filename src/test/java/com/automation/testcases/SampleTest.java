package com.automation.testcases;

import com.automation.utilities.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

//this is a sample test class
public class SampleTest extends BaseClass {

    @Test
    public void sampleTestCase(Method method) {
        logger = report.createTest(method.getName());
    }

}
