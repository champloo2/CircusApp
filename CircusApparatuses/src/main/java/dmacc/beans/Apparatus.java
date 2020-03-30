package dmacc.beans;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

//import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Apparatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nameOfApparatus;
	private String level;
	
	//@Autowired  //do i need this?
	//got this solution from 
	//http://www.myjavablog.com/2019/01/01/one-to-many-relationship-with-spring-boot-spring-data-jpa-h2-database/
	//@OneToMany (mappedBy = "apparatus")//should this actually be OneToMany?
	//should this be a list or?
	//private List<Maneuver> maneuverList;

}
