package ru.mertech.sbpskb.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import ru.mertech.sbpskb.R;

public final class MyArrayAdapter extends ArrayAdapter<String> {
    private final List<String> mListData;

    private OnItemSelectedListener onItemSelectedListener;

    public MyArrayAdapter(Context paramContext, int paramInt) {
        super(paramContext, paramInt);

        this.mListData = new ArrayList<>();
    }

    public void setClickListener(OnItemSelectedListener itemClickListener) {
        this.onItemSelectedListener = itemClickListener;
    }

    public int getCount() {
        return this.mListData.size();
    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (charSequence != null) {
                    filterResults.values = MyArrayAdapter.this.mListData;
                    filterResults.count = MyArrayAdapter.this.mListData.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                if (filterResults != null && filterResults.count > 0) {
                    MyArrayAdapter.this.notifyDataSetChanged();
                } else {
                    MyArrayAdapter.this.notifyDataSetInvalidated();
                }
            }
        };
    }

    public String getItem(int paramInt) {
        return this.mListData.get(paramInt);
    }

    public View getView(int position, View view, ViewGroup parent) {

//        TextView textView1 =  view.findViewById(R.id.nameTvOrgList);
//
//        TextView textView2 =  view.findViewById(R.id.cityTvOrgList);
//
//        TextView textView3 =  view.findViewById(R.id.innTvOrgList);
//
//        TextView textView4 =  view.findViewById(R.id.ogrnTvOrgList);
        List<CharSequence> list = Arrays.asList(mListData.get(position).split(";", 6));

//        textView1.setText(list.get(0));
//
//        textView2.setText(list.get(1));
//
//        textView3.setText(getContext().getString(R.string.inn, list.get(2)));
//
//        textView4.setText(getContext().getString(R.string.ogrn, list.get(3)));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemSelectedListener.onItemSelected(view,0);

            }
        });

        return super.getView(position, view, parent);
    }

    public final void setData(Collection<String> paramCollection) {
        mListData.clear();
        mListData.addAll(paramCollection);
    }

     interface OnItemSelectedListener {
        void onItemSelected(View view, int position);

    }

}

