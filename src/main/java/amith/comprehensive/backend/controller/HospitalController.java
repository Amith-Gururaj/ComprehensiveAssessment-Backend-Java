package amith.comprehensive.backend.controller;
/**
 * 
 *@author Amith G
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import amith.comprehensive.backend.customentity.CustomDoc;
import amith.comprehensive.backend.customentity.CustomPat;
import amith.comprehensive.backend.entity.Doctor;
import amith.comprehensive.backend.entity.Patient;
import amith.comprehensive.backend.service.HospitalService;

@RestController
@RequestMapping(path="/hospital")
@CrossOrigin(origins = "*")
public class HospitalController 
{
	@Autowired
	private HospitalService service;

	public HospitalController(HospitalService service) {
		super();
		this.service = service;
	}
	
	//add the doctor
	@PostMapping(path="/add/doctor")
	public String addNewDoctor(@RequestBody Doctor doctor)
	{
		return service.addDoctor(doctor);
	}
	
	//add the patient
	@PostMapping(path="/add/patient")
	public String addNewPatient(@RequestBody CustomPat pat) 
	{
		return service.addPatient(pat);
	}
	
	//get doctor by name
	@GetMapping(path="/get/doctorByName/{name}")
	public CustomDoc getDoctorByName(@PathVariable(value="name") String name)
	{
		return service.getDoctor(name);
	}
	
	//get patient by id
	@GetMapping(path="/get/patientById/{id}")
	public Patient getPatientById(@PathVariable(value="id") Long id)
	{
		return service.getPatient(id);
	}
	
	//get all doctors
	@GetMapping(path="/get/doctors")
	public List<Doctor> getAllDoctors()
	{
		return service.getDoctors();
	}
	
	//get all patients
	@GetMapping(path="/get/patients")
	public List<Patient> getAllPatients()
	{
		return service.getPatients();
	}
	
	//update Patient
	@PutMapping(path="/update/patient/{id}")
	public String updatePatient(@PathVariable(value="id") Long id, @RequestBody CustomPat pat)
	{
		return service.updatePatientById(id,pat);
	}
	
	//update Doctor
	@PutMapping(path="/update/doctor/{id}")
	public String updateDoctor(@PathVariable(value="id") Long id, @RequestBody Doctor doc)
	{
		return service.updateDoctorById(id,doc);
	}
	
}
