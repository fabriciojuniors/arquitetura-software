package legado;

import java.math.BigDecimal;

public class CalculoFreteLegadoService {

    public BigDecimal calcularFrete(String tipoFrete, BigDecimal pesoMercadoria, BigDecimal distancia) {
        if ("PAC".equalsIgnoreCase(tipoFrete)) {
            return pesoMercadoria.multiply(BigDecimal.valueOf(1.5))
                    .add(distancia.multiply(BigDecimal.valueOf(0.05)));
        } else if ("SEDEX".equalsIgnoreCase(tipoFrete)) {
            return pesoMercadoria.multiply(BigDecimal.valueOf(3.0))
                    .add(distancia.multiply(BigDecimal.valueOf(0.12)))
                    .add(BigDecimal.valueOf(10.0));
        } else if ("TRANSPORTADORA".equalsIgnoreCase(tipoFrete)) {
            return pesoMercadoria.multiply(BigDecimal.valueOf(4.5))
                    .add(distancia.multiply(BigDecimal.valueOf(0.20)))
                    .add(BigDecimal.valueOf(25.0));
        } else if ("RETIRADA_NA_LOJA".equalsIgnoreCase(tipoFrete)) {
            return BigDecimal.ZERO;
        } else {
            throw new IllegalArgumentException("Modalidade de frete inválida: " + tipoFrete);
        }
    }
}
