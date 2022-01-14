package amith.comprehensive.backend.service;
/**
 * 
 *@author Amith G
 *
 */
import java.util.List;

import amith.comprehensive.backend.customentity.CustomDoc;
import amith.comprehensive.backend.customentity.CustomPat;
import amith.comprehensive.backend.entity.Doctor;
import amith.comprehensive.backend.entity.Patient;

public interface HospitalService 
{

	public String addDoctor(Doctor doctor);

	public String addPatient(CustomPat pat);

	public CustomDoc getDoctor(String name);

	public Patient getPatient(Long id);

	public Doctor getPatientDoctor(String name);

	public List<Doctor> getDoctors();

}
