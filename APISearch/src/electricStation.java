
// Electric station information including 
// central, office, name of station, station ID, 
// charger capacity, charger name, charger type and charge method
import java.util.List;
public class electricStation {
	private String central
	private String office
	private String stationName
	private float iD
	private float chargeCap
	private String charger
	private String type
	private String method
	public Elec_station(String central, String office, String stationName, float iD, float chargeCap, String charger,
			String type, String method) {
		this.central = central;
		this.office = office;
		this.stationName = stationName;
		this.iD = iD;
		this.chargeCap = chargeCap;
		this.charger = charger;
		this.type = type;
		this.method = method;
	}
	public String getCentral() {
		return central;
	}
	public void setCentral(String central) {
		this.central = central;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public float getID() {
		return ID;
	}
	public void setID(float iD) {
		ID = iD;
	}
	public float getChargeCap() {
		return chargeCap;
	}
	public void setChargeCap(float chargeCap) {
		this.chargeCap = chargeCap;
	}
	public String getCharger() {
		return charger;
	}
	public void setCharger(String charger) {
		this.charger = charger;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
}
