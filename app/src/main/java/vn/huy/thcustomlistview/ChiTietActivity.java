package vn.huy.thcustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class ChiTietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        Intent intent = getIntent();
        NhanVien nv = (NhanVien) intent.getSerializableExtra("nv");

        TextView txtTT = findViewById(R.id.txtChiTiet);
        txtTT.setText(nv.getMa() + " - " + nv.getTen() + " - " + (nv.isFemale() ? "Nam" : "Nữ"));

    }
}
