package ru.mertech.sbpskb.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import ru.mertech.sbpskb.R;

public class SettingsListAdapter extends ArrayAdapter<String> {

    String[] settingNames;
    int[] icons;
    Context mContext;

    public SettingsListAdapter(Context context, String[] settingNames, int[] icons) {
        super(context, R.layout.listview_item);
        this.settingNames = settingNames;
        this.icons = icons;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return settingNames.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.settingIcon = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.settingName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.settingIcon.setImageResource(icons[position]);
        mViewHolder.settingName.setText(settingNames[position]);

        return convertView;
    }

    static class ViewHolder {
        ImageView settingIcon;
        TextView settingName;
    }
}
