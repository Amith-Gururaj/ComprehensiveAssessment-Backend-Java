package amith.comprehensive.backend.customentity;
/**
 * 
 *@author Amith G
 *
 */
public class CustomDoc 
{
	private Long id;
	private String name;
	private int age;
	private String gender;
	private String specialist;
	private int noofpatientattended;
	
	public CustomDoc() {
		super();
	}

	public CustomDoc(Long id, String name, int age, String gender, String specialist, int noofpatientattended) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialist = specialist;
		this.noofpatientattended = noofpatientattended;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public int getNoofpatientattended() {
		return noofpatientattended;
	}

	public void setNoofpatientattended(int noofpatientattended) {
		this.noofpatientattended = noofpatientattended;
	}

	@Override
	public String toString() {
		return "CustomDoc [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", specialist="
				+ specialist + ", noofpatientattended=" + noofpatientattended + "]";
	}
	
}
