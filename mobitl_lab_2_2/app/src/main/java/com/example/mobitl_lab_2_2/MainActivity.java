package com.example.mobitl_lab_2_2;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView stockListView;
    private StockAdapter stockAdapter;
    private Button buttonAdd;
    private EditText stockName;
    private EditText stockId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.button_add_stock);
        stockId = findViewById(R.id.editText_stock_id);
        stockName = findViewById(R.id.editText_stock_name);

        stockListView =findViewById(R.id.listView_stocks);
        final ArrayList<Stock> stocksList = new ArrayList<>();
        Stock stock = new Stock("Apple", "AAPL");
        stock.getPriceFromApi();
        SystemClock.sleep(1000);
        stocksList.add(stock);
        stock = new Stock("Google", "GOOGL");
        stock.getPriceFromApi();
        SystemClock.sleep(1000);
        stocksList.add(stock);
        stock = new Stock("Facebook", "FB");
        stock.getPriceFromApi();
        SystemClock.sleep(1000);
        stocksList.add(stock);
        stock = new Stock("Nokia", "NOK");
        stock.getPriceFromApi();
        SystemClock.sleep(1000);
        stocksList.add(stock);

        stockAdapter = new StockAdapter(this, stocksList);
        stockListView.setAdapter(stockAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stock newStock = new Stock(stockName.getText().toString(), stockId.getText().toString());
                newStock.getPriceFromApi();
                SystemClock.sleep(1000);
                stocksList.add(newStock);
                stockAdapter = new StockAdapter(MainActivity.this, stocksList);
                stockListView.setAdapter(stockAdapter);

            }
        });
    }
}
