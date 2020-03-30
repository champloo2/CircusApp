package dmacc.beans;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Apparatus {
	
	private long id;
	private String nameOfApparatus;
	private String level;
	private List<Maneuver> maneuverList;

}
