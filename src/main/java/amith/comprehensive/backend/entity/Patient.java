package amith.comprehensive.backend.entity;
/**
 * 
 *@author Amith G
 *
 */
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Patient 
{
	@Id
	private Long pid;
	private String pname;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="visiteddoctor", referencedColumnName="did")
	private Doctor doctor;
	
	private int age;
	
	private String dateofvisit;
	
	private String prescription="";
	
	public Patient() {
		super();
	}

	public Patient(Long pid, String pname, Doctor doctor, int age, String dateofvisit, String prescription) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.doctor = doctor;
		this.age = age;
		this.dateofvisit = dateofvisit;
		this.prescription = prescription;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDateofvisit() {
		return dateofvisit;
	}

	public void setDateofvisit(String date) {
		this.dateofvisit = date;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", doctor=" + doctor + ", age=" + age + ", dateofvisit="
				+ dateofvisit + ", prescription=" + prescription + "]";
	}

}
