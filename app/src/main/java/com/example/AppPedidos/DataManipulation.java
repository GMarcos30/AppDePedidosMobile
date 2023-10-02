package com.example.AppPedidos;

import com.example.AppPedidos.model.Cliente;
import com.example.AppPedidos.model.Pedido;
import com.example.AppPedidos.model.Produto;

import java.util.ArrayList;

public class DataManipulation {

    private static DataManipulation instancia;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Produto> listaProdutos;

    private ArrayList<Pedido> listaPedidos;

    public static DataManipulation getInstance() {
        if (instancia == null) {
            return instancia = new DataManipulation();
        }
        return instancia;
    }

    private DataManipulation() {
        listaClientes = new ArrayList<>();
        listaProdutos = new ArrayList<>();
        listaPedidos = new ArrayList<>();
    }

    public void salvarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void salvarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public ArrayList<Produto> getListaProdutos() { return listaProdutos; }

    public void salvarPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    public ArrayList<Pedido> getListaPedidos() { return listaPedidos; }
}
