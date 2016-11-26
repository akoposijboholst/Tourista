package com.touristadev.tourista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.touristadev.tourista.adapters.GridCategoryAdapter;
import com.touristadev.tourista.models.Category;

import java.util.ArrayList;
import java.util.List;

public class ChooseTribeActivity extends AppCompatActivity {

    private GridView mGridView;
    private GridCategoryAdapter mAdapter;
    private List<Category> mCategories;
    private List<Integer> mChosen;
    private TextView mNumber;
    private RelativeLayout mRelative;
    private Button mProceed;

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

        mNumber = (TextView) findViewById(R.id.tvChooseNumber);
        mRelative = (RelativeLayout) findViewById(R.id.relativeLayout);
        mProceed = (Button) findViewById(R.id.btnProceed);
        mProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ChooseTribeActivity.class, BottomNavigationActivity.class);
            }
        });

        mGridView = (GridView) findViewById(R.id.gridViewCategory);
        mAdapter = new GridCategoryAdapter(getApplicationContext(), R.layout.category_item, mCategories);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mChosen.contains(position)) {
                    mChosen.remove(mChosen.indexOf(position));
                    if(mChosen.size() < 3){
                        int lacking = 3 - mChosen.size();
                        mNumber.setText(String.valueOf(lacking));
                    }
                    if(mChosen.size() == 2 && mProceed.getVisibility() == View.VISIBLE){
                        mRelative.setVisibility(View.VISIBLE);
                        mProceed.setVisibility(View.GONE);
                    }
                } else {
                    mChosen.add(position);
                    int lacking = 3 - mChosen.size();
                    if (lacking > -1) {
                        mNumber.setText(String.valueOf(lacking));
                    }
                    if (lacking == 0) {
                        mRelative.setVisibility(View.GONE);
                        mProceed.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
}
