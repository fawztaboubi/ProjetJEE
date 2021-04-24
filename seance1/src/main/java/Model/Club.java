package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="Club")
public class Club {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true, length=11)
	public int Id;
	
	@Column(name="Name",nullable=false, unique=true, length=20)
	public String Name;
	
	@Column(name="Domaine",nullable=false, unique=true, length=20)
	public String Domaine;

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
