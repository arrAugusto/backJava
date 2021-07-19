package controlador;

import wsBancoGuatemala.InfoVariable;
import wsBancoGuatemala.VarDolar;

public class ConsumoSoap {

    public ConsumoSoap() {
    }

    public static VarDolar getTipoCambioDia() {

            wsBancoGuatemala.TipoCambio service = new wsBancoGuatemala.TipoCambio();
            wsBancoGuatemala.TipoCambioSoap port = service.getTipoCambioSoap();
            // TODO process result here
            wsBancoGuatemala.InfoVariable result = port.tipoCambioDia();
            return result.getCambioDolar().getVarDolar().get(0);
        


        
        
    }
}
