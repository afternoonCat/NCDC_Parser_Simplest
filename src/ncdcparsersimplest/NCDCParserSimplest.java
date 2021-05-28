package ncdcparsersimplest;

import org.apache.hadoop.io.Text;

/**
 * 
 *   This simplest NCDC record parser is based on Federal 
 * Climate Complex Data Documentation for Integrated Surface 
 * Data (ISD) released on January 12, 2018.
 * 
 *   The purpose of this parser is to parse an ISD record and 
 * get the control and mandatory data as strings. 
 *   All additional ISD data (if any) is currently returned 
 * as a string due to a great number of the properties and 
 * getters and setters to be additionally coded.
 * 
 * @author BusyBee
 *
 */

public class NCDCParserSimplest {
	
	private final int iMaxRecordLength = 105;
	
/* 
 * ==========================
 * 
 *    CONTROL DATA SECTION
 *
 * --------------------------	
 */

	// 1
	private String sTotalVariableChars; // POS: 1-4
	/*
	 * TOTAL-VARIABLE-CHARACTERS (this includes remarks, additional data, and element quality section)
	 */
	
	// 2
	private String sUSAFMasterStationCatId; // POS: 5-10
	/*
	 * FIXED-WEATHER-STATION USAF MASTER STATION CATALOG identifier
	 */
	
	// 3
	private String sNCEIWbanId; // POS: 11-15
	/*
	 * FIXED-WEATHER-STATION NCEI WBAN identifier
	 */

	
	/* -------------------------------------
	 *
	 *    GEOPHYSICAL POINT OBSERVATION
	 *   
	 * -------------------------------------
	 */
	
	
	// 4
	private String sObservationDate; // POS: 16-23
	/*
	 * GEOPHYSICAL-POINT-OBSERVATION date
	 */
	
	
	// 5
	private String sObservationTime; // POS: 24-27
	/*
	 * GEOPHYSICAL-POINT-OBSERVATION time 
	 */
	
	
	// 6
	private String sDataSourceFlag; // POS: 28-28
	/*
	 * GEOPHYSICAL-POINT-OBSERVATION data source flag
	 */
	
	
	// 7
	private String sLatitudeCoord; //  POS: 29-34
	/*
	 * GEOPHYSICAL-POINT-OBSERVATION latitude coordinate
	 */
	
	
	// 8
	private String sLongitudeCoord; //	POS: 35-41
	/*
	 * GEOPHYSICAL-POINT-OBSERVATION longitude coordinate
	 */
	
	
	// 9 
	private String sReportTypeCode; //	POS: 42-46 
	/*
	 * GEOPHYSICAL-REPORT-TYPE code
	 */
	
	// 10
	private String sElevationDimention; //	POS: 47-51
	/*
	GEOPHYSICAL-POINT-OBSERVATION elevation dimension
	*/
	
		
	// 11
	private String sCallLetterId; //	POS: 52-56
	/*
	FIXED-WEATHER-STATION call letter identifier
	*/
	
	
	// 12
	private String sQualityControlProcessName; //	POS: 57-60
	/*
	METEOROLOGICAL-POINT-OBSERVATION quality control process name
	*/
	

/* 
 * ==========================
 * 
 *   MANDATORY DATA SECTION
 *
 * --------------------------	
 */
	

	/* -----------------------
	 *
	 *    WIND OBSERVATION
	 *   
	 * -----------------------
	 */

	
	// 13
	private String sWindDirectionAngle; //	POS: 61-63
	/*
	WIND-OBSERVATION direction angle
	*/
	
	
	// 14
	private String sWindDirectionQualityCode; // 	POS: 64-64
	/*
	WIND-OBSERVATION direction quality code
	*/
	
	
	// 15
	private String sWindTypeCode; // 	POS: 65-65
	/*
	WIND-OBSERVATION type code
	*/
	
	
	// 16
	private String sWindSpeedRate; // 	POS: 66-69
	/*
	WIND-OBSERVATION speed rate
	*/
	
	
	// 17
	private String sWindSpeedQualityCode; // 	POS: 70-70
	/*
	WIND-OBSERVATION speed quality code
	*/
	

	/* -------------------------------
	 *
	 *    SKY CONDITION OBSERVATION
	 *   
	 * -------------------------------
	 */
	
