//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.06 at 02:42:21 PM IST 
//


package com.dxc.loantransaction.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WMAData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WMAData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PolNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FinActivityNetAmt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransExeDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransExeTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PaymentForm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AddressTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Line1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Line2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Line3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NoOfPrems" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PayPremInd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RACFId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TransEffDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TaxWithholdingType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WMAData", propOrder = {
    "polNumber",
    "transType",
    "finActivityNetAmt",
    "transExeDate",
    "transExeTime",
    "paymentForm",
    "fullName",
    "addressTypeCode",
    "line1",
    "line2",
    "line3",
    "noOfPrems",
    "payPremInd",
    "racfId",
    "transEffDate",
    "taxWithholdingType"
})
public class WMAData {

    @XmlElement(name = "PolNumber", required = true)
    protected String polNumber;
    @XmlElement(name = "TransType", required = true)
    protected String transType;
    @XmlElement(name = "FinActivityNetAmt", required = true)
    protected String finActivityNetAmt;
    @XmlElement(name = "TransExeDate", required = true)
    protected String transExeDate;
    @XmlElement(name = "TransExeTime", required = true)
    protected String transExeTime;
    @XmlElement(name = "PaymentForm", required = true)
    protected String paymentForm;
    @XmlElement(name = "FullName", required = true)
    protected String fullName;
    @XmlElement(name = "AddressTypeCode", required = true)
    protected String addressTypeCode;
    @XmlElement(name = "Line1", required = true)
    protected String line1;
    @XmlElement(name = "Line2", required = true)
    protected String line2;
    @XmlElement(name = "Line3", required = true)
    protected String line3;
    @XmlElement(name = "NoOfPrems", required = true)
    protected String noOfPrems;
    @XmlElement(name = "PayPremInd", required = true)
    protected String payPremInd;
    @XmlElement(name = "RACFId", required = true)
    protected String racfId;
    @XmlElement(name = "TransEffDate", required = true)
    protected String transEffDate;
    @XmlElement(name = "TaxWithholdingType", required = true)
    protected String taxWithholdingType;

    /**
     * Gets the value of the polNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolNumber() {
        return polNumber;
    }

    /**
     * Sets the value of the polNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolNumber(String value) {
        this.polNumber = value;
    }

    /**
     * Gets the value of the transType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransType() {
        return transType;
    }

    /**
     * Sets the value of the transType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransType(String value) {
        this.transType = value;
    }

    /**
     * Gets the value of the finActivityNetAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinActivityNetAmt() {
        return finActivityNetAmt;
    }

    /**
     * Sets the value of the finActivityNetAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinActivityNetAmt(String value) {
        this.finActivityNetAmt = value;
    }

    /**
     * Gets the value of the transExeDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransExeDate() {
        return transExeDate;
    }

    /**
     * Sets the value of the transExeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransExeDate(String value) {
        this.transExeDate = value;
    }

    /**
     * Gets the value of the transExeTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransExeTime() {
        return transExeTime;
    }

    /**
     * Sets the value of the transExeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransExeTime(String value) {
        this.transExeTime = value;
    }

    /**
     * Gets the value of the paymentForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentForm() {
        return paymentForm;
    }

    /**
     * Sets the value of the paymentForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentForm(String value) {
        this.paymentForm = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the addressTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressTypeCode() {
        return addressTypeCode;
    }

    /**
     * Sets the value of the addressTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressTypeCode(String value) {
        this.addressTypeCode = value;
    }

    /**
     * Gets the value of the line1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLine1() {
        return line1;
    }

    /**
     * Sets the value of the line1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLine1(String value) {
        this.line1 = value;
    }

    /**
     * Gets the value of the line2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLine2() {
        return line2;
    }

    /**
     * Sets the value of the line2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLine2(String value) {
        this.line2 = value;
    }

    /**
     * Gets the value of the line3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLine3() {
        return line3;
    }

    /**
     * Sets the value of the line3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLine3(String value) {
        this.line3 = value;
    }

    /**
     * Gets the value of the noOfPrems property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfPrems() {
        return noOfPrems;
    }

    /**
     * Sets the value of the noOfPrems property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfPrems(String value) {
        this.noOfPrems = value;
    }

    /**
     * Gets the value of the payPremInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayPremInd() {
        return payPremInd;
    }

    /**
     * Sets the value of the payPremInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayPremInd(String value) {
        this.payPremInd = value;
    }

    /**
     * Gets the value of the racfId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRACFId() {
        return racfId;
    }

    /**
     * Sets the value of the racfId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRACFId(String value) {
        this.racfId = value;
    }

    /**
     * Gets the value of the transEffDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransEffDate() {
        return transEffDate;
    }

    /**
     * Sets the value of the transEffDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransEffDate(String value) {
        this.transEffDate = value;
    }

    /**
     * Gets the value of the taxWithholdingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxWithholdingType() {
        return taxWithholdingType;
    }

    /**
     * Sets the value of the taxWithholdingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxWithholdingType(String value) {
        this.taxWithholdingType = value;
    }

}
