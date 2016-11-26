package com.touristadev.tourista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class TemporaryActivity extends AppCompatActivity {

    MaterialSearchView searchView;
    List<String> suggestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

            }
        });
//        searchView.setSuggestions();
        suggestions = new ArrayList<>();
        suggestions.add("Justine");
        suggestions.add("Yrvin");
        suggestions.add("Boholst");
        suggestions.add("Blessy");
        suggestions.add("Margarette");
        suggestions.add("Victorillo");
        suggestions.add("Idunoo");
        suggestions.add("Christian");
        suggestions.add("Ferolino");
        suggestions.add("Rey");
        suggestions.add("Shanyl");
        suggestions.add("Jimenez");
        suggestions.add("Nicholas");
        suggestions.add("Chiong");
        String[] suggests = new String[suggestions.size()];
        suggestions.toArray(suggests);
        searchView.setSuggestions(suggests);
        searchView.setCursorDrawable(R.drawable.custom_cursor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
