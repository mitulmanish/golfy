package mitul.golfy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mitul on 07/11/15.
 */
public class ListAdapter extends BaseAdapter {

    private final Context mContext;
    private final Hole[] mHoles;

    public ListAdapter(Context context,Hole[] holes){
        this.mContext = context;
        this.mHoles = holes;
    }
    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int position) {
        return mHoles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,null);
            holder = new ViewHolder();
            holder.holeLabel = (TextView) convertView.findViewById(R.id.Holelabel);
            holder.strokeCount = (TextView) convertView.findViewById(R.id.Holescore);
            holder.inc_score = (Button) convertView.findViewById(R.id.add_button);
            holder.dec_score = (Button) convertView.findViewById(R.id.minus_button);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.holeLabel.setText((CharSequence) mHoles[position].getLabel());
        holder.strokeCount.setText(mHoles[position].getStokeCount()+"");
        holder.dec_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.strokeCount.setText(mHoles[position].decrement_score()+"");
            }
        });
        holder.inc_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.strokeCount.setText(mHoles[position].increment_score()+"");
            }
        });

        return convertView;
    }
    public static class ViewHolder {
        TextView holeLabel;
        TextView strokeCount;
        Button inc_score;
        Button dec_score;
    }
}
