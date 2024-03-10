package br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.produto;

import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.categoria.CategoriaEntity;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.itempedido.ItemPedidoEntity;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private String valor;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "imagem")
    private String imagem;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaEntity categoria;

    @OneToMany(mappedBy = "produto")
    private Collection<ItemPedidoEntity> items;

    public ProdutoEntity(String nome, String valor, String descricao, String imagem, CategoriaEntity categoriaEntity) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.imagem = imagem;
        this.categoria = categoriaEntity;
    }

    public ProdutoEntity() {

    }

    public ProdutoEntity(Long id) {
       this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public Collection<ItemPedidoEntity> getItems() {
        return items;
    }

    public void setItems(Collection<ItemPedidoEntity> items) {
        this.items = items;
    }
}
