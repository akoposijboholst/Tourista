package com.touristadev.tourista.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.touristadev.tourista.R;
import com.touristadev.tourista.models.Category;

import java.util.List;

public class GridCategoryAdapter extends ArrayAdapter<Category> {

    private Context mContext;
    private int mResource;
    private List<Category> mCategories;

    public GridCategoryAdapter(Context context, int resource, List<Category> categories) {
        super(context, resource, categories);

        mContext = context;
        mResource = resource;
        mCategories = categories;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Category category = mCategories.get(position);
        if(category != null){
            viewHolder.tvImage.setText(category.getImage());
            viewHolder.tvName.setText(category.getName());
        }

        return convertView;
    }

    public static class ViewHolder {
        private TextView tvImage;
        private TextView tvName;

        public ViewHolder(View view) {
            tvImage = (TextView) view.findViewById(R.id.tvImage);
            tvName = (TextView) view.findViewById(R.id.tvName);
        }
    }
}
