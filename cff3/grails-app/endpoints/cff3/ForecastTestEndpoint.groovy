package cff3



import org.grails.cxf.utils.EndpointType

class ForecastTestEndpoint {
    static expose = EndpointType.JAX_WS
    static excludes = []

    String serviceMethod(String s) {
        return s
    }
}
