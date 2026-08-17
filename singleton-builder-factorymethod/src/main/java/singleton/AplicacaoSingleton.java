import singleton.ConfiguracoesService;

void main() {
    var servico = ConfiguracoesService.getInstance();

    System.out.println("Conexões máximas:" + servico.getMaxConexoesBd());

    var servico2 = ConfiguracoesService.getInstance();

    System.out.println("Conexões máximas:" + servico2.getMaxConexoesBd());
}