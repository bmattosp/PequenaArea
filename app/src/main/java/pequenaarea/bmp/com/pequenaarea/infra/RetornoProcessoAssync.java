package pequenaarea.bmp.com.pequenaarea.infra;

/**
 * Created by Breno on 06/10/2016.
 */
public class RetornoProcessoAssync
{
    public String _mensagem;
    public Boolean _sucesso;
    public EstadoProcessoAssync _estado = EstadoProcessoAssync.Novo;

    public RetornoProcessoAssync(String msg, Boolean sucesso, EstadoProcessoAssync estado)
    {
        _mensagem = msg;
        _sucesso = sucesso;
        _estado = estado;
    }
}


