import java.math.BigDecimal;

public record ContextoCalculoFrete(String tipoFrete,
                                   BigDecimal pesoMercadoria,
                                   BigDecimal distancia,
                                   BigDecimal altura) {

    public ContextoCalculoFrete(String tipoFrete,
                                BigDecimal pesoMercadoria,
                                BigDecimal distancia) {
        this(tipoFrete, pesoMercadoria, distancia, null);
    }
}
