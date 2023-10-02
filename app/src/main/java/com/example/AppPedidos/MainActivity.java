package com.example.AppPedidos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button btCadastrarCliente, btCadastrarProduto, btCadastrarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastrarCliente = findViewById(R.id.btCadastrarCliente);
        btCadastrarProduto = findViewById(R.id.btCadastrarProduto);
        btCadastrarPedido = findViewById(R.id.btCadastrarPedido);

        btCadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroCliente();
            }
        });

        btCadastrarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroProduto();
            }
        });

        btCadastrarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastroPedido();
            }
        });
    }

    private void abrirCadastroCliente() {
        Intent intent = new Intent(this, CadastroClienteActivity.class);
        startActivity(intent);
    }

    private void abrirCadastroProduto() {
        Intent intent = new Intent(this, CadastroProdutoActivity.class);
        startActivity(intent);
    }

    private void abrirCadastroPedido() {
        Intent intent = new Intent(this, CadastroPedidoActivity.class);
        startActivity(intent);
    }
}
