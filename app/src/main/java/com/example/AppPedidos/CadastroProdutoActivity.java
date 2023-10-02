package com.example.AppPedidos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.AppPedidos.model.Produto;

import java.util.ArrayList;

public class CadastroProdutoActivity extends AppCompatActivity {

    private EditText edCodProduto, edDescProduto, edValorProduto;
    private Button btSalvarProduto;
    private TextView tvListaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        edCodProduto = findViewById(R.id.edCodProduto);
        edDescProduto = findViewById(R.id.edDescProduto);
        edValorProduto = findViewById(R.id.edValorProduto);
        btSalvarProduto = findViewById(R.id.btSalvarProduto);
        tvListaProdutos = findViewById(R.id.tvListaProdutos);

        btSalvarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { salvarProduto(); }
        });

        atualizarListaProduto();

    }

    private void salvarProduto() {
        String codProduto = edCodProduto.getText().toString().trim();
        String descProduto = edDescProduto.getText().toString().trim();
        String valorProdutoStr = edValorProduto.getText().toString().trim();

        if (codProduto.isEmpty()) {
            edCodProduto.setError("Informe o código do produto!");
            edCodProduto.requestFocus();
            return;
        }

        if (descProduto.isEmpty()) {
            edDescProduto.setError("Informe a descrição do produto!");
            edDescProduto.requestFocus();
            return;
        }

        if (valorProdutoStr.isEmpty() || Double.parseDouble(valorProdutoStr) <= 0.0) {
            edValorProduto.setError("Informe o valor do produto!");
            edValorProduto.requestFocus();
            return;
        }

        double valorProduto = Double.parseDouble(valorProdutoStr);

        Produto produto = new Produto();
        produto.setCodProduto(codProduto);
        produto.setDescProduto(descProduto);
        produto.setValorProduto(valorProduto);

        DataManipulation.getInstance().salvarProduto(produto);

        Toast.makeText(this, "Produto salvo com sucesso!", Toast.LENGTH_LONG).show();

        limparCampos();
        atualizarListaProduto();
    }

    private void atualizarListaProduto() {
        ArrayList<Produto> lista = DataManipulation.getInstance().getListaProdutos();
        StringBuilder texto = new StringBuilder();
        for (Produto prod : lista) {
            texto.append("Código: ").append(prod.getCodProduto()).append("\n")
                    .append("Descrição: ").append(prod.getDescProduto()).append("\n")
                    .append("Valor UN.: ").append(prod.getValorProduto()).append("\n")
                    .append("---------------------------------------------\n");
        }
        tvListaProdutos.setText(texto.toString());
    }

    private void limparCampos() {
        edCodProduto.getText().clear();
        edDescProduto.getText().clear();
        edValorProduto.getText().clear();
    }
}
