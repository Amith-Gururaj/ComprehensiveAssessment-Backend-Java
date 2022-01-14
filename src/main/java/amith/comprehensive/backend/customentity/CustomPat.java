package amith.comprehensive.backend.customentity;
/**
 * 
 *@author Amith G
 *
 */
public class CustomPat 
{
	private Long pid;
	private String pname;
	private String doctorname;
	private int page;
	private String dateofvisit;
	private String prescription="";

	public CustomPat() {
		super();
	}

	public CustomPat(Long pid, String pname, String doctorname, int page, String dateofvisit, String prescription) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.doctorname = doctorname;
		this.page = page;
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

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getDateofvisit() {
		return dateofvisit;
	}

	public void setDateofvisit(String dateofvisit) {
		this.dateofvisit = dateofvisit;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "CustomPat [pid=" + pid + ", pname=" + pname + ", doctorname=" + doctorname + ", page=" + page
				+ ", dateofvisit=" + dateofvisit + ", prescription=" + prescription + "]";
	}
	
}
