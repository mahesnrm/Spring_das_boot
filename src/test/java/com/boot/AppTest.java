package com.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boot.controller.HomeController;

public class AppTest {
	
	@Test
    public void testHomeController(){
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals(result, "Das-boot ready for duty");
    }
}
