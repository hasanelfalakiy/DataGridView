package jkas.datagridviewsample;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.elevation.SurfaceColors;
import jkas.datagridview.DataGridView;
import jkas.datagridview.Row;
import jkas.datagridview.Utils;
import jkas.datagridviewsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // For the header of the data grid.
        {
            Row rowHeader = binding.dataGridView.getRowHeader();
            rowHeader.addCell(rowHeader.newCell().setTextContent("Identification"));
            rowHeader.addCell(rowHeader.newCell().setTextContent("Name"));
            rowHeader.addCell(rowHeader.newCell().setTextContent("Home address"));
            rowHeader.addCell(rowHeader.newCell().setTextContent("Phone number"));
            rowHeader.addCell(rowHeader.newCell().setTextContent("Email"));
            binding.dataGridView.setHeader(rowHeader);
        }

        // for basic adding data.
        {
            Row row = binding.dataGridView.newRow();
            row.addCell(row.newCell().setTextContent("4343"));
            row.addCell(row.newCell().setTextContent("JKas DBT"));
            row.addCell(
                    row.newCell().setTextContent("address not provided by the person concerned"));
            row.addCell(row.newCell().setTextContent("+0 000 000 ..."));
            row.addCell(row.newCell().setTextContent("jkas.dbt@gmail.com"));
            binding.dataGridView.addRow(row);
        }
        {
            Row row = binding.dataGridView.newRow();
            row.addCell(row.newCell().setTextContent("4343"));
            row.addCell(row.newCell().setTextContent("JKas DBT"));
            row.addCell(
                    row.newCell().setTextContent("address not provided by the person concerned"));
            row.addCell(row.newCell().setTextContent("+0 000 000 ..."));
            row.addCell(row.newCell().setTextContent("address_address_jkas.dbt@gmail.com"));
            binding.dataGridView.addRow(row);
        }
        {
            Row row = binding.dataGridView.newRow();
            row.addCell(row.newCell().setTextContent("4343"));
            row.addCell(row.newCell().setTextContent("JKas DBT"));
            row.addCell(
                    row.newCell().setTextContent("address not provided by the person concerned"));
            row.addCell(row.newCell().setTextContent("+0 000 000 ..."));
            row.addCell(row.newCell().setTextContent("jkas.dbt@gmail.com"));
            binding.dataGridView.addRow(row);
        }
        {
            Row row = binding.dataGridView.newRow();
            row.addCell(row.newCell().setTextContent("4343"));
            row.addCell(row.newCell().setTextContent("JKas DBT"));
            row.addCell(
                    row.newCell().setTextContent("address not provided by the person concerned"));
            row.addCell(row.newCell().setTextContent("+0 000 000 ..."));
            row.addCell(row.newCell().setTextContent("jkas.dbt@gmail.com"));
            binding.dataGridView.addRow(row);
        }
        {
            Row row = binding.dataGridView.newRow();
            row.addCell(row.newCell().setTextContent("4343"));
            row.addCell(row.newCell().setTextContent("JKas DBT"));
            row.addCell(
                    row.newCell().setTextContent("address not provided by the person concerned"));
            row.addCell(row.newCell().setTextContent("+0 000 000 ..."));
            row.addCell(row.newCell().setTextContent("jkas.dbt@gmail.com"));
            binding.dataGridView.addRow(row);
        }

        {
            Row rowHeader = binding.dataGridView2.getRowHeader();
            rowHeader.addCell(rowHeader.newCell().setTextContent("Identification"));
            rowHeader.addCell(rowHeader.newCell().setTextContent("Name"));
            rowHeader.addCell(rowHeader.newCell().setTextContent("Home address"));
            rowHeader.addCell(rowHeader.newCell().setTextContent("Phone number"));
            rowHeader.addCell(rowHeader.newCell().setTextContent("Email"));
            binding.dataGridView2.setHeader(rowHeader);
            addData(
                    binding.dataGridView2,
                    "0876",
                    "Neo",
                    "adress auto get",
                    "+000 number",
                    "contact@mylocal.net");
            addData(
                    binding.dataGridView2,
                    "0876",
                    "Neo",
                    "adress auto get",
                    "+000 number",
                    "contact@mylocal.net");
            addData(
                    binding.dataGridView2,
                    "0876",
                    "Neo",
                    "adress auto get",
                    "+000 number",
                    "contact@mylocal.net");
            addData(
                    binding.dataGridView2,
                    "0876",
                    "Neo",
                    "adress auto get",
                    "+000 number",
                    "contact@mylocal.net");
            addData(
                    binding.dataGridView2,
                    "0876",
                    "Neo",
                    "adress auto get",
                    "+000 number",
                    "contact@mylocal.net");
        }
        
        
        {
            Row rowHeader = binding.dataGridView3.getRowHeader();
            rowHeader.addCell(rowHeader.newCell().setTextContent("Identification"));
            rowHeader.addCell(rowHeader.newCell().setTextContent("Name"));
            rowHeader.addCell(rowHeader.newCell().setTextContent("Home address"));
            rowHeader.addCell(rowHeader.newCell().setTextContent("Phone number"));
            rowHeader.addCell(rowHeader.newCell().setTextContent("Email"));
            binding.dataGridView3.setHeader(rowHeader);
            addData(
                    binding.dataGridView3,
                    "0876",
                    "Neo",
                    "adress auto get",
                    "+000 number",
                    "contact@mylocal.net");
            addData(
                    binding.dataGridView3,
                    "0876",
                    "Neo",
                    "adress auto get",
                    "+000 number",
                    "contact@mylocal.net");
            addData(
                    binding.dataGridView3,
                    "0876",
                    "Neo",
                    "adress auto get",
                    "+000 number",
                    "contact@mylocal.net");
            addData(
                    binding.dataGridView3,
                    "0876",
                    "Neo",
                    "adress auto get",
                    "+000 number",
                    "contact@mylocal.net");
            addData(
                    binding.dataGridView3,
                    "0876",
                    "Neo",
                    "adress auto get",
                    "+000 number",
                    "contact@mylocal.net");
        }
    }

    private void addData(DataGridView DGV, String... array) {
        Row row = DGV.newRow();
        for (String str : array) row.addCell(row.newCell().setTextContent(str));
        DGV.addRow(row);
    }
}
