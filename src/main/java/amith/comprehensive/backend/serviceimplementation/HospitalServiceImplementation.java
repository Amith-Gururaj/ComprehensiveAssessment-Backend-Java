package amith.comprehensive.backend.serviceimplementation;
/**
 * 
 *@author Amith G
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amith.comprehensive.backend.customentity.CustomDoc;
import amith.comprehensive.backend.customentity.CustomPat;
import amith.comprehensive.backend.entity.Doctor;
import amith.comprehensive.backend.entity.Patient;
import amith.comprehensive.backend.repository.DoctorRepository;
import amith.comprehensive.backend.repository.PatientRepository;
import amith.comprehensive.backend.service.HospitalService;

@Service
public class HospitalServiceImplementation implements HospitalService
{
	@Autowired
	private DoctorRepository doctorrepo;
	
	@Autowired
	private PatientRepository patientrepo;

	public HospitalServiceImplementation(DoctorRepository doctorrepo, PatientRepository patientrepo) {
		super();
		this.doctorrepo = doctorrepo;
		this.patientrepo = patientrepo;
	}

	@Override
	public String addDoctor(Doctor doctor) {
		Doctor checkdoc = doctorrepo.findByDid(doctor.getDid());
		if(checkdoc==null)
		{
			doctorrepo.save(doctor);
			return "Doctor Added Successfully";
		}
		else
			return "Doctor with this Id already present... Failed to Add . Try with new Id";
	}

	@Override
	public String addPatient(CustomPat pat) {
		Patient checkpat = patientrepo.findByPid(pat.getPid());
		if(checkpat==null)
		{
			Doctor doc = getPatientDoctor(pat.getDoctorname());
			Patient patient = new Patient(pat.getPid(),pat.getPname(),doc,pat.getPage(),pat.getDateofvisit(),pat.getPrescription());
		    patientrepo.save(patient);
			return "Patient Added Successfully";
		}
		else 
			return "Patient with this Id already present... Failed to Add . Try with new Id";
	}

	@Override
	public CustomDoc getDoctor(String name) {
		Doctor doctor = doctorrepo.findByDname(name);
		CustomDoc response = new CustomDoc(doctor.getDid(),doctor.getDname(),doctor.getDage(),doctor.getDgender(),doctor.getDspecialist(),doctor.getPatient().size());
		return response;
	}

	@Override
	public Patient getPatient(Long id) {
		return patientrepo.findByPid(id);
	}

	@Override
	public Doctor getPatientDoctor(String name) {
		return doctorrepo.findByDname(name);
	}

	@Override
	public List<Doctor> getDoctors() {
		return doctorrepo.findAll();
	}

	@Override
	public List<Patient> getPatients() {
		return patientrepo.findAll();
	}

	@Override
	public String updatePatientById(Long id, CustomPat pat) {
		Doctor doc = getPatientDoctor(pat.getDoctorname());
		Patient patient = new Patient(pat.getPid(),pat.getPname(),doc,pat.getPage(),pat.getDateofvisit(),pat.getPrescription());
	    patientrepo.save(patient);
		return "Patient Details Updated Successfully";
	}

	@Override
	public String updateDoctorById(Long id, Doctor doc) {
		doctorrepo.save(doc);
		return "Doctor Details Updated Successfully";
	}

}
