package factory;

/**
 * Serviço ficticio que fará a utilização da interface {@link ServicoNotificacao} para disparado da ação.
 * <p>
 * Note: Nesta classe não dependemos da implementação concreta, mas sim da interface. Detalhes técnicos da
 * implementação não são importantes neste contexto.
 * </p>
 *
 * @author Fabricio Junior
 */
public class VendaServico {

    private ServicoNotificacao servicoNotificacao;

    public VendaServico(ServicoNotificacao servicoNotificacao) {
        this.servicoNotificacao = servicoNotificacao;
    }

    public ServicoNotificacao getServicoNotificacao() {
        return servicoNotificacao;
    }

    public void setServicoNotificacao(ServicoNotificacao servicoNotificacao) {
        this.servicoNotificacao = servicoNotificacao;
    }

    /**
     * Método ficticio que, ao concluir uma venda, irá realizar a notificação.
     */
    public void concluir() {
        System.out.println("Concluindo venda!");
        servicoNotificacao.notificar("Venda concluída");
        System.out.println("Venda concluída com sucesso.");
    }
}
