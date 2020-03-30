package dmacc.beans;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Maneuver {
	
	private long id;
	private String maneuverName;
	private Apparatus apparatus;

}
