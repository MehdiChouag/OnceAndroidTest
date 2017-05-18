package com.once.android.testandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.once.android.testandroid.adapters.ItemsAdapter;
import com.once.android.testandroid.datamodel.RequestModel;
import java.util.List;
import javax.inject.Inject;

/**
 * Main screen with the ui for the test.
 * <p/>
 * Fill in the recycler view with data coming from:
 * https://api.myjson.com/bins/2hjg2
 */
public class MainActivity extends AppCompatActivity implements MainView {

  @Inject ItemsAdapter mItemsAdapter;
  @Inject MainPresenter presenter;

  private RecyclerView mRecyclerViewToFill;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    inject();

    presenter.setView(this);
    presenter.start();
    setupRecyclerView();
  }

  private void inject() {
    OnceApplication.get(getApplicationContext()).getApplicationComponent().inject(this);
  }

  private void setupRecyclerView() {
    mRecyclerViewToFill = (RecyclerView) findViewById(R.id.mRecyclerViewToFill);
    mRecyclerViewToFill.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerViewToFill.setAdapter(mItemsAdapter);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.stop();
  }

  @Override public void displayList(List<RequestModel> models) {

  }

  @Override public void displayError(String error) {
    Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
  }
}
