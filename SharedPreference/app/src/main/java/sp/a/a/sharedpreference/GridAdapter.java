package sp.a.a.sharedpreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Arpit on 26/02/15.
 */
public class GridAdapter extends ArrayAdapter<String> {

    Context mContext;
    int[] icons = {R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher};
    String[] title = {"a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d"};

    public GridAdapter(Context context) {
        super(context, R.layout.custom_row);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.custom_row, null);
            holder = new ViewHolder();

            holder.title = (TextView) convertView.findViewById(R.id.listText);
            holder.menu = (ImageView) convertView.findViewById(R.id.listIcon);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.menu.setImageResource(icons[position]);
        holder.title.setText(title[position]);

        return convertView;
    }

    public static class ViewHolder {
        TextView title;
        ImageView menu;
    }
}
