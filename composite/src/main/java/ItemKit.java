import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um item que será vendido em forma de Kit/Grupo
 */
public class ItemKit implements ItemVenda {

    private List<ItemVenda> itens = new ArrayList<>();

    /**
     * Adiciona um novo item de venda para o Kit.
     *
     * @param item item a ser vinculado no Kit
     */
    public void add(ItemVenda item) {
        this.itens.add(item);
    }

    /**
     * Calcula o valor total do Kit, conforme interface
     *
     * @return
     */
    @Override
    public BigDecimal valorTotal() {
        return this.itens.stream()
                .map(ItemVenda::valorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
