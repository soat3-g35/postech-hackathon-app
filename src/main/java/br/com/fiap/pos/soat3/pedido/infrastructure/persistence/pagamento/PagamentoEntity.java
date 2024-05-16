package br.com.fiap.pos.soat3.pedido.infrastructure.persistence.pagamento;

import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.pedido.PedidoEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "pagamento")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @Column(name = "qr_code")
    private String qrCode;

    @Column(name = "webhook")
    private String webhook;

    public PagamentoEntity() {
    }

    public PagamentoEntity(PedidoEntity pedido, String qrCode, String webhook) {
        this.pedido = pedido;
        this.qrCode = qrCode;
        this.webhook = webhook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }
}
