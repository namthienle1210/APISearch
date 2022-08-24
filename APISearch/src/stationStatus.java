
public class stationStatus {
	private String ServiceKey
	private String pageNo
	private String numOfRows
	private int period
	private int zcode
	public stationStatus(String serviceKey, String pageNo, String numOfRows, int period, int zcode) {
		ServiceKey = serviceKey;
		this.pageNo = pageNo;
		this.numOfRows = numOfRows;
		this.period = period;
		this.zcode = zcode;
	}
	public String getServiceKey() {
		return ServiceKey;
	}
	public void setServiceKey(String serviceKey) {
		ServiceKey = serviceKey;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(String numOfRows) {
		this.numOfRows = numOfRows;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getZcode() {
		return zcode;
	}
	public void setZcode(int zcode) {
		this.zcode = zcode;
	}
	
}
