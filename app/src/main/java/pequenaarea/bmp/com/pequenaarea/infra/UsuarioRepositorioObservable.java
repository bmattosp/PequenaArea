package pequenaarea.bmp.com.pequenaarea.infra;

import com.google.android.gms.common.data.DataBufferObserver;

import java.util.List;
import java.util.Observable;

/**
 * Created by Breno on 16/10/2016.
 */

public class UsuarioRepositorioObservable extends Observable {

    private RetornoProcessoAssync retorno = null;

    public UsuarioRepositorioObservable(RetornoProcessoAssync retorno)
    {
        this.retorno = retorno;
    }
    public void setValue(RetornoProcessoAssync retorno)
    {
        this.retorno = retorno;
        setChanged();
        notifyObservers();
    }
    public RetornoProcessoAssync getValue()
    {
        return retorno;
    }

    public void Update()
    {
        setChanged();
        notifyObservers();
    }
}
