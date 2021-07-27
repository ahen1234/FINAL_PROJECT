package com.kh.finalproject.vo;

public class BoardVO {
	private String BOARD_TYPE;
	private String ID;
	private String NICKNAME;
	private String TITLE;
	private String CONTENTS;
	private int VIEWS_CUT;
	private int RECOMMEND_CUT;
	private int REPORT;
	private String REPORTING_DATE;
	public String getBOARD_TYPE() {
		return BOARD_TYPE;
	}
	public void setBOARD_TYPE(String bOARD_TYPE) {
		BOARD_TYPE = bOARD_TYPE;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNICKNAME() {
		return NICKNAME;
	}
	public void setNICKNAME(String nICKNAME) {
		NICKNAME = nICKNAME;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getCONTENTS() {
		return CONTENTS;
	}
	public void setCONTENTS(String cONTENTS) {
		CONTENTS = cONTENTS;
	}
	public int getVIEWS_CUT() {
		return VIEWS_CUT;
	}
	public void setVIEWS_CUT(int vIEWS_CUT) {
		VIEWS_CUT = vIEWS_CUT;
	}
	public int getRECOMMEND_CUT() {
		return RECOMMEND_CUT;
	}
	public void setRECOMMEND_CUT(int rECOMMEND_CUT) {
		RECOMMEND_CUT = rECOMMEND_CUT;
	}
	public int getREPORT() {
		return REPORT;
	}
	public void setREPORT(int rEPORT) {
		REPORT = rEPORT;
	}
	public String getREPORTING_DATE() {
		return REPORTING_DATE;
	}
	public void setREPORTING_DATE(String rEPORTING_DATE) {
		REPORTING_DATE = rEPORTING_DATE;
	}
	
}
