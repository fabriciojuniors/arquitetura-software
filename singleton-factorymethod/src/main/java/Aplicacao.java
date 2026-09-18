import factory.Email;
import factory.Sms;
import factory.VendaServico;

void main() {
    var notificacaoEmail = new Email();
    var notificacaoSms = new Sms();

    var venda1 = new VendaServico(notificacaoEmail);
    var venda2 = new VendaServico(notificacaoSms);

    venda1.concluir();
    venda2.concluir();
}