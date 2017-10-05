package com.dxc.loantransaction.service;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import com.dxc.loantransaction.request.TranDetails;
import com.dxc.loantransaction.request.TxLoan;

@WebService(serviceName="LoanService",portName="LoanPort")
public interface Loan {
	@WebMethod(operationName="Loan")
	public TranDetails createLoanTransaction(@WebParam(name="TxLoan") TxLoan txloan);

}
