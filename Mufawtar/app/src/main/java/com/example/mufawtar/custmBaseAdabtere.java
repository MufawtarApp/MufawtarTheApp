package com.example.mufawtar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class custmBaseAdabtere extends BaseAdapter {
    Context contex;
    ArrayList<Invoice>  invoices;
    LayoutInflater inflater;

    public custmBaseAdabtere(Context ctx,ArrayList<Invoice> invoices) {
        this.contex = ctx;
        this.invoices = invoices;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return invoices.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custm_list_viwe,null);
        TextView textView = (TextView) convertView.findViewById(R.id.textviwe);
        ImageView t = (ImageView) convertView.findViewById(R.id.imageIcon);
        textView.setText(invoices.get(position).getDesc());
        t.setImageBitmap(invoices.get(position).getPic());
        return convertView;
    }
}
