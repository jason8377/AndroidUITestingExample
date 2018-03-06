package org.jandjzone.android.uitestingexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.jandjzone.android.uitestingexample.modules.ItemFragment;
import org.jandjzone.android.uitestingexample.modules.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        //Move app to background when user hit back button.
        moveTaskToBack(true);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item){
        Toast.makeText(this, item.content, Toast.LENGTH_SHORT).show();
    }
}
