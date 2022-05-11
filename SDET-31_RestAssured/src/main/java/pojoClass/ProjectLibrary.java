package pojoClass;

public class ProjectLibrary {
	//step1:declare the variables globally
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
	//step2: create a constructor to initialize the variable

	public ProjectLibrary(String createdBy, String projectName, String status, int teamSize) 
	{
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}	
	//step3: provide getter and setters to access these variables

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
}
