void main() {
    var mouse = new Produto(new BigDecimal("10.50"), "Mouse");
    var teclado = new Produto(new BigDecimal("22.50"), "Teclado");
    var monitor = new Produto(new BigDecimal("100.00"), "Monitor");

    // Folhas individuais
    ItemVenda itemMouse = new ItemIndividual(mouse, BigDecimal.ONE);
    ItemVenda itemTeclado = new ItemIndividual(teclado, BigDecimal.ONE);

    // Um composite (Caixa do Kit Escritório)
    ItemKit kitEscritorio = new ItemKit();
    kitEscritorio.add(itemMouse);
    kitEscritorio.add(itemTeclado);

    // O Pedido final (Que também poderia ser um Composite de nível mais alto)
    ItemKit pedido = new ItemKit();
    pedido.add(new ItemIndividual(monitor, BigDecimal.ONE)); // Adiciona uma folha
    pedido.add(kitEscritorio); // Adiciona um composite inteiro (uma árvore de produtos)

    // O cálculo ocorre de forma recursiva e transparente
    System.out.println(pedido.valorTotal()); // Output: 133.00
}