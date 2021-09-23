package com.Aptiv.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="action")
public class Action implements Serializable{

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public Long Id;
	
	@Column(name="Project" ,nullable=false, length=300)
	public String Project ;
	//family=code de reclamation
	//when posting internal/external finding in WK update all WK where family(code de reclamation) is
	//equal to family of the new WK
	@Column(name="Family",nullable=false, unique=false, length=300)
	public String Family;
	
	@Column(name="Line",nullable=false, unique=false, length=300)
	public String Line;

	
	@Column(name="Responsability",nullable=false, unique=false, length=300)
	public String Responsability;
	
	@Column(name="DefectDescription",nullable=false, unique=false, length=300)
	public String DefectDescription;
	
	@Column(name="Manalysis",nullable=false, unique=false, length=300)
	public String Manalysis;
		
	
	@Column(name="RootCause",nullable=false, unique=false, length=300)
	public String RootCause;
	
	@Column(name="ActionDescription",nullable=false, unique=false, length=300)
	public String ActionDescription;
	
	@Column(name="Department",nullable=true, unique=false, length=300)
	public String department;
	
	@Column(name="StartDate", nullable=false, length=300)
	public String StartDate;
	
	@Column(name="DueDate", nullable=false, length=300)
	public String DueDate;
	
	
	@Column(name="SecondDueDate",nullable=true, unique=false, length=300)
	public String SecondDueDate;
	
	@Column(name="ThirdDueDate",nullable=true, unique=false, length=300)
	public String ThirdDueDate;
	
	@Column(name="Status", nullable=false, length=300)
	public String Status;
	
	@Column(name="Comment", nullable=true, length=300)
	public String Comment;
	
	@Column(name="Progress",nullable=false, unique=false, length=300)
	public String Progress;
	
	@Column(name="KPI", nullable=false, length=300)
	public String kpi;
	
	@Column(name="Finding", nullable=false, length=300)
	public String finding;
	
	@Column(name="DetailedStatus", nullable=true, length=300)
	public String DetailedStatus;
	
	//weekly internal-external findings
	
		@Column(name="Wk0", nullable=true, length=300)
		public String Wk0;
		
		@Column(name="Wk1", nullable=true, length=300)
		public String Wk1;
		
		@Column(name="Wk2", nullable=true, length=300)
		public String Wk2;
		
		@Column(name="Wk3", nullable=true, length=300)
		public String Wk3;
		
		@Column(name="Wk4", nullable=true, length=300)
		public String Wk4;
		
		@Column(name="Wk5", nullable=true, length=300)
		public String Wk5;
		
		@Column(name="Wk6", nullable=true, length=300)
		public String Wk6;
		
		@Column(name="Wk7", nullable=true, length=300)
		public String Wk7;
		
		@Column(name="Wk8", nullable=true, length=300)
		public String Wk8;
		
		@Column(name="Wk9", nullable=true, length=300)
		public String Wk9;
		
		@Column(name="Wk10", nullable=true, length=300)
		public String Wk10;
		
		@Column(name="Wk11", nullable=true, length=300)
		public String Wk11;
		
		@Column(name="Wk12", nullable=true, length=300)
		public String Wk12;
		
		@Column(name="Wk13", nullable=true, length=300)
		public String Wk13;
		
		@Column(name="Wk14", nullable=true, length=300)
		public String Wk14;
		
		@Column(name="Wk15", nullable=true, length=300)
		public String Wk15;
		
		@Column(name="Wk16", nullable=true, length=300)
		public String Wk16;
		
		@Column(name="Wk17", nullable=true, length=300)
		public String Wk17;
		
		@Column(name="Wk18", nullable=true, length=300)
		public String Wk18;
		
		@Column(name="Wk19", nullable=true, length=300)
		public String Wk19;
		
		@Column(name="Wk20", nullable=true, length=300)
		public String Wk20;
		
		@Column(name="Wk21", nullable=true, length=300)
		public String Wk21;
		
		@Column(name="Wk22", nullable=true, length=300)
		public String Wk22;
		
		@Column(name="Wk23", nullable=true, length=300)
		public String Wk23;
		
		@Column(name="Wk24", nullable=true, length=300)
		public String Wk24;
		
		@Column(name="Wk25", nullable=true, length=300)
		public String Wk25;
	
//Relational Mapping
	
		@OneToOne(mappedBy = "action", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private OwResponse owresponse;
		
		@OneToOne(mappedBy = "action", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private MaResponse maresponse;
		
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;
		


		public void setActionplan(ActionPlan actionplan) {
			this.actionplan = actionplan;
		}

		@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "actionplan_id", nullable = false)
	    private ActionPlan actionplan;
		
		
//Getters and Setters		

		
		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}
		
		public String getProject() {
			return Project;
		}

		public void setProject(String project) {
			Project = project;
		}
		
		public String getFamily() {
			return Family;
		}

		public void setFamily(String family) {
			Family = family;
		}


		public String getLine() {
			return Line;
		}

		public void setLine(String line) {
			Line = line;
		}
		
		public String getResponsability() {
			return Responsability;
		}

		public void setResponsability(String responsability) {
			Responsability = responsability;
		}

		public String getDefectDescription() {
			return DefectDescription;
		}

		public void setDefectDescription(String defectDescription) {
			DefectDescription = defectDescription;
		}
		
		public String getManalysis() {
			return Manalysis;
		}

		public void setManalysis(String manalysis) {
			Manalysis = manalysis;
		}
		
