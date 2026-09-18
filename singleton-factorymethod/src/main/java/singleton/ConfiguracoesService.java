package singleton;

/**
 * Representa uma classe de configurações no Padrão <b>Singleton</b>.
 *
 * <p>
 * Uma objeto Singleton significa que uma instância do objeto será compartilhada em toda a aplicação.
 * </p>
 *
 * @author Fabricio Junior
 */
public class ConfiguracoesService {

    private final int maxConexoesBd = 10;

    /**
     * Representa a instância do Objeto, uma vez inicializada, será compartilhada e utilizada
     * ao longo de todo ciclo de vida da aplicação
     */
    private static ConfiguracoesService instance;

    /**
     * No padrão Singleton, os construtores devem ser privados, afim de garantir que
     * novas instancias do objeto não possam ser criadas.
     */
    private ConfiguracoesService() {

    }

    /**
     * Método que irá realizar a obtenção da instancia do objeto, caso ainda não inicializado,
     * irá realizar uma inicialização e posteriormente retornar.
     *
     * @return instancia do objeto criada ou pré-existente
     */
    public static ConfiguracoesService getInstance() {
        if (instance == null) {
            System.out.println("Classe não iniciada, criando instancia.");
            instance = new ConfiguracoesService();
        }

        return instance;
    }

    public int getMaxConexoesBd() {
        return maxConexoesBd;
    }
}
