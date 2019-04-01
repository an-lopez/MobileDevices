package com.github.lopezantonio.easypav;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class MenuExpandableListAdapter extends BaseExpandableListAdapter {
    Context context;

    //Groups
    List<Menu> menuList;

    //Childs
    HashMap<Menu, List<Menu>> menuChildList;

    public MenuExpandableListAdapter(Context context, List<Menu> menuList, HashMap<Menu, List<Menu>> menuChildList) {
        this.context = context;
        this.menuList = menuList;
        this.menuChildList = menuChildList;
    }

    @Override
    public int getGroupCount() {
        return menuList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if(menuChildList.get(menuList.get(groupPosition)) == null)
            return 0;
        else
            return menuChildList.get(menuList.get(groupPosition)).size();
    }

    @Override
    public Menu getGroup(int groupPosition) {
        return menuList.get(groupPosition);
    }

    @Override
    public Menu getChild(int groupPosition, int childPosition) {
        return menuChildList.get(menuList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = getGroup(groupPosition).getNombre();
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_group_header, null);
        }
        TextView textView = convertView.findViewById(R.id.tv_list_group);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String headerTitle = getChild(groupPosition, childPosition).getNombre();
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_group_child, null);
        }

        TextView textView = convertView.findViewById(R.id.tv_list_child);
        textView.setText(headerTitle);
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
