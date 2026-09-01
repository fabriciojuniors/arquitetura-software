import java.math.BigDecimal;

public class CalculoFreteMotoboyStrategy implements CalculoFreteStrategy{

    @Override
    public BigDecimal calcular(ContextoCalculoFrete contexto) {
        if (contexto.distancia().compareTo(new BigDecimal("30.0")) > 0) {
            throw new RuntimeException("Distância superior à permitida!");
        }

        if (contexto.pesoMercadoria().compareTo(new BigDecimal("2")) > 0) {
            throw new RuntimeException("Peso superior ao permitido!");
        }

        return contexto.distancia().multiply(new BigDecimal("0.1"))
                .add(BigDecimal.TEN);
    }

}