	// 18
	private String sSkyCeilingHeightDimention; //  POS: 71-75
	/*
	SKY-CONDITION-OBSERVATION ceiling height dimension
	*/
	
	
	
	// 19
	private String sSkyCeilingQualityCode; //   POS: 76-76
	/*
	SKY-CONDTION-OBSERVATION ceiling quality code
	*/
	
	
	// 20
	private String sSkyCeilingDeterminationCode; //	POS: 77-77
	/*
	SKY-CONDITION-OBSERVATION ceiling determination code
	*/
	
	
	// 21
	private String sSkyCAVOKCode; //	POS: 78-78
	/*
	SKY-CONDITION-OBSERVATION CAVOK code
	*/
	

	/* -----------------------------
	 *
	 *    VISIBILITY OBSERVATION
	 *   
	 * -----------------------------
	 */
	
	// 22
	private String sVisibilityDistanceDimension; // 	POS: 79-84
	/*
	VISIBILITY-OBSERVATION distance dimension
	*/
	
	
	
	// 23
	private String sVisibilityDistanceQualityCode; //	POS: 85-85
	/*
	VISIBILITY-OBSERVATION distance quality code
	*/
	
	
	// 24
	private String sVisibilityVariabilityCode; // 	POS: 86-86
	/*
	VISIBILITY-OBSERVATION variability code
	*/
	
	
	// 25
	private String sVisibilityQualityVariablityCode; //	POS: 87-87
	/*
	VISIBILITY-OBSERVATION quality variability code
	*/
	
	
	
	/* ----------------------------------
	 *
	 *    AIR TEMPERATURE OBSERVATION
	 *   
	 * ---------------------------------
	 */
	
	
	// 26
	private String sAirTemperature; //	POS: 88-92
	/*
	AIR-TEMPERATURE-OBSERVATION air temperature
	*/
	
	
	// 27 
	private String sAirTemperatureQualityCode; // 	POS: 93-93
	/*
	AIR-TEMPERATURE-OBSERVATION air temperature quality code
	*/
	
	
	// 28
	private String sDewPointTemperature; //	POS: 94-98
	/*
	AIR-TEMPERATURE-OBSERVATION dew point temperature
	*/
	
	
	// 29
	private String sDewPointQualityCode; //	POS: 99-99
	/*
	AIR-TEMPERATURE-OBSERVATION dew point quality code
	*/
	
	/* ----------------------------------
	 *
	 *  ATMOSPHERIC PRESSURE OBSERVATION
	 *   
	 * ---------------------------------
	 */
	
	// 30
	private String sSeaLevelPressure; // 	POS: 100-104
	/*
	ATMOSPHERIC-PRESSURE-OBSERVATION sea level pressure
	*/
	
	
	// 31
	private String sSeaLevelPressureQualityCode; //	POS: 105-105
	/*
	ATMOSPHERIC-PRESSURE-OBSERVATION sea level pressure quality code
	*/


/* 
 * ==========================
 * 
 *  ADDITIONAL DATA SECTION
 *
 * --------------------------	
 */

	// 32
	private String sAdditionalData; // everything that goes after pos 105.
	/*
	 * Additional data
	 */


	/*
	 * =======================
	 * ///////////////////////
	 * 
	 *   GETTERS AND SETTERS
	 *  
	 * ///////////////////////
	 */
	
	/*
	 * ==================================
	 *  Control data getters and setters
	 * ---------------------------------- 
	 */
	
	// 1
	/*
	POS: 1-4
	TOTAL-VARIABLE-CHARACTERS
	*/
	public void setTotalVariableChars(String data) {		
		this.sTotalVariableChars = data;
	}

	public String getTotalVariableChars() {
		return sTotalVariableChars;
	}


	// 2
	/*
	POS: 5-10
	FIXED-WEATHER-STATION USAF MASTER STATION CATALOG identifier
	*/
	public void setFixedWeatherStation_USAFMasterStationCatId(String data) {
		this.sUSAFMasterStationCatId = data;
	}
	
	
	public String getFixedWeatherStation_USAFMasterStationCatId() {
		return sUSAFMasterStationCatId;
	}


