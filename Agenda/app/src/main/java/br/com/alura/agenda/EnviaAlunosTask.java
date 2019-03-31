package br.com.alura.agenda;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import br.com.alura.agenda.converter.AlunoConverter;
import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.modelo.Aluno;
/*
* Primeiro parametro Object esta relacionado ao parametro params do metodo doInBackground*/
public class EnviaAlunosTask extends AsyncTask<Object, Object, String> {
    private Context context;
    private ProgressDialog dialog;

    public EnviaAlunosTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Object... params) {
        AlunoDAO dao = new AlunoDAO(context);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        AlunoConverter conversor = new AlunoConverter();
        String json = conversor.converterParaJson(alunos);

        WebClient client = new WebClient();
        String resposta = client.post(json);
//        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) { // Executado na thread principal
        dialog.dismiss();
        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde", "Enviando alunos ...", true, true);
    }

}
