import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 * Representa uma um "Broker" no padrão de arquitetura Publish-Subscribe.
 *
 * <p>
 * O Broker é componentes responsável por gerenciar as filas/tópicos e notificar os inscritos
 * a cada nova mensagem recepcionada.
 * </p>
 *
 * @author Fabricio Junior
 */
public class Broker {

    /**
     * Armazena todos os inscritos por tópico.
     */
    private final Map<String, List<Consumer<Mensagem>>> subscribers = new ConcurrentHashMap<>();

    /**
     * Adiciona um novo inscrito ao tópico, caso ainda não exista.
     *
     * @param topico     tópico no qual a inscrição será vinculada.
     * @param subscriber novo inscrito ao tópico.
     */
    public void subscribe(String topico, Consumer<Mensagem> subscriber) {
        var topicoExistente = subscribers.get(topico);
        if (topicoExistente != null && topicoExistente.contains(subscriber)) {
            System.out.println("[Broker] O inscrito já está registrado, não será adicionado.");
            return;
        }

        subscribers.computeIfAbsent(topico, subs -> new CopyOnWriteArrayList<>()).add(subscriber);
    }

    /**
     * Remove um inscrito ao tópico;
     *
     * @param topico     tópico no qual a inscrição será removida.
     * @param subscriber inscrito a ser removido do tópico.
     */
    public void unsubscribe(String topico, Consumer<Mensagem> subscriber) {
        var consumers = subscribers.get(topico);

        if (consumers != null && !consumers.isEmpty()) {
            consumers.remove(subscriber);
        }
    }

    /**
     * Publica uma nova mensagem para o tópico.
     *
     * @param topico   tópico que receberá a nova mensagem.
     * @param mensagem mensagem que será encaminhada para todos os inscritos.
     */
    public void publish(String topico, Mensagem mensagem) {
        var inscritos = subscribers.get(topico);

        if (inscritos != null && !inscritos.isEmpty()) {
            for (Consumer<Mensagem> subscriber : inscritos) {
                subscriber.accept(mensagem);
            }
        } else {
            System.out.println("[Broker] Nenhum inscrito para o tópico: " + topico);
        }
    }
}
