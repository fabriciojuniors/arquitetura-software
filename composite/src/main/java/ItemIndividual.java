import java.math.BigDecimal;

/**
 * Representa um item que será vendido individualmente.
 *
 * @param produto    produto a ser vendido
 * @param quantidade quantidade vendida
 */
public record ItemIndividual(Produto produto, BigDecimal quantidade) implements ItemVenda {
    @Override
    public BigDecimal valorTotal() {
        return produto.valor().multiply(quantidade);
    }
}