package a.a.ola;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by sneha on 8/2/15.
 */
public class ContactAdapter extends ArrayAdapter<String> {

    protected Context mContext;
    protected String[] mname ,mcontNum;

    public ContactAdapter(Context context, String[] name, String[] contNum) {
        super(context,R.layout.contact_list,name);
        mname=name;
        mcontNum =contNum;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.contact_list, null);
            holder = new ViewHolder();
            holder.text1 = (TextView)convertView.findViewById(R.id.contactname);
            holder.text2 = (TextView)convertView.findViewById(R.id.contactnum);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.text1.setText(mname[position]);
        holder.text2.setText(mcontNum[position]);

        return convertView;
    }

    private  class ViewHolder{
        TextView text1;
        TextView text2;

    }
}
