import java.math.BigDecimal;

public class CalculoFreteSedexStrategy implements CalculoFreteStrategy {

    @Override
    public BigDecimal calcular(ContextoCalculoFrete contexto) {
        return contexto.pesoMercadoria().multiply(BigDecimal.valueOf(1.5))
                .add(contexto.pesoMercadoria().multiply(BigDecimal.valueOf(0.05)));
    }
}
