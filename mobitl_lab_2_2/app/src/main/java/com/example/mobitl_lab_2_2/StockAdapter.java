package com.example.mobitl_lab_2_2;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;





public class StockAdapter extends ArrayAdapter<Stock> {

    private Context mContext;
    private List<Stock> stocksList = new ArrayList<>();

    public StockAdapter(@NonNull Context context, ArrayList<Stock> list) {
        super(context, 0 , list);
        mContext = context;
        stocksList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        Stock currentStock = stocksList.get(position);

        TextView name = listItem.findViewById(R.id.textView_stock_name);
        name.setText(currentStock.getName());

        TextView price = listItem.findViewById(R.id.textView_stock_price);
        price.setText(currentStock.getPrice() + " USD");

        return listItem;
    }
}
