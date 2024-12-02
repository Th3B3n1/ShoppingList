package com.example.shoppinglist;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText productNameInput;
    private EditText productAmountInput;

    private CustomAdapter adapter;
    private final List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.productNameInput = findViewById(R.id.productNameInput);
        this.productAmountInput = findViewById(R.id.productAmountInput);
        MaterialButton addItemButton = findViewById(R.id.addItemButton);
        ListView listNode = findViewById(R.id.listNode);
        addItemButton.setOnClickListener(view -> addToListView());
        this.adapter = new CustomAdapter(this, this.products);
        listNode.setAdapter(adapter);
    }

    private void addToListView()
    {
        this.products.add(new Product(String.valueOf(this.productNameInput.getText()), Integer.parseInt(String.valueOf(this.productAmountInput.getText()))));
        this.adapter.notifyDataSetChanged();
    }
}