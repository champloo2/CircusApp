package dmacc.attribute;

import java.util.List;

import dmacc.beans.Maneuver;

public class ManeuverAttribute {
	
	private long appID;
	private List <Maneuver> maneuverList;
	
	public ManeuverAttribute(long appID, List<Maneuver> maneuverList) {
		super();
		this.appID = appID;
		this.maneuverList = maneuverList;
	}

	public long getAppID() {
		return appID;
	}

	public void setAppID(long appID) {
		this.appID = appID;
	}

	public List<Maneuver> getManeuverList() {
		return maneuverList;
	}

	public void setManeuverList(List<Maneuver> maneuverList) {
		this.maneuverList = maneuverList;
	}
	
	
	
	
	
	

}