	// 3
	/*
	POS: 11-15
	FIXED-WEATHER-STATION NCEI WBAN identifier
	*/
	public void setFixedWeatherStation_NCEIWbanId(String data) {
		this.sNCEIWbanId = data;
	}

	public String getFixedWeatherStation_NCEIWbanId() {
		return sNCEIWbanId;
	}



	// 4
	/*
	POS: 16-23
	GEOPHYSICAL-POINT-OBSERVATION date
	*/
	public void setGeophysicalPointObservation_Date(String data) {
		this.sObservationDate = data;
	}

	public String getGeophysicalPointObservation_Date() {
		return sObservationDate;
	}

	

	// 5
	/*
	POS: 24-27
	GEOPHYSICAL-POINT-OBSERVATION time
	*/
	public void setGeophysicalPointObservation_Time(String data) {
		this.sObservationTime = data;
	}

	public String getGeophysicalPointObservation_Time() {
		return sObservationTime;
	}



	// 6
	/*
	POS: 28-28
	GEOPHYSICAL-POINT-OBSERVATION data source flag
	*/
	public void setGeophysicalPointObservation_DataSourceFlag(String dataSourceFlag) {
		this.sDataSourceFlag = dataSourceFlag;
	}
	
	public String getGeophysicalPointObservation_DataSourceFlag() {
		return sDataSourceFlag;
	}




	// 7
	/*
	POS: 29-34
	GEOPHYSICAL-POINT-OBSERVATION latitude coordinate
	*/
	public void setGeophysicalPointObservation_LatitudeCoord(String latitudeCoord) {
		this.sLatitudeCoord = latitudeCoord;
	}
	
	public String getGeophysicalPointObservation_LatitudeCoord() {
		return sLatitudeCoord;
	}



	// 8
	/*
	POS: 35-41
	GEOPHYSICAL-POINT-OBSERVATION longitude coordinate
	*/
	public void setGeophysicalPointObservation_LongitudeCoord(String longitudeCoord) {
		this.sLongitudeCoord = longitudeCoord;
	}

	public String getGeophysicalPointObservation_LongitudeCoord() {
		return sLongitudeCoord;
	}



	// 9
	/*
	POS: 42-46
	GEOPHYSICAL-REPORT-TYPE code
	*/
	public void setGeophysicalReportType_Code(String code) {
		this.sReportTypeCode = code;
	}
	
	public String getGeophysicalReportType_Code() {
		return sReportTypeCode;
	}



	// 10
	/*
	POS: 47-51
	GEOPHYSICAL-POINT-OBSERVATION elevation dimension
	*/
	
	public void setGeophysicalPointObservation_ElevationDimention(String elevationDimention) {
		this.sElevationDimention = elevationDimention;
	}
	
	public String getGeophysicalPointObservation_ElevationDimention() {
		return sElevationDimention;
	}




	// 11
	/*
	POS: 52-56
	FIXED-WEATHER-STATION call letter identifier
	*/

	public void setFixedWeatherStation_CallLetterId(String callLetterId) {
		this.sCallLetterId = callLetterId;
	}
	
	public String getFixedWeatherStation_CallLetterId() {
		return sCallLetterId;
	}



	
	// 12
	/*
	POS: 57-60
	METEOROLOGICAL-POINT-OBSERVATION quality control process name
	*/
	
	public void setMeteorogicalPointObservation_QualityControlProcessName(String qualityControlProcessName) {
		this.sQualityControlProcessName = qualityControlProcessName;
	}
	
	public String getMeteorogicalPointObservation_QualityControlProcessName() {
		return sQualityControlProcessName;
	}




	/*
	 * ===================================
	 *    Mandatory getters and setters
	 * -----------------------------------
	 */
	
	// 13
	/*
	POS: 61-63
	WIND-OBSERVATION direction angle
	 */
	public void setWindObservation_DirectionAngle(String directionAngle) {
		this.sWindDirectionAngle = directionAngle;
	}

	public String getWindObservation_DirectionAngle() {
		return sWindDirectionAngle;
	}




	// 14
	/*
	POS: 64-64
	WIND-OBSERVATION direction quality code
	 */
	
	public void setWindObservation_DirectionQualityCode(String directionQualityCode) {
		this.sWindDirectionQualityCode = directionQualityCode;
	}
	
