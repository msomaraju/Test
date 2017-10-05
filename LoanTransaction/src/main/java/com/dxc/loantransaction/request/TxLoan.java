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
 * <p>Java class for TxLoan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TxLoan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IndexedData" type="{http://www.dxc.com/request/}IndexedData"/>
 *         &lt;element name="WMAData" type="{http://www.dxc.com/request/}WMAData"/>
 *         &lt;element name="TranDetails" type="{http://www.dxc.com/request/}TranDetails"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TxLoan", propOrder = {
    "indexedData",
    "wmaData",
    "tranDetails"
})
public class TxLoan {

    @XmlElement(name = "IndexedData", required = true)
    protected IndexedData indexedData;
    @XmlElement(name = "WMAData", required = true)
    protected WMAData wmaData;
    @XmlElement(name = "TranDetails", required = true)
    protected TranDetails tranDetails;

    /**
     * Gets the value of the indexedData property.
     * 
     * @return
     *     possible object is
     *     {@link IndexedData }
     *     
     */
    public IndexedData getIndexedData() {
        return indexedData;
    }

    /**
     * Sets the value of the indexedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndexedData }
     *     
     */
    public void setIndexedData(IndexedData value) {
        this.indexedData = value;
    }

    /**
     * Gets the value of the wmaData property.
     * 
     * @return
     *     possible object is
     *     {@link WMAData }
     *     
     */
    public WMAData getWMAData() {
        return wmaData;
    }

    /**
     * Sets the value of the wmaData property.
     * 
     * @param value
     *     allowed object is
     *     {@link WMAData }
     *     
     */
    public void setWMAData(WMAData value) {
        this.wmaData = value;
    }

    /**
     * Gets the value of the tranDetails property.
     * 
     * @return
     *     possible object is
     *     {@link TranDetails }
     *     
     */
    public TranDetails getTranDetails() {
        return tranDetails;
    }

    /**
     * Sets the value of the tranDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link TranDetails }
     *     
     */
    public void setTranDetails(TranDetails value) {
        this.tranDetails = value;
    }

}
