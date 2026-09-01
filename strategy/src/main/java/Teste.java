import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Teste {

    public final static Map<String, CalculoFreteStrategy> ESTRATEGIAS = Map.of(
            "SEDEX", new CalculoFreteSedexStrategy(),
            "TRANSPORTADORA", new CalculoFreteTransportadoraStrategy()
    );

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.println("Informe a modalidade de frete:");
        System.out.println("SEDEX");
        System.out.println("TRANSPORTADORA");

        var frete = sc.nextLine();
        var contexto = new ContextoCalculoFrete(frete,
                new BigDecimal("5"),
                new BigDecimal("15"));

        CalculoFreteStrategy estrategia = ESTRATEGIAS.get(contexto.tipoFrete());
        System.out.println("Valor do frete: " + estrategia.calcular(contexto));
    }

}
