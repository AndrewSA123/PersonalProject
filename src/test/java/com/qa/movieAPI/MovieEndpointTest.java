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

import com.qa.business.service.IMovieService;
import com.qa.rest.MovieEndPoint;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


@RunWith(MockitoJUnitRunner.class)
public class MovieEndpointTest {

	
	
	private static final String exampleGenre = "{\"gid\": 1,\"name\": \"RomCom\"}";
	private static final String exampleGenre2 = "{\"gid\": 1,\"name\": \"Comedy\"}";
	private static final String exampleActor = "{\"aid\": 1,\"name\": \"Gareth\", \"age\":\"69\"}";
	private static final String exampleActor2 = "{\"aid\": 1,\"name\": \"Toby\", \"age\":\"420\"}";
	private static final String exampleDirector = "{\"aid\": 1,\"name\": \"Gareth\", \"age\":\"69\"}";
	private static final String exampleDirector2 = "{\"aid\": 1,\"name\": \"Toby\", \"age\":\"420\"}";
	private static final String exampleMovie = "{\"title\":\"MovieExample\", \"aid\":" + exampleActor + ", \"gid\":" + exampleGenre + ", \"did\":" + exampleDirector + "}";
	private static final String exampleMovie2 = "{\"title\":\"MovieExample2\", \"aid\":" + exampleActor2 + ", \"gid\":" + exampleGenre2 + ", \"did\":" + exampleDirector2 + "}";
	private static ExtentTest test;
	private static ExtentReports report;
	
	
	@InjectMocks 
	private MovieEndPoint me;
	
	@Mock
	private IMovieService service;
	

	@BeforeClass
	public static void setupReports() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\SoloProjectReports\\MovieTestLog.html", true);
		test = report.startTest("Verify API");
	}
	
	@AfterClass
	public static void tearDownReports() {
		report.flush();
	}
	
	@Before
	public void setup() {
		me.setService(service);
	}
	
	@After
	public void tearDown() {
		report.endTest(test);
	}
	
	@Test
	public void createMovieTest() {
		test = report.startTest("Verify create movie method");
		Mockito.when(me.createMovie(exampleMovie)).thenReturn("Success");
		if(me.createMovie(exampleMovie).equals("Success")) {
			test.log(LogStatus.PASS, "Successfully created movie!");
		}else {
			test.log(LogStatus.FAIL, "Failed to create movie!");
		}
		assertEquals("Success", me.createMovie(exampleMovie));
	}
	
	@Test
	public void deleteMovieTest() {
		test = report.startTest("Verify delete movie method");
		Mockito.when(me.deleteMovie(1l)).thenReturn("Success");
		if(me.deleteMovie(1l).equals("Success")) {
			test.log(LogStatus.PASS, "Successfully deleted movie!");
		}else {
			test.log(LogStatus.FAIL, "Failed to delete movie!");
		}
		assertEquals("Success", me.deleteMovie(1l));
	}
	
	@Test
	public void updateMovieTest() {
		test = report.startTest("Verify update movie method");
		Mockito.when(me.updateMovie(1l, exampleMovie2)).thenReturn("Success");
		if(me.updateMovie(1l, exampleMovie2).equals("Success")) {
			test.log(LogStatus.PASS, "Successfully updated movie!");
		}else {
			test.log(LogStatus.FAIL, "Failed to update movie!");
		}
		assertEquals("Success", me.updateMovie(1l, exampleMovie2));
	}
	
	
}