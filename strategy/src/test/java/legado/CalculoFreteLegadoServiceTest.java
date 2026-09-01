package legado;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculoFreteLegadoServiceTest {

    @Test
    public void deve_Retornar505_Quando_PesoFor5_E_DistanciaFor15_Transportadora() {
        var servico = new CalculoFreteLegadoService();

        var valorFrete = servico
                .calcularFrete("TRANSPORTADORA", BigDecimal.valueOf(5l), BigDecimal.valueOf(15l));

        assertEquals(new BigDecimal("50.5"), valorFrete);
    }

}