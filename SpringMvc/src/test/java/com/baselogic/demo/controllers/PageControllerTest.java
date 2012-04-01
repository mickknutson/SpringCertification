package com.baselogic.demo.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.baselogic.demos.util.AppUtils;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(AppUtils.class)
public class PageControllerTest {
	
	@Mock
	AppUtils imageUtil;

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
