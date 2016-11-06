package pequenaarea.bmp.com.pequenaarea.activity;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import pequenaarea.bmp.com.pequenaarea.R;
import pequenaarea.bmp.com.pequenaarea.activity.Adapter.PeladaListViewAdapter;
import pequenaarea.bmp.com.pequenaarea.infra.EstadoProcessoAssync;
import pequenaarea.bmp.com.pequenaarea.infra.PeladaRepository;
import pequenaarea.bmp.com.pequenaarea.infra.RetornoProcessoAssync;
import pequenaarea.bmp.com.pequenaarea.model.Pelada;

public class TelaPrincipal extends AppCompatActivity {

    private ListView listaPeladas = null;
    private Handler handler;
    private Activity iam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        iam = this;

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                List<Pelada> retornoListaPeladas = (List<Pelada>) msg.obj;
                String mensagem = "Algum problema inesperado aconteceu, tente novamente.";

                if (retornoListaPeladas == null)
                    return;

                if (retornoListaPeladas.isEmpty())
                    return;

                listaPeladas = (ListView) findViewById(R.id.lstPeladas);

                PeladaListViewAdapter adapter = new PeladaListViewAdapter(retornoListaPeladas, iam);

                listaPeladas.setAdapter(adapter);

                Toast toast = Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT);
                toast.show();
            }
        };

        PeladaRepository repositorio = new PeladaRepository(handler);
        repositorio.BuscaPeladasDisponiveis();
    }
}