	public String getWindObservation_DirectionQualityCode() {
		return sWindDirectionQualityCode;
	}



	// 15
	/*
	65-65
	WIND-OBSERVATION type code
	 */
	
	public void setWindObservation_TypeCode(String typeCode) {
		this.sWindTypeCode = typeCode;
	}

	public String getWindObservation_TypeCode() {
		return sWindTypeCode;
	}



	// 16
	/*	 
	POS: 66-69
	WIND-OBSERVATION speed rate
	 */
	
	public void setWindObservation_SpeedRate(String speedRate) {
		this.sWindSpeedRate = speedRate;
	}
	
	public String getWindObservation_SpeedRate() {
		return sWindSpeedRate;
	}




	// 17
	/*
	POS: 70-70
	WIND-OBSERVATION speed quality code
	 */
	
	public void setWindObservation_SpeedQualityCode(String speedQualityCode) {
		this.sWindSpeedQualityCode = speedQualityCode;
	}

	public String getWindObservation_SpeedQualityCode() {
		return sWindSpeedQualityCode;
	}




	// 18
	/*
	POS: 71-75
	SKY-CONDITION-OBSERVATION ceiling height dimension
	*/
	
	public void setSkyConditionObservation_CeilingHeightDimention(String ceilingHeightDimention) {
		this.sSkyCeilingHeightDimention = ceilingHeightDimention;
	}
	
	public String getSkyConditionObservation_CeilingHeightDimention() {
		return sSkyCeilingHeightDimention;
	}



	// 19
	/*
	POS: 76-76
	SKY-CONDTION-OBSERVATION ceiling quality code
	*/

	public void setSkyConditionObservation_CeilingQualityCode(String ceilingQualityCode) {
		this.sSkyCeilingQualityCode = ceilingQualityCode;
	}

	public String getSkyConditionObservation_CeilingQualityCode() {
		return sSkyCeilingQualityCode;
	}



	// 20
	/*
	POS: 77-77
	SKY-CONDITION-OBSERVATION ceiling determination code
	*/
	
	public void setSkyConditionObservation_CeilingDeterminationCode(String ceilingDeterminationCode) {
		this.sSkyCeilingDeterminationCode = ceilingDeterminationCode;
	}
	
	public String getSkyConditionObservation_CeilingDeterminationCode() {
		return sSkyCeilingDeterminationCode;
	}



	// 21
	/*
	POS: 78-78
	SKY-CONDITION-OBSERVATION CAVOK code
	*/

	public void setSkyConditionObservation_CavokCode(String cavokCode) {
		this.sSkyCAVOKCode = cavokCode;
	}

	public String getSkyConditionObservation_CavokCode() {
		return sSkyCAVOKCode;
	}




	// 22
	/*
	POS: 79-84
	VISIBILITY-OBSERVATION distance dimension
	*/
	
	public void setVisibilityObservation_DistanceDimension(String distanceDimension) {
		this.sVisibilityDistanceDimension = distanceDimension;
	}
	
	public String getVisibilityObservation_DistanceDimension() {
		return sVisibilityDistanceDimension;
	}




	// 23
	/*
	POS: 85-85
	VISIBILITY-OBSERVATION distance quality code
	*/
	
	public void setVisibilityObservation_DistanceQualityCode(String distanceQualityCode) {
		this.sVisibilityDistanceQualityCode = distanceQualityCode;
	}
	
	public String getVisibilityObservation_DistanceQualityCode() {
		return sVisibilityDistanceQualityCode;
	}




	// 24
	/*
	POS: 86-86
	VISIBILITY-OBSERVATION variability code
	*/

	public void setVisibilityObservation_VariabilityCode(String visibilityVariabilityCode) {
		this.sVisibilityVariabilityCode = visibilityVariabilityCode;
	}

	public String getVisibilityObservation_VariabilityCode() {
		return sVisibilityVariabilityCode;
	}




	// 25
	/*
	POS: 87-87
	VISIBILITY-OBSERVATION quality variability code
	*/
	
	public void setVisibilityObservation_QualityVariablityCode(String qualityVariablityCode) {
		this.sVisibilityQualityVariablityCode = qualityVariablityCode;
	}
	
	
	public String getVisibilityObservation_QualityVariablityCode() {
		return sVisibilityQualityVariablityCode;
	}




