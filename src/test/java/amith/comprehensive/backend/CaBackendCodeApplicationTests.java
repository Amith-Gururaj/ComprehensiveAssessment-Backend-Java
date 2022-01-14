package amith.comprehensive.backend;
/**
 * 
 *@author Amith G
 *
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import amith.comprehensive.backend.controller.HospitalController;
import amith.comprehensive.backend.customentity.CustomPat;
import amith.comprehensive.backend.entity.Doctor;
import amith.comprehensive.backend.entity.Patient;
import amith.comprehensive.backend.repository.DoctorRepository;
import amith.comprehensive.backend.repository.PatientRepository;

@SpringBootTest
class CaBackendCodeApplicationTests {
	
	@Autowired
	private HospitalController service;

	@MockBean
	private DoctorRepository docrepository;
	
	@MockBean
	private PatientRepository patrepository;
	
	@BeforeAll
	public static void startingTest()
	{
		System.out.println("Junit with Mockito testing for the Hospital Controller started");
	}
	
	@AfterAll
	public static void closingTest()
	{
		System.out.println("Junit with Mockito testing for the Hospital Controller ended Successfully");
	}

	@BeforeEach
	public void beforeEach(TestInfo Info)
	{
		System.out.println("Started Testing "+ Info.getDisplayName());
	}
	
	@AfterEach
	public void afterEach(TestInfo Info)
	{
		System.out.println(Info.getDisplayName()+" Testing Ended");
	}
	
	@Test
	@DisplayName("Save Doctor")
	public void saveDoctorTest() {
		Doctor doctor = new Doctor(9L, "Amith", 33, "Male","Surgeon",null);
		when(docrepository.save(doctor)).thenReturn(doctor);
		String expected = "";
		if(doctor!=null)
		{
			expected = "Doctor Added Successfully";
		}
		assertEquals(expected, service.addNewDoctor(doctor));
	}
	
	@Test
	@DisplayName("Save Patient")
	public void savePatientTest() {
		CustomPat pat = new CustomPat(9L, "Vishal", "Amith" , 25 ,"2021/11/23","Migrane");
		Doctor doc = new Doctor(9L, "Amith", 33, "Male","Surgeon",null);
		Patient patient = new Patient(pat.getPid(),pat.getPname(),doc,pat.getPage(),pat.getDateofvisit(),pat.getPrescription());
		when(patrepository.save(patient)).thenReturn(patient);
		String expected = "";
		if(patient!=null)
		{
			expected = "Patient Added Successfully";
		}
		assertEquals(expected, service.addNewPatient(pat));
	}
	
	@Test
	@DisplayName("Get Doctor By Name")
	public void getDoctorbyNameTest() {
		String name = "Amith";
		Doctor doc = new Doctor(9L, "Amith", 33, "Male","Surgeon",null);
		when(docrepository.findByDname(name))
				.thenReturn(doc);
		assertNotNull(doc);
	}
	
	@Test
	@DisplayName("Get Patient By Id")
	public void getPatientByIdTest()
	{
		Long pid = 5L;
		Doctor doc = new Doctor(9L, "Amith", 33, "Male","Surgeon",null);
		Patient pat = new Patient(5L, "Vishal",doc, 25 ,"2021/11/23","Migrane");
		when(patrepository.findByPid(pid)).thenReturn(pat);
		assertEquals(pat, service.getPatientById(pid));
	}
	
	@Test
	@DisplayName("Get All Doctors")
	public void getAllDoctorsTest()
	{
		when(docrepository.findAll()).thenReturn(Stream.of(new Doctor(9L, "Amith", 33, "Male","Surgeon",null), new Doctor(5L, "Arjun", 27, "Male","Surgeon",null)).collect(Collectors.toList()));
		assertEquals(2, service.getAllDoctors().size());
	}
	
	
}
