package pequenaarea.bmp.com.pequenaarea.activity.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pequenaarea.bmp.com.pequenaarea.R;
import pequenaarea.bmp.com.pequenaarea.model.Pelada;

/**
 * Created by Breno on 03/11/2016.
 */

public class PeladaListViewAdapter extends BaseAdapter
{
    private final List<Pelada> peladas;
    private final Activity act;

    public PeladaListViewAdapter(List<Pelada> peladas, Activity act)
    {
        this.peladas = peladas;
        this.act = act;
    }

    @Override
    public int getCount() {
        return peladas.size();
    }

    @Override
    public Object getItem(int position) {
        return peladas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return peladas.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater()
                .inflate(R.layout.activity_pelada_list_view, parent, false);

        Pelada pelada = peladas.get(position);

        TextView edtNome = (TextView) view.findViewById(R.id.txtNome);
        edtNome.setText( pelada.Nome);

        TextView txtLocal = (TextView) view.findViewById(R.id.txtLocal);
        edtNome.setText( pelada.Local.cidade);

        return view;
    }
}
