package com.example.AppPedidos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.AppPedidos.model.Cliente;

import java.util.ArrayList;

public class CadastroClienteActivity extends AppCompatActivity {

    private Button btSalvarCliente;
    private EditText edNomeCliente, edCPFCliente;
    private TextView tvListaClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        // Inicializar elementos da interface
        btSalvarCliente = findViewById(R.id.btSalvarCliente);
        tvListaClientes = findViewById(R.id.tvListaClientes);
        edNomeCliente = findViewById(R.id.edNomeCliente);
        edCPFCliente = findViewById(R.id.edCPFCliente);

        // Configurar o botão para salvar o cliente
        btSalvarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarCliente();
            }
        });

        atualizarListaCliente();
    }

    // Função para salvar um cliente
    private void salvarCliente() {
        String nome = edNomeCliente.getText().toString();
        String cpf = edCPFCliente.getText().toString();

        // Validar campos em branco
        if (nome.isEmpty()) {
            edNomeCliente.setError("Informe o nome do cliente!");
            edNomeCliente.requestFocus();
            return;
        }

        if (cpf.isEmpty()) {
            edCPFCliente.setError("Informe o CPF do cliente!");
            edCPFCliente.requestFocus();
            return;
        }

        // Criar um objeto Cliente e salvar
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);

        DataManipulation.getInstance().salvarCliente(cliente);

        // Exibir uma mensagem de sucesso
        Toast.makeText(this, "Cliente salvo com sucesso!", Toast.LENGTH_LONG).show();

        // Limpar os campos e atualizar a lista de clientes
        limparCampos();
        atualizarListaCliente();
    }

    // Função para limpar os campos de entrada
    private void limparCampos() {
        edNomeCliente.setText("");
        edCPFCliente.setText("");
    }

    // Função para atualizar a lista de clientes na interface
    private void atualizarListaCliente() {
        ArrayList<Cliente> lista = DataManipulation.getInstance().getListaClientes();
        StringBuilder texto = new StringBuilder();
        for (Cliente cli : lista) {
            texto.append("Nome: ").append(cli.getNome()).append("\n")
                    .append("CPF: ").append(cli.getCpf()).append("\n")
                    .append("---------------------------------------------\n");
        }
        tvListaClientes.setText(texto.toString());
    }
}
