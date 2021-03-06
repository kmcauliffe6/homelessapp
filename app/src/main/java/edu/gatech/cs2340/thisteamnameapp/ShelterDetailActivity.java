package edu.gatech.cs2340.thisteamnameapp;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

/**
 * An activity representing a single Shelter detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ShelterListActivity}.
 */
@SuppressWarnings("CyclicClassDependency")
public class ShelterDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);
        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);


        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putInt(ShelterDetailFragment.ARG_ITEM_ID,
                    getIntent().getIntExtra(ShelterDetailFragment.ARG_ITEM_ID, 1000));
            ShelterDetailFragment fragment = new ShelterDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.shelter_detail_container, fragment)
                    .commit();
        }
    }

    /**
     * handles item selected
     * @param item item selected
     * @return boolean of optionItemsSelected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, ShelterListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * creates intent to go to the list of shelters
     * @param view current view
     */
    public void goToShelterActivity (View view){
        Intent intent = new Intent (this, ShelterListActivity.class);
        startActivity(intent);
    }
    /**
     * goes to checkout activity
     * @param view current view
     */
    public void goToCheckOutActivity(View view) {
        Intent intent = new Intent (this, CheckOutActivity.class);
        intent.putExtra("id", getIntent().getIntExtra(ShelterDetailFragment.ARG_ITEM_ID, 1000));
        startActivity(intent);
    }
    /**
     * goes to cancel reservation activity
     * @param view current view
     */
    public void goToCancelResActivity(View view) {
        Intent intent = new Intent (this, CancelReservationActivity.class);
        intent.putExtra("id", getIntent().getIntExtra(ShelterDetailFragment.ARG_ITEM_ID, 1000));
        startActivity(intent);
    }

    /**
     * close search view on back button pressed
     *
     */
    @Override
    public void onBackPressed() {
        // close search view on back button pressed
        Intent intent = new Intent(this, ApplicationActivity.class);
        startActivity(intent);
    }

}
