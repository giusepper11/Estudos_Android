package br.com.giuseppe.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { // oncreate mostra o layout na tela
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos); //R se relaciona a pasta res

        String[] alunos = {"Daniel", "Ronaldo", "Jefferson", "Felipe", "Daniel", "Ronaldo", "Jefferson", "Felipe", "Daniel", "Ronaldo", "Jefferson", "Felipe", "Felipe", "Daniel", "Ronaldo"};
        ListView listaAlunos = findViewById(R.id.lista_alunos);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);


        Button novoAluno = (Button) findViewById(R.id.novo_aluno);
        novoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiProFormulario = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intentVaiProFormulario);
            }
        });
    }
}