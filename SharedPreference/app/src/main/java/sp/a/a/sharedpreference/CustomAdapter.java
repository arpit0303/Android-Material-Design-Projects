package sp.a.a.sharedpreference;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Arpit on 26/02/15.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private LayoutInflater inflater;
    List<Information> data = Collections.emptyList();

    public CustomAdapter(Context context, List<Information> data){
        inflater = LayoutInflater.from(context);
        this.data = data;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Information current = data.get(position);
        holder.imageView.setImageResource(current.iconId);
        holder.textView.setText(current.title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

         public ViewHolder(View itemView) {
            super(itemView);
             textView = (TextView) itemView.findViewById(R.id.listText);
             imageView = (ImageView) itemView.findViewById(R.id.listIcon);

        }
    }
}
