package amith.comprehensive.backend.entity;
/**
 * 
 *@author Amith G
 *
 */
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Doctor 
{
	@Id
	private Long did;
	private String dname;
	private int dage;
	private String dgender;
	private String dspecialist;
	
	@OneToMany(mappedBy="doctor")
	@JsonIgnore
	private List<Patient> patient;

	public Doctor() {
		super();
	}

	public Doctor(Long did, String dname, int dage, String dgender, String dspecialist, List<Patient> patient) {
		super();
		this.did = did;
		this.dname = dname;
		this.dage = dage;
		this.dgender = dgender;
		this.dspecialist = dspecialist;
		this.patient = patient;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getDage() {
		return dage;
	}

	public void setDage(int dage) {
		this.dage = dage;
	}

	public String getDgender() {
		return dgender;
	}

	public void setDgender(String dgender) {
		this.dgender = dgender;
	}

	public String getDspecialist() {
		return dspecialist;
	}

	public void setDspecialist(String dspecialist) {
		this.dspecialist = dspecialist;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", dage=" + dage + ", dgender=" + dgender + ", dspecialist="
				+ dspecialist + ", patient=" + patient + "]";
	}
}
