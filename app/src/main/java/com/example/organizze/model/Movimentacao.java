package com.example.organizze.model;

import com.example.organizze.config.ConfiguraçãoFirebase;
import com.example.organizze.helper.Base64Custon;
import com.example.organizze.helper.DateCuston;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Movimentacao {

    private String data;
    private String categoria;
    private String descricao;
    private String tipo;
    private double valor;
    private String key;

    public Movimentacao() {
    }

    public void salvar(String dataEscolhida){

        FirebaseAuth autenticacao = ConfiguraçãoFirebase.getFirebaseAutenticacao();
        String idUsuario = Base64Custon.codificarBase64( autenticacao.getCurrentUser().getEmail() );
        String mesAno = DateCuston.mesAnoDataEscolhida( dataEscolhida );

        DatabaseReference firebase = ConfiguraçãoFirebase.getFirebaseDataBase();
        firebase.child("movimentacao")
                .child( idUsuario )
                .child( mesAno )
                .push()
                .setValue(this);

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
