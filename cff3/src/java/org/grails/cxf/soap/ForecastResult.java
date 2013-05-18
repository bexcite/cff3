
package org.grails.cxf.soap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for forecastResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="forecastResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.cff3.jevera.com/}generalResult">
 *       &lt;sequence>
 *         &lt;element name="consumption" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "forecastResult", propOrder = {
    "consumption"
})
public class ForecastResult
    extends GeneralResult
{

    @XmlElement(nillable = true)
    protected List<Long> consumption;

    /**
     * Gets the value of the consumption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consumption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsumption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getConsumption() {
        if (consumption == null) {
            consumption = new ArrayList<Long>();
        }
        return this.consumption;
    }

}
