package mitul.golfy;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ListActivity {
    private static final String PREFS_FILE = "mitul.golfy.preferences";
    private static final String KEY_STROKECOUNT = "key_strokecount";
    private Hole[] holes = new Hole[18];
    private ListAdapter mListAdapter;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        int strokes = 0;
        for (int i = 0; i < holes.length ; i++){
            strokes = mSharedPreferences.getInt(KEY_STROKECOUNT+i,0);
            holes[i] = new Hole("Hole"+(i+1)+" :",strokes);
            System.out.println(holes[i].getLabel());
        }

        mListAdapter = new ListAdapter(getApplicationContext(),holes);
        setListAdapter(mListAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        for (int i =0; i < holes.length; i++) {
            mEditor.putInt(KEY_STROKECOUNT+i,holes[i].getStokeCount() );
        }
        mEditor.apply();
    }
}
