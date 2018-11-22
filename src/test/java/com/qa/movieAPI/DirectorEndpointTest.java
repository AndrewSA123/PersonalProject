package com.qa.movieAPI;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.IActorService;
import com.qa.business.service.IDirectorService;
import com.qa.business.service.IGenreService;
import com.qa.rest.ActorEndPoint;
import com.qa.rest.DirectorEndPoint;
import com.qa.rest.GenreEndPoint;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


@RunWith(MockitoJUnitRunner.class)
public class DirectorEndpointTest {

	private static final String exampleDirector = "{\"aid\": 1,\"name\": \"Gareth\", \"age\":\"69\"}";
	private static final String exampleDirector2 = "{\"aid\": 1,\"name\": \"Toby\", \"age\":\"420\"}";
	private static ExtentTest test;
	private static ExtentReports report;
	
	
	@InjectMocks 
	private DirectorEndPoint ae;
	
	@Mock
	private IDirectorService service;
	

	@BeforeClass
	public static void setupReports() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\SoloProjectReports\\DirectorTestLog.html", true);
		test = report.startTest("Verify API");
	}
	
	@AfterClass
	public static void tearDownReports() {
		report.flush();
	}
	
	@Before
	public void setup() {
		ae.setService(service);
	}
	
	@After
	public void tearDown() {
		report.endTest(test);
	}
	
	@Test
	public void createDirectorTest() {
		test = report.startTest("Verify create director method");
		Mockito.when(ae.createDirector(exampleDirector)).thenReturn("Success");
		if(ae.createDirector(exampleDirector).equals("Success")) {
			test.log(LogStatus.PASS, "Successfully created director!");
		}else {
			test.log(LogStatus.FAIL, "Failed to create director!");
		}
		assertEquals("Success", ae.createDirector(exampleDirector));
	}
	
	@Test
	public void deleteDirectorTest() {
		test = report.startTest("Verify delete director method");
		Mockito.when(ae.deleteDirector(1l)).thenReturn("Success");
		if(ae.deleteDirector(1l).equals("Success")) {
			test.log(LogStatus.PASS, "Successfully deleted director!");
		}else {
			test.log(LogStatus.FAIL, "Failed to delete director!");
		}
		assertEquals("Success", ae.deleteDirector(1l));
	}
	
	@Test
	public void updateDirectorTest() {
		test = report.startTest("Verify update director method");
		Mockito.when(ae.updateDirector(1l, exampleDirector2)).thenReturn("Success");
		if(ae.updateDirector(1l, exampleDirector2).equals("Success")) {
			test.log(LogStatus.PASS, "Successfully updated director!");
		}else {
			test.log(LogStatus.FAIL, "Failed to update director!");
		}
		assertEquals("Success", ae.updateDirector(1l, exampleDirector2));
	}
	
	
}
