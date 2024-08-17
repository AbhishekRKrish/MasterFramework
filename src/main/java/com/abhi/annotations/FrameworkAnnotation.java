package com.abhi.annotations;

import com.abhi.enums.CategoryType;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {
    /**
     * Store the authors who created the test cases
     * @author Abhishek
     */
    public String[] author();

    /**
     */
    public CategoryType[] category();

}