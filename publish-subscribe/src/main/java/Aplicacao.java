void main() {
    final Broker broker = new Broker();
    final String topicoMensagem = "MENSAGEM";

    Consumer<Mensagem> consumidorSms = mensagem-> {
        System.out.println("[SMS] Iniciando envio da mensagem");
        System.out.println("Mensagem: " + mensagem.conteudo().toString());
        System.out.println("[SMS] enviado com sucesso.");
    };

    Consumer<Mensagem> consumidorEmail = mensagem-> {
        System.out.println("[E-Mail] Iniciando envio da mensagem");
        System.out.println("Mensagem: " + mensagem.conteudo().toString());
        System.out.println("[E-Mail] Eviado com sucesso.");
    };

    Consumer<Mensagem> consumidorWhatsapp = mensagem-> {
        System.out.println("[WhatsApp] Iniciando envio da mensagem");
        System.out.println("Mensagem: " + mensagem.conteudo().toString());
        System.out.println("[WhatsApp] Enviado com sucesso.");
    };


    broker.subscribe(topicoMensagem, consumidorSms);
    broker.subscribe(topicoMensagem, consumidorEmail);

    broker.publish(topicoMensagem, new Mensagem("Compra realizada com sucesso!"));

    broker.subscribe(topicoMensagem, consumidorWhatsapp);

    broker.publish(topicoMensagem, new Mensagem("Segunda compra realizada com sucesso!"));

    broker.subscribe(topicoMensagem, consumidorSms);
}