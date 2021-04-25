package Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Club")
public class Club {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public int Id;
	
	@Column(name="Name",nullable=false, unique=true, length=20)
	public String Name;
	
	@Column(name="Domaine",nullable=false, unique=true, length=20)
	public String Domaine;
	
	 @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<Membre> membres;
	 
	public List<Membre> getMembres() {
		return membres;
	}

	public void setMembres(List<Membre> membres) {
		this.membres = membres;
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

	public String getDomaine() {
		return Domaine;
	}

	public void setDomaine(String domaine) {
		Domaine = domaine;
	}

	public Club() {
		super();
	}

	
}
