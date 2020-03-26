package vn.huy.thcustomlistview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {

    List<NhanVien> listNV;
    ListView listViewNV;
    EditText edtMa, edtTen;
    RadioButton radioNu, radioNam;
    Button btnNhap;
    ImageButton btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewNV = findViewById(R.id.listViewNV);
        edtMa = findViewById(R.id.edtMaNV);
        edtTen = findViewById(R.id.edtTenNV);
        radioNu = findViewById(R.id.radioNu);
        radioNam = findViewById(R.id.radioNam);
        btnNhap = findViewById(R.id.btnNhap);
        btnRemove = findViewById(R.id.btnRemove);

        listNV = new ArrayList<>();
        final ListNVAdapter adapter = new ListNVAdapter(this, listNV);
        listViewNV.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nhanVien = new NhanVien(edtMa.getText().toString(), edtTen.getText().toString(), radioNu.isChecked());
                listNV.add(nhanVien);
                adapter.notifyDataSetChanged();
                edtMa.setText("");
                edtTen.setText("");
                radioNu.setChecked(true);
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                for(int i = listNV.size()-1; i >= 0; i--){
                    if(listNV.get(i).isDel()){
                        listNV.remove(i);
                    }
                }

//                for (NhanVien nhanVien : listNV) {
//                    if (nhanVien.isDel()) {
//                        listNV.remove(nhanVien);
//                    }
//                }
                adapter.notifyDataSetChanged();
            }
        });

        listViewNV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ChiTietActivity.class);
                intent.putExtra("nv", listNV.get(position));
                startActivity(intent);
            }
        });

    }
}
