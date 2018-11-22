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

import com.qa.business.service.IGenreService;
import com.qa.rest.GenreEndPoint;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


@RunWith(MockitoJUnitRunner.class)
public class GenreEndpointTest {

	private static final String exampleGenre = "{\"gid\": 1,\"name\": \"RomCom\"}";
	private static final String exampleGenre2 = "{\"gid\": 1,\"name\": \"Comedy\"}";
	private static ExtentTest test;
	private static ExtentReports report;
	
	
	@InjectMocks 
	private GenreEndPoint ge;
	
	@Mock
	private IGenreService service;
	

	@BeforeClass
	public static void setupReports() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\SoloProjectReports\\GenreTestLog.html", true);
		test = report.startTest("Verify API");
	}
	
	@AfterClass
	public static void tearDownReports() {
		report.flush();
	}
	
	@Before
	public void setup() {
		ge.setService(service);
	}
	
	@After
	public void tearDown() {
		report.endTest(test);
	}
	
	@Test
	public void createGenreTest() {
		test = report.startTest("Verify create genre method");
		Mockito.when(ge.createGenre(exampleGenre)).thenReturn("Success");
		if(ge.createGenre(exampleGenre).equals("Success")) {
			test.log(LogStatus.PASS, "Successfully created genre!");
		}else {
			test.log(LogStatus.FAIL, "Failed to create genre!");
		}
		assertEquals("Success", ge.createGenre(exampleGenre));
	}
	
	@Test
	public void deleteGenreTest() {
		test = report.startTest("Verify delete genre method");
		Mockito.when(ge.deleteGenre(1l)).thenReturn("Success");
		if(ge.deleteGenre(1l).equals("Success")) {
			test.log(LogStatus.PASS, "Successfully deleted genre!");
		}else {
			test.log(LogStatus.FAIL, "Failed to delete genre!");
		}
		assertEquals("Success", ge.deleteGenre(1l));
	}
	
	@Test
	public void updateGenreTest() {
		test = report.startTest("Verify update genre method");
		Mockito.when(ge.updateGenre(1l, exampleGenre2)).thenReturn("Success");
		if(ge.updateGenre(1l, exampleGenre2).equals("Success")) {
			test.log(LogStatus.PASS, "Successfully updated genre!");
		}else {
			test.log(LogStatus.FAIL, "Failed to update genre!");
		}
		assertEquals("Success", ge.updateGenre(1l, exampleGenre2));
	}
	
	
}
