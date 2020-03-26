package vn.huy.thcustomlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class ListNVAdapter extends BaseAdapter {

    private Context context;
    private List<NhanVien> listNV;

    public ListNVAdapter(Context context, List<NhanVien> listNV) {
        this.context = context;
        this.listNV = listNV;
    }

    @Override
    public int getCount() {
        return listNV.size();
    }

    @Override
    public Object getItem(int position) {
        return listNV.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.custom_item_nv, parent, false);

        TextView txtTT = convertView.findViewById(R.id.txtThongTin);
        CheckBox checkBoxDel = convertView.findViewById(R.id.checkboxDel);
        ImageView imgGT = convertView.findViewById(R.id.imageGT);
        final NhanVien nhanVien = listNV.get(position);
        nhanVien.setDel(false);

        if(nhanVien.isFemale()){
            imgGT.setImageResource(R.mipmap.female);
        }else {
            imgGT.setImageResource(R.mipmap.male);
        }
        txtTT.setText(nhanVien.getMa() + "-" + nhanVien.getTen());
        checkBoxDel.setChecked(false);
        checkBoxDel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    nhanVien.setDel(true);
                }else {
                    nhanVien.setDel(false);
                }
            }
        });


        return convertView;
    }
}
