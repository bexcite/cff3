
package org.grails.cxf.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.grails.cxf.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ForecastResponse_QNAME = new QName("http://webservice.cff3.jevera.com/", "forecastResponse");
    private final static QName _Forecast_QNAME = new QName("http://webservice.cff3.jevera.com/", "forecast");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.grails.cxf.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Forecast }
     * 
     */
    public Forecast createForecast() {
        return new Forecast();
    }

    /**
     * Create an instance of {@link ForecastResponse }
     * 
     */
    public ForecastResponse createForecastResponse() {
        return new ForecastResponse();
    }

    /**
     * Create an instance of {@link PublicFactor }
     * 
     */
    public PublicFactor createPublicFactor() {
        return new PublicFactor();
    }

    /**
     * Create an instance of {@link ForecastRequest }
     * 
     */
    public ForecastRequest createForecastRequest() {
        return new ForecastRequest();
    }

    /**
     * Create an instance of {@link ForecastResult }
     * 
     */
    public ForecastResult createForecastResult() {
        return new ForecastResult();
    }

    /**
     * Create an instance of {@link PublicFactorSet }
     * 
     */
    public PublicFactorSet createPublicFactorSet() {
        return new PublicFactorSet();
    }

    /**
     * Create an instance of {@link GeneralResult }
     * 
     */
    public GeneralResult createGeneralResult() {
        return new GeneralResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForecastResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.cff3.jevera.com/", name = "forecastResponse")
    public JAXBElement<ForecastResponse> createForecastResponse(ForecastResponse value) {
        return new JAXBElement<ForecastResponse>(_ForecastResponse_QNAME, ForecastResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Forecast }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.cff3.jevera.com/", name = "forecast")
    public JAXBElement<Forecast> createForecast(Forecast value) {
        return new JAXBElement<Forecast>(_Forecast_QNAME, Forecast.class, null, value);
    }

}
