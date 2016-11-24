package com.touristadev.tourista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.touristadev.tourista.adapters.GridCategoryAdapter;
import com.touristadev.tourista.models.Category;

import java.util.ArrayList;
import java.util.List;

public class ChooseTribeActivity extends AppCompatActivity {

    private GridView mGridView;
    private GridCategoryAdapter mAdapter;
    private List<Category> mCategories;
    private List<Integer> mChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_tribe);

        mCategories = new ArrayList<>();
        mChosen = new ArrayList<>();

        mCategories.add(new Category("M", "Mountain"));
        mCategories.add(new Category("B", "Beach"));
        mCategories.add(new Category("W", "Waterfalls"));
        mCategories.add(new Category("R", "River"));
        mCategories.add(new Category("J", "Justine"));
        mCategories.add(new Category("S", "Shanyl"));
        mCategories.add(new Category("N", "Nick"));
        mCategories.add(new Category("C", "Chan"));

        mGridView = (GridView) findViewById(R.id.gridViewCategory);
        mAdapter = new GridCategoryAdapter(getApplicationContext(), R.layout.category_item, mCategories);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mChosen.contains(position)){

                }else{
                    mChosen.add(position);
                }
            }
        });
    }
}
