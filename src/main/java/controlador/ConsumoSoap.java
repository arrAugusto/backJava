package controlador;

import wsBancoGuatemala.InfoVariable;

public class ConsumoSoap {

    public ConsumoSoap() {
    }

    public static InfoVariable getTipoCambioDia() {
        //Inicializa el serivico soap
        wsBancoGuatemala.TipoCambio service = new wsBancoGuatemala.TipoCambio();
        wsBancoGuatemala.TipoCambioSoap port = service.getTipoCambioSoap();
        // TODO process result here
        wsBancoGuatemala.InfoVariable result = port.tipoCambioDia();
        return result;
        
    }
}
