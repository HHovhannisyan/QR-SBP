package ru.mertech.sbpskb.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import ru.mertech.sbpskb.R;

public class SecurityListAdapter extends ArrayAdapter<String> {

    String[] settingNames;
    int[] switches;
    Context mContext;

    public SecurityListAdapter(Context context, String[] settingNames) {
        super(context, R.layout.listview_item);
        this.settingNames = settingNames;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return settingNames.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SecurityListViewHolder mViewHolder = new SecurityListViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.security_lv_item, parent, false);
            mViewHolder.settingSwitch = (Switch) convertView.findViewById(R.id.switch_id);
            mViewHolder.settingName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (SecurityListAdapter.SecurityListViewHolder) convertView.getTag();
        }

        mViewHolder.settingSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(mContext, "Switch ON", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mViewHolder.settingName.setText(settingNames[position]);

        return convertView;
    }

    static class SecurityListViewHolder {
        Switch settingSwitch;
        TextView settingName;
    }
}
