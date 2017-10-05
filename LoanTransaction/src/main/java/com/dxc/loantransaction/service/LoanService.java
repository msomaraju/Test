package com.dxc.loantransaction.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.dxc.loantransaction.constants.LoanConstants;
import com.dxc.loantransaction.helper.LoanServiceHelper;
import com.dxc.loantransaction.request.IndexedData;
import com.dxc.loantransaction.request.TranDetails;
import com.dxc.loantransaction.request.TxLoan;
import com.dxc.loantransaction.request.WMAData;
//hello
@WebService(endpointInterface="com.dxc.loantransaction.service.Loan",serviceName="LoanService",portName = "LoanPort")
public class LoanService implements Loan {

	private	 static final Logger log=Logger.getLogger(LoanService.class.getName());

	LoanServiceHelper loanhelper=new LoanServiceHelper();
	String textFilePath;

	public LoanService(){
		log.info("Log4j properties file loading starting...");
		Properties Config_properties = new Properties();
		InputStream fileInput=this.getClass().getResourceAsStream("/config.properties");
		try {
			Config_properties.load(fileInput);
			PropertyConfigurator.configure(Config_properties.getProperty("Log4jProperties_Location"));
			System.out.println(Config_properties.getProperty("Log4jProperties_Location"));
		} catch (IOException e) {
			log.error("Error occured while retreiving a log4j Property value"+e.getMessage());
			e.printStackTrace();
		}
	}

	@WebMethod
	public TranDetails createLoanTransaction(@WebParam(name="TxLoan") TxLoan txloan)  {
		log.info("createLoanTransaction method starting...");
		IndexedData indexedData = txloan.getIndexedData();
		TranDetails tranInfo = txloan.getTranDetails();
		WMAData wmaData = txloan.getWMAData();

		boolean validate=loanhelper.indexedDataContainsNull(indexedData);
		log.info("Indexed data  null checking return is ::"+validate);
		if(validate == true) {
			log.info("Indexed Data contains null or empty values :");
			tranInfo.setTranID(tranInfo.getTransRefGUID());
			tranInfo.setTransExeDate(wmaData.getTransExeDate());
			tranInfo.setTransExeTime(loanhelper.getTimeStamp());
			tranInfo.setTransType(wmaData.getTransType());
			tranInfo.setResultCode(LoanConstants.MSGCODEFAILURE);
		}
		else{
			boolean txtfile=loanhelper.createTxtFile(wmaData);
			log.info("createTxtFile return value is ::"+txtfile);
			if(txtfile == true){
				log.info("Txt file creaed successfully.");
				textFilePath=loanhelper.getText_file_path();
				boolean xmlfile =loanhelper.createXmlFile(indexedData,textFilePath);
				log.info("createXMLFile return value is ::"+xmlfile);
				if(xmlfile == true){
					log.info("xml file created successfully.");
					tranInfo.setTranID(tranInfo.getTransRefGUID());
					tranInfo.setTransExeDate(wmaData.getTransExeDate());
					tranInfo.setTransExeTime(loanhelper.getTimeStamp());
					tranInfo.setTransType(wmaData.getTransType());
					tranInfo.setResultCode(LoanConstants.MSGCODESUCCESS);

				}
			}
		}
		log.info("createLoanTransaction method end.");
		return tranInfo;
	}
}
