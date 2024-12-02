package com.example.shoppinglist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private final Context context;
    private final List<Product> dataList;

    public CustomAdapter(Context context, List<Product> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_layout, viewGroup, false);
        }
        TextView productNameText = view.findViewById(R.id.productNameText);
        TextView productAmountText = view.findViewById(R.id.productAmountText);

        String name = dataList.get(i).getName();
        int amount = dataList.get(i).getAmount();

        productNameText.setText(name);
        productAmountText.setText(String.valueOf(amount));

        view.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("amount", String.valueOf(amount));
            context.startActivity(intent);
        });

        return view;
    }
}
