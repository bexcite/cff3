
package org.grails.cxf.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for forecastRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="forecastRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="publicFactors" type="{http://webservice.cff3.jevera.com/}publicFactorSet" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "forecastRequest", propOrder = {
    "publicFactors"
})
public class ForecastRequest {

    @XmlElement(nillable = true)
    protected List<PublicFactorSet> publicFactors;

    /**
     * Gets the value of the publicFactors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the publicFactors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPublicFactors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PublicFactorSet }
     * 
     * 
     */
    public List<PublicFactorSet> getPublicFactors() {
        if (publicFactors == null) {
            publicFactors = new ArrayList<PublicFactorSet>();
        }
        return this.publicFactors;
    }

}
