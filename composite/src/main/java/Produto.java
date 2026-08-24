import java.math.BigDecimal;

/**
 * Representa um produto simples
 *
 * @param valor valor de venda do produto
 * @param nome  nome do produto
 */
public record Produto(BigDecimal valor,
                      String nome) {
}