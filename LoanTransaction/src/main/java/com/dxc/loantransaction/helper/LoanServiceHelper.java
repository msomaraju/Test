package com.dxc.loantransaction.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import com.dxc.loantransaction.constants.LoanConstants;
import com.dxc.loantransaction.request.IndexedData;
import com.dxc.loantransaction.request.TranDetails;
import com.dxc.loantransaction.request.WMAData;


public class LoanServiceHelper {

	private final static Logger log=Logger.getLogger(LoanServiceHelper.class.getName());
	

	public Properties getConfigProp() throws IOException{
		Properties Config_properties = new Properties();
		InputStream fileInput=this.getClass().getResourceAsStream("/config.properties");
		Config_properties.load(fileInput);
		return Config_properties;
	}

	public Properties getProp() {
		log.info("Loantransaction Service Properties loaded starting...");
		Properties Service_properties=new Properties();
		try {
			FileInputStream Service_InputStream = new FileInputStream(new File(getConfigProp().getProperty("Service_Properties_Location")));
			log.info("Loantransaction Service Properties loaded from file ::"+getConfigProp().getProperty("Service_Properties_Location"));
			Service_properties.load(Service_InputStream);
		} catch (IOException e) {
			log.error("Error occured while retreiving a Config Property value");
			e.printStackTrace();
		}
		return Service_properties;
	}
	
