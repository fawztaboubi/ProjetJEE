package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Membre")
public class Membre {
  
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true, length=11)
	public int Id;
	
	@Column(name="Name",nullable=false, unique=false, length=20)
	public String Name;
	
	@Column(name="FamilyName", nullable=false, unique=false, length=20)
	public String FamilyName;
	
	@Column(name="Department", nullable=true, length=20)
	public String Department;
	
	@Column(name="Phone", nullable=false, length=20)
	public int Phone;
	
	@Column(name="Email", nullable=false, length=25)
	public String Email;
	
	@ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFamilyName() {
		return FamilyName;
	}

	public void setFamilyName(String familyName) {
		FamilyName = familyName;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public int getPhone() {
		return Phone;
	}

	public void setPhone(int phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
}
