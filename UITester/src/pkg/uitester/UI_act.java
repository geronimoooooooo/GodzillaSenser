package pkg.uitester;


import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Build;

public class UI_act extends Activity {

	private ListView mListView;
	private ArrayAdapter<String> mArray;
	private Button b2= null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_act);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}		
		
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ui_act, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_ui_act,
					container, false);
			return rootView;
		}
	}

	public void createItem(View v){
//		Toast.makeText(getApplicationContext(), "This is button createItem", Toast.LENGTH_SHORT).show();
		
		mListView = (ListView)findViewById(R.id.listView1);
		mArray = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
				
		mArray.add("item1");
		mArray.add("item2");
		mArray.addAll("item3","item4");
		mListView.setAdapter(mArray);
		
		b2 = (Button)findViewById(R.id.button2);
		b2.setTag("fuuu Bli$$ard");	
		Person p = new Person();
		p.name="aaaa";
		p.number=100000;
		b2.setTag(R.string.setTag_button2, p);
		
		
		//b2.setTag("thisis B2");
	}
	
	public void loadUIHelper(View v){
		Intent intent = new Intent(this, UILayoutHelper.class);
		Person p = (Person)v.getTag(R.string.setTag_button2);
		
		Toast.makeText(getApplicationContext(), (String)v.getTag()+p.name, Toast.LENGTH_LONG).show();
		startActivity(intent);
	}
}


