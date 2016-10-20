package pequenaarea.bmp.com.pequenaarea.infra;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

import com.google.android.gms.common.data.DataBufferObserver;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by Breno on 04/10/2016.
 */

public class UsuarioRepositorio
{
    private Handler handler = null;

    public UsuarioRepositorio(Handler evento)
    {
        handler = evento;
    }

    public void SalvarNovoUsuario(String email, String senha)
    {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(salvaUsuarioListener);
    }

    OnCompleteListener<AuthResult> salvaUsuarioListener =  new OnCompleteListener<AuthResult>()
    {

        @Override
        public void onComplete(@NonNull Task<AuthResult> task)
        {
            String mensagem = "";
            Boolean sucesso = false;
            EstadoProcessoAssync estado = EstadoProcessoAssync.Processando;

            if(task.isComplete() && task.isSuccessful())
            {
                mensagem = "";
                sucesso = true;
                estado = EstadoProcessoAssync.Finalizado;
            }
            else if (task.isComplete() && !task.isSuccessful()) {
                mensagem = task.getException().getMessage();
                sucesso = false;
                estado = EstadoProcessoAssync.Finalizado;
            }

            Message msg = new Message();
            msg.obj = new RetornoProcessoAssync(mensagem, sucesso, estado);
            handler.sendMessage(msg);
        }
    };

}
