package com.abhi.utils;

import com.abhi.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.Objects;

public final class DataProviderUtils {

    /**
     * Private constructor to avoid external instantiation
     */
    private DataProviderUtils() {}

    private static List<Map<String, String>> list =	new ArrayList<>();

    @DataProvider(parallel=false)
    public static Object[] getData(Method m) {
        String testname = m.getName();

        if(list.isEmpty()) {
            list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDatasheet());
            System.out.println(list);
        }
        List<Map<String, String>> smalllist = new ArrayList<>(list);

        Predicate<Map<String,String>> isTestNameNotMatching = map ->!map.get("testname").equalsIgnoreCase(testname);
        Predicate<Map<String,String>> isExecuteColumnNo = map -> map.get("execute").equalsIgnoreCase("no");

        smalllist.removeIf(isTestNameNotMatching.or(isExecuteColumnNo));
        return smalllist.toArray();

    }

}
