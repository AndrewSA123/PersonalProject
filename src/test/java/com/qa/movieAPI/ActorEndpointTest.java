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
import com.qa.business.service.IGenreService;
import com.qa.rest.ActorEndPoint;
import com.qa.rest.GenreEndPoint;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


@RunWith(MockitoJUnitRunner.class)
public class ActorEndpointTest {

	private static final String exampleActor = "{\"aid\": 1,\"name\": \"Gareth\", \"age\":\"69\"}";
	private static final String exampleActor2 = "{\"aid\": 1,\"name\": \"Toby\", \"age\":\"420\"}";
	private static ExtentTest test;
	private static ExtentReports report;
	
	
	@InjectMocks 
	private ActorEndPoint ae;
	
	@Mock
	private IActorService service;
	

	@BeforeClass
	public static void setupReports() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\SoloProjectReports\\ActorTestLog.html", true);
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
	public void createActorTest() {
		test = report.startTest("Verify create actor method");
		Mockito.when(ae.createActor(exampleActor)).thenReturn("Success");
		if(ae.createActor(exampleActor).equals("Success")) {
			test.log(LogStatus.PASS, "Successfully created actor!");
		}else {
			test.log(LogStatus.FAIL, "Failed to create actor!");
		}
		assertEquals("Success", ae.createActor(exampleActor));
	}
	
	@Test
	public void deleteActorTest() {
		test = report.startTest("Verify delete actor method");
		Mockito.when(ae.deleteActor(1l)).thenReturn("Success");
		if(ae.deleteActor(1l).equals("Success")) {
			test.log(LogStatus.PASS, "Successfully deleted actor!");
		}else {
			test.log(LogStatus.FAIL, "Failed to delete actor!");
		}
		assertEquals("Success", ae.deleteActor(1l));
	}
	
	@Test
	public void updateActorTest() {
		test = report.startTest("Verify update actor method");
		Mockito.when(ae.updateActor(1l, exampleActor2)).thenReturn("Success");
		if(ae.updateActor(1l, exampleActor2).equals("Success")) {
			test.log(LogStatus.PASS, "Successfully updated actor!");
		}else {
			test.log(LogStatus.FAIL, "Failed to update actor!");
		}
		assertEquals("Success", ae.updateActor(1l, exampleActor2));
	}
	
	
}