		public String getRootCause() {
			return RootCause;
		}

		public void setRootCause(String rootCause) {
			RootCause = rootCause;
		}
		
		public String getActionDescription() {
			return ActionDescription;
		}

		public void setActionDescription(String actionDescription) {
			ActionDescription = actionDescription;
		}
		
		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}
		
		public String getStartDate() {
			return StartDate;
		}

		public void setStartDate(String startDate) {
			StartDate = startDate;
		}

		public String getDueDate() {
			return DueDate;
		}

		public void setDueDate(String dueDate) {
			DueDate = dueDate;
		}
		
		public String getSecondDueDate() {
			return SecondDueDate;
		}

		public void setSecondDueDate(String secondDueDate) {
			SecondDueDate = secondDueDate;
		}

		public String getThirdDueDate() {
			return ThirdDueDate;
		}

		public void setThirdDueDate(String thirdDueDate) {
			ThirdDueDate = thirdDueDate;
		}
		
		public String getStatus() {
			return Status;
		}

		public void setStatus(String status) {
			Status = status;
		}
		
		public String getComment() {
			return Comment;
		}

		public void setComment(String comment) {
			Comment = comment;
		}
		
		public String getProgress() {
			return Progress;
		}

		public void setProgress(String progress) {
			Progress = progress;
		}

		public String getKpi() {
			return kpi;
		}

		public void setKpi(String kpi) {
			this.kpi = kpi;
		}
		
		public String getFinding() {
			return finding;
		}

		public void setFinding(String finding) {
			this.finding = finding;
		}
		
		public String getDetailedStatus() {
			return DetailedStatus;
		}

		public void setDetailedStatus(String detailedStatus) {
			DetailedStatus = detailedStatus;
		}

		public OwResponse getOwresponse() {
			return owresponse;
		}

		public void setOwresponse(OwResponse owresponse) {
			this.owresponse = owresponse;
		}

		public MaResponse getMaresponse() {
			return maresponse;
		}

		public void setMaresponse(MaResponse maresponse) {
			this.maresponse = maresponse;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		


	public String getWk0() {
		return Wk0;
	}

	public void setWk0(String wk0) {
		Wk0 = wk0;
	}

	public String getWk1() {
		return Wk1;
	}

	public void setWk1(String wk1) {
		Wk1 = wk1;
	}

	public String getWk2() {
		return Wk2;
	}

	public void setWk2(String wk2) {
		Wk2 = wk2;
	}

	public String getWk3() {
		return Wk3;
	}

	public void setWk3(String wk3) {
		Wk3 = wk3;
	}

	public String getWk4() {
		return Wk4;
	}

	public void setWk4(String wk4) {
		Wk4 = wk4;
	}

	public String getWk5() {
		return Wk5;
	}

	public void setWk5(String wk5) {
		Wk5 = wk5;
	}

	public String getWk6() {
		return Wk6;
	}

	public void setWk6(String wk6) {
		Wk6 = wk6;
	}

	public String getWk7() {
		return Wk7;
	}

	public void setWk7(String wk7) {
		Wk7 = wk7;
	}

	public String getWk8() {
		return Wk8;
	}

	public void setWk8(String wk8) {
		Wk8 = wk8;
	}

	public String getWk9() {
		return Wk9;
	}

	public void setWk9(String wk9) {
		Wk9 = wk9;
	}

	public String getWk10() {
		return Wk10;
	}

	public void setWk10(String wk10) {
		Wk10 = wk10;
	}

	public String getWk11() {
		return Wk11;
	}

	public void setWk11(String wk11) {
		Wk11 = wk11;
	}

	public String getWk12() {
		return Wk12;
	}

	public void setWk12(String wk12) {
		Wk12 = wk12;
	}

	public String getWk13() {
		return Wk13;
	}

	public void setWk13(String wk13) {
		Wk13 = wk13;
	}

	public String getWk14() {
		return Wk14;
	}

	public void setWk14(String wk14) {
		Wk14 = wk14;
	}

	public String getWk15() {
		return Wk15;
	}

	public void setWk15(String wk15) {
		Wk15 = wk15;
	}

	public String getWk16() {
		return Wk16;
	}

	public void setWk16(String wk16) {
		Wk16 = wk16;
	}

	public String getWk17() {
		return Wk17;
	}

	public void setWk17(String wk17) {
		Wk17 = wk17;
	}

	public String getWk18() {
		return Wk18;
	}

	public void setWk18(String wk18) {
		Wk18 = wk18;
	}

	public String getWk19() {
		return Wk19;
	}

	public void setWk19(String wk19) {
		Wk19 = wk19;
	}

	public String getWk20() {
		return Wk20;
	}

	public void setWk20(String wk20) {
		Wk20 = wk20;
	}

	public String getWk21() {
		return Wk21;
	}

	public void setWk21(String wk21) {
		Wk21 = wk21;
	}

	public String getWk22() {
		return Wk22;
	}

	public void setWk22(String wk22) {
		Wk22 = wk22;
	}

	public String getWk23() {
		return Wk23;
	}

	public void setWk23(String wk23) {
		Wk23 = wk23;
	}

	public String getWk24() {
		return Wk24;
	}

	public void setWk24(String wk24) {
		Wk24 = wk24;
	}

	public String getWk25() {
		return Wk25;
	}

	public void setWk25(String wk25) {
		Wk25 = wk25;
	}




}
