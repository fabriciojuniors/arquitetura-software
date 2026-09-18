package factory;

/**
 * Implementação de um serviço de notificação.
 * Seguindo padrão Factory Method, as utilização não irão depender desta classe, mas sim da interface {@link ServicoNotificacao}
 *
 * @author Fabricio Junior
 */
public class Email implements ServicoNotificacao {

    @Override
    public void notificar(String mensagem) {
        System.out.println("Enviando notificação via Email!");
    }
}
