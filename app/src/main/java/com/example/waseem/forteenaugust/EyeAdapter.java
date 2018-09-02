package com.example.waseem.forteenaugust;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;


public class EyeAdapter extends ArrayAdapter<Integer>{

    private Context context;
    private Integer[] hairImage;

    public EyeAdapter(Context context, int resource, Integer[] hairImage) {
        super(context, resource,hairImage);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.hairImage=hairImage;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View v = convertView;
        ViewHolder holder;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.eye_adapter, null);
            holder = new ViewHolder();
            holder.hairImageView =(ImageView) v.findViewById(R.id.hairImageView);


            v.setTag(holder);

        }
        else
            holder=(ViewHolder)v.getTag();

        holder.hairImageView.setBackgroundResource(hairImage[position]);

        return v;
    }

    private class ViewHolder {
        ImageView hairImageView;

    }
}