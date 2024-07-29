package PojoClass;

public class GetCourseDetails {
	private String url;
	private String services;
	private String expertise;
	private Course courses;
	private String instructor;
	private	String linkedIn;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getServices() {
		return services;
	}
	
	public void setServices(String services) {
		this.services = services;
	}
	
	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public PojoClass.Course getCourses() {
		return courses;
	}

	public void setCourses(PojoClass.Course courses) {
		this.courses = courses;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	

}