	// 26
	/*
	POS: 88-92
	AIR-TEMPERATURE-OBSERVATION air temperature
	*/

	public void setAirTemperatureObservation_AirTemperature(String airTemperature) {
		this.sAirTemperature = airTemperature;
	}

	public String getAirTemperatureObservation_AirTemperature() {
		return sAirTemperature;
	}




	// 27
	/*
	POS: 93-93
	AIR-TEMPERATURE-OBSERVATION air temperature quality code
	*/

	public void setAirTemperatureObservation_AirTemperatureQualityCode(String airTemperatureQualityCode) {
		this.sAirTemperatureQualityCode = airTemperatureQualityCode;
	}

	public String getAirTemperatureObservation_AirTemperatureQualityCode() {
		return sAirTemperatureQualityCode;
	}




	// 28
	/*
	POS: 94-98
	AIR-TEMPERATURE-OBSERVATION dew point temperature
	*/

	public void setAirTemperatureObservation_DewPointTemperature(String dewPointTemperature) {
		this.sDewPointTemperature = dewPointTemperature;
	}

	public String getAirTemperatureObservation_DewPointTemperature() {
		return sDewPointTemperature;
	}




	// 29
	/*
	POS: 99-99
	AIR-TEMPERATURE-OBSERVATION dew point quality code
	*/

	public void setAirTemperatureObservation_DewPointQualityCode(String dewPointQualityCode) {
		this.sDewPointQualityCode = dewPointQualityCode;
	}

	public String getAirTemperatureObservation_DewPointQualityCode() {
		return sDewPointQualityCode;
	}




	// 30
	/*
	POS: 100-104
	ATMOSPHERIC-PRESSURE-OBSERVATION sea level pressure
	*/
	
	public void setAtmosphericPressueObservation_SeaLevelPressure(String seaLevelPressure) {
		this.sSeaLevelPressure = seaLevelPressure;
	}
	
	public String getAtmosphericPressueObservation_SeaLevelPressure() {
		return sSeaLevelPressure;
	}




	// 31
	/*
	POS: 105-105
	ATMOSPHERIC-PRESSURE-OBSERVATION sea level pressure quality code
	*/

	public void setAtmosphericPressueObservation_SeaLevelPressureQualityCode(String seaLevelPressureQualityCode) {
		this.sSeaLevelPressureQualityCode = seaLevelPressureQualityCode;
	}

	public String getAtmosphericPressueObservation_SeaLevelPressureQualityCode() {
		return sSeaLevelPressureQualityCode;
	}


	
	/*
	 *  Additional data getters and setters
	 *               TBD
	 */
	
	// 32
	public void setAdditionalData(String additionalData) {
			this.sAdditionalData = additionalData;
	}

	
	public String getAdditionalData() {
		return sAdditionalData;
	}


	/*
	 * ==========
	 *  
	 *   Parser
	 *   
	 * ---------- 
	 */
	
	/**
	 * 
	 * IMPORTANT:   Checking out if the record's length 
	 *            is less than the length of the control 
	 *            and mandatory data must be done before 
	 *            calling this parser.                         
	 *            
	 *            Notes: 
	 *              According to Federal Climate Complex 
	 *            Data Documentation for ISD, both 
	 *            the control and mandatory data consist 
	 *            of 105 characters.
	 *                  
	 *              Maximum record size: 2,844 characters
	 *            
	 * @param record
	 */
	public void parse( Text record) {
		parse(record.toString());
	}
	// ^^ parse(Text)
	

