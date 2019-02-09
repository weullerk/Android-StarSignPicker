package com.alienonwork.starsignpicker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class StarSignPicker extends AppCompatActivity {

    public static final String EXTRA_SIGN_NAME = "SIGN_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_sign_picker);
        StarSignPickerAdapter adapter = new StarSignPickerAdapter();

        adapter.setOnAdapterItemClick(new StarSignPickerAdapter.IAdapterItemClick() {
            @Override
            public void onItemClicked(String selectedItem) {
                Intent outData = new Intent();
                outData.putExtra(EXTRA_SIGN_NAME, selectedItem);
                setResult(Activity.RESULT_OK, outData);
                finish();
            }
        });

        RecyclerView rv = findViewById(R.id.recycler_view);
        rv.setAdapter(adapter);
    }
}
