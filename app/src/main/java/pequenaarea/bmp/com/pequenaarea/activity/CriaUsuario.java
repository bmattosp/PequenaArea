package pequenaarea.bmp.com.pequenaarea.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pequenaarea.bmp.com.pequenaarea.R;
import pequenaarea.bmp.com.pequenaarea.infra.EstadoProcessoAssync;
import pequenaarea.bmp.com.pequenaarea.infra.RetornoProcessoAssync;
import pequenaarea.bmp.com.pequenaarea.infra.UsuarioRepositorio;
import pequenaarea.bmp.com.pequenaarea.model.Usuario;

public class CriaUsuario extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private Button btnCadastrar;
    private String idUsuarioLogado;
    private Usuario usuario;

    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_usuario);


        email = (EditText)findViewById(R.id.edtEmail);
        senha = (EditText)findViewById(R.id.edtSenha);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(btnCadastrarClickListener);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg)
            {

                RetornoProcessoAssync retorno = (RetornoProcessoAssync) msg.obj;
                String mensagem = "Algum problema inesperado aconteceu, tente novamente.";

                if(retorno._estado != EstadoProcessoAssync.Finalizado)
                    return;

                if(retorno._sucesso)
                    mensagem = "Usuário cadastrado com sucesso";
                else
                    mensagem = retorno._mensagem;

                Toast toast = Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT);
                toast.show();
            }
        };
    }

    private View.OnClickListener btnCadastrarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            UsuarioRepositorio repUsuario = new UsuarioRepositorio(handler);
            repUsuario.SalvarNovoUsuario(email.getText().toString(), senha.getText().toString());

        }
    };
}