	/**
	 * 
	 * IMPORTANT: Checking out if the record's length is
	 *            less than the length of the control and 
	 *            mandatory data must be done before 
	 *            calling this parser.

	 *            Notes:            
	 *              According to Federal Climate Complex 
	 *            Data Documentation for ISD, both 
	 *            the control and mandatory data consist 
	 *            of 105 characters.
	 *                  
	 *              Maximum record size: 2,844 characters
	 *            
	 * @param record
	 */
	public void parse(String record) {		
		
		final int iRecordLength = record.length();
		// --------------
		//  CONTROL DATA
		// --------------
		
		// 1 pos: 1-4
		setTotalVariableChars(record.substring(0, 4));
		
		// 2 pos: 5-10
		setFixedWeatherStation_USAFMasterStationCatId(record.substring(4, 10));
		
		// 3 pos: 11-15
		setFixedWeatherStation_NCEIWbanId(record.substring(10, 15));
		
		// 4 pos: 16-23
		setGeophysicalPointObservation_Date(record.substring(15, 23));
		
		// 5 pos: 24-27
		setGeophysicalPointObservation_Time(record.substring(23, 27));
		
		// 6 pos: 28-28
		setGeophysicalPointObservation_DataSourceFlag(record.substring(27, 28));
		
		// 7 pos: 29-34
		setGeophysicalPointObservation_LatitudeCoord(record.substring(28, 34));
		
		// 8 pos: 35-41
		setGeophysicalPointObservation_LongitudeCoord(record.substring(34, 41));
		
		// 9 pos: 42-46
		setGeophysicalReportType_Code(record.substring(41, 46));
		
		// 10 pos: 47-51
		setGeophysicalPointObservation_ElevationDimention(record.substring(46, 51));		
		
		// 11 pos: 52-56
		setFixedWeatherStation_CallLetterId(record.substring(51, 56));		
		
		// 12 pos: 57-60
		setMeteorogicalPointObservation_QualityControlProcessName(record.substring(56, 60));
		
		// ----------------
		//  MANDATORY DATA
		// ----------------
		
		// 13 pos: 61-63
		setWindObservation_DirectionAngle(record.substring(60, 63));
		
		// 14 pos: 64-64
		setWindObservation_DirectionQualityCode(record.substring(63, 64));
				
		// 15 pos: 65-65
		setWindObservation_TypeCode(record.substring(64, 65));
		
		// 16 pos: 66-69
		setWindObservation_SpeedRate(record.substring(65, 69));
		
		// 17 pos: 70-70
		setWindObservation_SpeedQualityCode(record.substring(69, 70));
		
		// 18 pos: 71-75
		setSkyConditionObservation_CeilingHeightDimention(record.substring(70, 75));
		
		// 19 pos: 76-76
		setSkyConditionObservation_CeilingQualityCode(record.substring(75, 76));
		
		// 20 pos: 77-77
		setSkyConditionObservation_CeilingDeterminationCode(record.substring(76, 77));
		
		// 21 pos: 78-78
		setSkyConditionObservation_CavokCode(record.substring(77, 78));
		
		// 22 pos: 79-84
		setVisibilityObservation_DistanceDimension(record.substring(78, 84));
		
		// 23 pos: 85-85
		setVisibilityObservation_DistanceQualityCode(record.substring(84, 85));
		
		// 24 pos: 86-86
		setVisibilityObservation_VariabilityCode(record.substring(85, 86));
		
		// 25 pos: 87-87
		setVisibilityObservation_QualityVariablityCode(record.substring(86, 87));
		
		// 26 pos: 88-92
		setAirTemperatureObservation_AirTemperature(record.substring(87, 92));
		
		// 27 pos: 93-93
		setAirTemperatureObservation_AirTemperatureQualityCode(record.substring(92, 93));
		
		// 28 pos: 94-98
		setAirTemperatureObservation_DewPointTemperature(record.substring(93, 98));
		
		// 29 pos: 99-99
		setAirTemperatureObservation_DewPointQualityCode(record.substring(98, 99));
		
		// 30 pos: 100-104
		setAtmosphericPressueObservation_SeaLevelPressure(record.substring(99, 104));
		
		// 31 pos: 105-105
		if( iRecordLength > iMaxRecordLength ) {
			setAtmosphericPressueObservation_SeaLevelPressureQualityCode(record.substring(104, 105));
		} else {
			setAtmosphericPressueObservation_SeaLevelPressureQualityCode(record.substring(104));			
		}
		
		// -----------------
		//  ADDITIONAL DATA
		// -----------------
		
		// 32 pos: 106+		
		if( iRecordLength > iMaxRecordLength ) {
			setAdditionalData(record.substring(105));			
		} else {
			// there is no additional data in the record. 
			setAdditionalData("");
		}
		
	}
	// ^^ parse(string)
	
	
}
// ^^ class NCDCParserSimplest


////////////////////////
//
//    END OF FILE
//
////////////////////
