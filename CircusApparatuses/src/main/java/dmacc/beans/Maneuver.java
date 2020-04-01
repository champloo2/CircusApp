package dmacc.beans;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Embeddable  //do I need this? 
@Entity
public class Maneuver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String maneuverName;
	private String maneuverConfidence;
	
	@ManyToOne (cascade= {CascadeType.REFRESH} ,fetch = FetchType.LAZY)
	// do i need this? @JoinColumn(name="spider_ID",referencedColumnName="ID")
	private Apparatus apparatus;
	
	
	
	public Maneuver (Apparatus app)
	{
		this.apparatus = app;
	}
	
	
	
	
	

}
