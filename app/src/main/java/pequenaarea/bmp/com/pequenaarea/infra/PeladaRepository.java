package pequenaarea.bmp.com.pequenaarea.infra;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import pequenaarea.bmp.com.pequenaarea.model.Endereco;
import pequenaarea.bmp.com.pequenaarea.model.Pelada;

/**
 * Created by Breno on 02/11/2016.
 */

public class PeladaRepository
{
    private Handler handler = null;

    public PeladaRepository(Handler evento)
    {
        handler = evento;
    }

    public void BuscaPeladasDisponiveis()
    {

        List<Pelada>  listaRetorno = new ArrayList<Pelada>();

        for (int i =0; i <= 10; i++)
        {
            final int finalI = i;
            listaRetorno.add(new Pelada(){
                                {
                                    id = finalI;
                                    Nome = Integer.toString(finalI);
                                    Local = new Endereco(){{
                                       cidade = "Rio de Janeiro";
                                    }};

                                }});
        }

        Message msg = new Message();
        msg.obj = listaRetorno;
        handler.sendMessage(msg);
    }

}