	public String getTimeStamp(){
		log.info("Getting TimeStamp ::");
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		log.info("Time Stamp :: "+formatter.format(new Date()));
		return formatter.format(new Date());	
	}
	public boolean createTxtFile(WMAData wdata) {
		log.info("createTxtFile starting...");
		Properties Service_properties=getProp();
		HashMap<String,String> wmaDataMap=getWMAdataMap(wdata);
		String txt_file_Path;
		Iterator<String> wmaDataKeys= wmaDataMap.keySet().iterator();
		FileWriter writer;
		BufferedWriter bwriter;
		

		try {
			txt_file_Path=Service_properties.getProperty("Text_File_Path")+getTimeStamp()+".txt";
			log.info("AbsolutePath of the loan txt file to be created:  "+txt_file_Path);
			File f=new File(txt_file_Path);
			writer=new FileWriter(f);
			bwriter=new BufferedWriter(writer);
			String key;
			while(wmaDataKeys.hasNext()){
				key=wmaDataKeys.next();		
				bwriter.write(String.format("%20s \t %20s \r\n",key.toUpperCase(),wmaDataMap.get(key)));
				bwriter.newLine();
				bwriter.newLine();
			}
			bwriter.flush();
			bwriter.close();
			this.setText_file_path(f.getAbsolutePath());

		} catch (FileNotFoundException e) {
			log.error("contains file not found exception ::"+e.getMessage());
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			log.error("contains IO exception ::"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		log.info("cretaeTextFile ending.");
		return true;
	}
	public boolean createXmlFile(IndexedData data,String text_file_path) {
		log.info("createXmlFile starting...");
		String xml_file_path;
		Properties prop;
		try{
			prop = getProp();
			Document outdoc=DocumentHelper.createDocument();
			Element awd=outdoc.addElement("AWDRIP");
			Element tr=awd.addElement("Transaction");
			tr.addElement("field").addAttribute("name", LoanConstants.IDX_POL_NUMBER).addAttribute("value", data.getPolNumber());
			tr.addElement("field").addAttribute("name", LoanConstants.IDX_FIRST_NAME).addAttribute("value", data.getFirstName());
			tr.addElement("field").addAttribute("name", LoanConstants.IDX_LAST_NAME).addAttribute("value", data.getLastName());
			tr.addElement("field").addAttribute("name", LoanConstants.IDX_GOVT_ID).addAttribute("value", data.getGovtID());
			tr.addElement("field").addAttribute("name", LoanConstants.IDX_TRANS_SUB_TYPE).addAttribute("value", data.getTransSubType());
			tr.addElement("field").addAttribute("name", LoanConstants.IDX_LINE_OF_BUSINESS).addAttribute("value", data.getLineOfBusiness());
			tr.addElement("field").addAttribute("name", LoanConstants.IDX_PRODUCT_CODE).addAttribute("value", data.getProductCode());
			tr.addElement("field").addAttribute("name",LoanConstants.UNIT).addAttribute("value",prop.getProperty("UNIT"));
			tr.addElement("field").addAttribute("name",LoanConstants.WRKT).addAttribute("value",prop.getProperty("WRKT"));
			tr.addElement("field").addAttribute("name",LoanConstants.STAT).addAttribute("value",prop.getProperty("STAT"));

			Element src=tr.addElement("source");

			src.addElement("field").addAttribute("name",LoanConstants.UNIT).addAttribute("value",prop.getProperty("UNIT"));
			src.addElement("field").addAttribute("name",LoanConstants.WRKT).addAttribute("value",prop.getProperty("WRKT"));
			src.addElement("field").addAttribute("name",LoanConstants.STAT).addAttribute("value",prop.getProperty("STAT"));
			src.addElement("field").addAttribute("name",LoanConstants.OBJT).addAttribute("value", prop.getProperty("OBJT"));

			src.addElement("path").addAttribute("name",this.getText_file_path());

			xml_file_path=prop.getProperty("AWDRIP_XML_Path")+getTimeStamp()+".xml";
			log.info("AbsolutePath of the loan xml to be created:  "+xml_file_path);
			FileOutputStream o=new FileOutputStream(new File(xml_file_path));
			OutputFormat form=OutputFormat.createPrettyPrint();
			XMLWriter writer=new XMLWriter(o,form);
			writer.write(outdoc);
			writer.flush();
			writer.close();
			o.close();
		} catch (FileNotFoundException e) {
			log.error("contains file not found exception ::"+e.getMessage());
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			log.error("contains IO exception ::"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		log.info("createXmlFile ending.");
		return true;
	}

	public boolean indexedDataContainsNull(IndexedData indexedData){

		String polNumber = indexedData.getPolNumber();
		String firstName = indexedData.getFirstName();
		String lastName = indexedData.getLastName();
		String govtId = indexedData.getGovtID();
		String lineOfBusiness = indexedData.getLineOfBusiness();
		String transSubType = indexedData.getTransSubType();
		String productCode = indexedData.getProductCode();

		if (polNumber == null || polNumber.isEmpty()
				|| firstName == null || firstName.isEmpty()
				|| lastName == null || lastName.isEmpty()
				|| govtId == null || govtId.isEmpty()
				|| lineOfBusiness == null || lineOfBusiness.isEmpty()
				|| transSubType == null || transSubType.isEmpty()
				|| productCode == null || productCode.isEmpty()){
			return true;
		}
		return false;
	}
	
	public boolean wmaDataContainsNull(WMAData wmaData){

		String wmaPolNumber = wmaData.getPolNumber();
		String wmaTransType=wmaData.getTransType();
		String wmaFinActivityNetAmt=wmaData.getFinActivityNetAmt();
		String wmaTransExeDate=wmaData.getTransExeDate();
		String wmaTransExeTime=wmaData.getTransExeTime();
		String wmaPaymtForm=wmaData.getPaymentForm();
		String wmaFullName=wmaData.getFullName();
		String  wmaAddressTypeCode=wmaData.getAddressTypeCode();
		String wmaLine1=wmaData.getLine1();
		String wmaLine2=wmaData.getLine2();
		String wmaLine3=wmaFullName=wmaData.getLine3();
		String wmaNoOfPrems= wmaData.getNoOfPrems();
		String wmaPaymentForm=wmaData.getPaymentForm();
		String wmaRACFId=wmaData.getRACFId();
		String wmaTaxWithholdingType=wmaData.getTaxWithholdingType();
		String wmaTransEffDate=wmaData.getTransEffDate();

		if (wmaPolNumber == null || wmaPolNumber.isEmpty()
				|| wmaFullName == null || wmaFullName.isEmpty()
				|| wmaTransType == null || wmaTransType.isEmpty()
				|| wmaTransType == null || wmaTransType.isEmpty()
				|| wmaPaymtForm == null || wmaPaymtForm.isEmpty()
				|| wmaTransExeDate == null || wmaTransExeDate.isEmpty()
				|| wmaTransExeTime == null || wmaTransExeTime.isEmpty()
				|| wmaAddressTypeCode == null || wmaAddressTypeCode.isEmpty()
				|| wmaLine1 == null || wmaTransExeDate.isEmpty()
				|| wmaLine2 == null || wmaTransExeTime.isEmpty()
				|| wmaLine3 == null || wmaTransExeTime.isEmpty()
				|| wmaNoOfPrems == null || wmaNoOfPrems.isEmpty()
				|| wmaPaymentForm == null || wmaPaymentForm.isEmpty()
				|| wmaRACFId == null || wmaRACFId.isEmpty()
				|| wmaTaxWithholdingType == null || wmaTaxWithholdingType.isEmpty()
				|| wmaTransEffDate == null || wmaTransEffDate.isEmpty()){
			return true;
		}
		return false;
	}

	public boolean transDetailsContainsNull(TranDetails tranDetails){

		String transExeDate = tranDetails.getTransExeDate();
		String transRefGUID = tranDetails.getTransRefGUID();

		if (transExeDate == null || transExeDate.equals("") ||  transRefGUID == null || transRefGUID.equals("")){
			return true;
		}
		return false;
	}
	
	private HashMap<String,String> getWMAdataMap(WMAData wdata){

		HashMap<String,String> WMADataMap=new LinkedHashMap<String,String>();

		WMADataMap.put(LoanConstants.WMA_POL_NUMBER, wdata.getPolNumber());
		WMADataMap.put(LoanConstants.WMA_TRANS_TYPE, wdata.getTransType());
		WMADataMap.put(LoanConstants.WMA_FINACTIVITY_NET_AMT, wdata.getFinActivityNetAmt());
		WMADataMap.put(LoanConstants.WMA_TRANS_EXE_DATE, wdata.getTransExeDate());
		WMADataMap.put(LoanConstants.WMA_TRANS_EXE_TIME, wdata.getTransExeTime());
		WMADataMap.put(LoanConstants.WMA_PAYMENT_FORM, wdata.getPaymentForm());
		WMADataMap.put(LoanConstants.WMA_FULL_NAME, wdata.getFullName());
		WMADataMap.put(LoanConstants.WMA_ADDRESS_TYPE_CODE, wdata.getAddressTypeCode());
		WMADataMap.put(LoanConstants.WMA_LINE1, wdata.getLine1());
		WMADataMap.put(LoanConstants.WMA_Line2, wdata.getLine2());
		WMADataMap.put(LoanConstants.WMA_Line3, wdata.getLine3());
		WMADataMap.put(LoanConstants.WMA_Pay_Prem_Ind, wdata.getPayPremInd());
		WMADataMap.put(LoanConstants.WMA_No_Of_Prems, wdata.getNoOfPrems());
		WMADataMap.put(LoanConstants.WMA_RACF_ID, wdata.getRACFId());
		WMADataMap.put(LoanConstants.WMA_Trans_Eff_Date, wdata.getTransEffDate());
		WMADataMap.put(LoanConstants.WMA_TAX_WITH_HOLDING_TYPE, wdata.getTaxWithholdingType());
		
		return WMADataMap;
	}

	public String getText_file_path() {
		return Text_file_path;
	}

	public void setText_file_path(String text_file_path) {
		Text_file_path = text_file_path;
	}
	private String Text_file_path;
	
	
	
	
	
	
}
