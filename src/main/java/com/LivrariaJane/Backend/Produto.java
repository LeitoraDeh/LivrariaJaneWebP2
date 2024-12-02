package com.LivrariaJane.Backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String titulo;
    private String autora;
    @Column(columnDefinition = "TEXT")
    private String sinopse;
    @Column(columnDefinition = "TEXT")
    private String citacao;
    private String autorCitacao;
    @Column(columnDefinition = "TEXT")
    private String descricaoAutora;
    private String genero;
    private BigDecimal preco;  
    private String descritivo;
    private String keywords;
    private int quantidade;  
    private int destaque = 0;

    // Getters e Setters

    public int getDestaque() {
        return destaque;
    }
    public void setDestaque(int destaque) {
        this.destaque = destaque;
    }
  
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutora() {
        return autora;
    }

    public void setAutora(String autora) {
        this.autora = autora;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getCitacao() {
        return citacao;
    }

    public void setCitacao(String citacao) {
        this.citacao = citacao;
    }

    public String getAutorCitacao() {
        return autorCitacao;
    }

    public void setAutorCitacao(String autorCitacao) {
        this.autorCitacao = autorCitacao;
    }

    public String getDescricaoAutora() {
        return descricaoAutora;
    }

    public void setDescricaoAutora(String descricaoAutora) {
        this.descricaoAutora = descricaoAutora;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}