package factory;

/**
 * Interface responsável por determinar um contrato comum para todas as implementações.
 *
 * <p>
 * No padrão <b>Factory Method</b>, sempre trabalhamos partindo das interfaces, afim de garantir
 * que modificações internas da implementação não afetarão o uso.
 * </p>
 *
 * @author Fabricio Junior.
 */
public interface ServicoNotificacao {

    void notificar(String mensagem);

}
