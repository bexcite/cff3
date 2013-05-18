import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.grails.cxf.soap.ForecastRequest;
import org.grails.cxf.soap.ForecastResult;
import org.grails.cxf.soap.ForecastService;
import org.grails.cxf.soap.PublicFactorSet;
import org.grails.cxf.soap.ResultCode;
import org.grails.cxf.utils.EndpointType;


class ForecastServiceTestEndpoint implements ForecastService {
  
  static expose = EndpointType.JAX_WS
  static excludes = []

  @Override
  @WebResult(name = "result", targetNamespace = "")
  @RequestWrapper(localName = "forecast", targetNamespace = "http://webservice.cff3.jevera.com/", className = "org.grails.cxf.soap.Forecast")
  @WebMethod
  @ResponseWrapper(localName = "forecastResponse", targetNamespace = "http://webservice.cff3.jevera.com/", className = "org.grails.cxf.soap.ForecastResponse")
  public ForecastResult forecast(
      @WebParam(name = "request", targetNamespace = "") ForecastRequest request) {
    
      
      final ForecastResult result = new ForecastResult();
      result.setResult(ResultCode.SUCCESS);
      
      for (final PublicFactorSet set : request.getPublicFactors()) {
        result.getConsumption().add(Generator.generate(set));
      }      
    return result;
  }

}

