package jkas.datagridviewsample;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.elevation.SurfaceColors;
import java.util.ArrayList;
import java.util.List;
import jkas.datagridview.DataGridView;
import jkas.datagridview.Row;
import jkas.datagridviewsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        {
            // first you need to predefine your default settings for the grid
            DataGridView.DefaultSetting defSetting = binding.dataGridView.getDefaultSetting();
            defSetting.usePattern = true;
            defSetting.addColorInListColumn(SurfaceColors.SURFACE_0.getColor(this));
            defSetting.addColorInListColumn(SurfaceColors.SURFACE_4.getColor(this));
            defSetting.columnCount = 5; // or list.size() for your cellCounter
            // defSetting.@attr = values

            // depending on the size (maximum number) of your columns, create a data list
            // For example
            String[] dataRowHeader =
                    new String[] {"Identification", "Name", "Home address", "Phone number", "Email"};
            String[] dataRow1 = new String[] {"cell1", "cell2", "cell3", "cell4", "cell5"};
            String[] dataRow2 = new String[] {"cell1", "cell2", "cell3", "cell4", "cell5"};
            String[] dataRow3 = new String[] {"cell1", "cell2", "cell3", "cell4", "cell5"};
            
            // This list represents the data that will be in the grid.
            List<String[]> listDATA = new ArrayList<>();
            listDATA.add(dataRow1);
            listDATA.add(dataRow2);
            listDATA.add(dataRow3);

            // adding header
            Row rowHeader =
                    binding.dataGridView.getRowHeader(); // new Row for Header will be created
            for (String dataCell : dataRowHeader) { // add column
                rowHeader.addCell(rowHeader.newCell().setTextContent(dataCell));
            } // after add cell in this new row
            binding.dataGridView.setHeader(rowHeader); // set the new header to the DataGridView

            // adding data to grid.
            for (String[] dataRow : listDATA) { // loop for row
                Row row = binding.dataGridView.newRow(); // create new Row
                for (String dataCell : dataRow) { // loop to add cell in current row
                    row.addCell(row.newCell().setTextContent(dataCell));
                }
                binding.dataGridView.addRow(row);
            }
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
            DataGridView.DefaultSetting defSetting = binding.dataGridView2.getDefaultSetting();
            defSetting.usePattern = true;
            defSetting.addColorInListColumn(SurfaceColors.SURFACE_0.getColor(this));
            defSetting.addColorInListColumn(SurfaceColors.SURFACE_4.getColor(this));
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
