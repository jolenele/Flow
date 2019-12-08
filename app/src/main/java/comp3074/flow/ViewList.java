package comp3074.flow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class ViewList extends FragmentActivity implements
        RoutesFragment.OnListFragmentInteractionListener {

    private ImageButton home, btnSearch;
    private Button newTracking;
    private EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        // Views
        home = findViewById(R.id.btnHome);
        search = findViewById(R.id.search_bar);
        btnSearch = findViewById(R.id.btnSearch);
        newTracking = findViewById(R.id.btnNew);

        // Set adapter
//        adapter = new MyRoutesRecyclerViewAdapter();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewList.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        newTracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewList.this, MapsActivity.class);
                startActivity(intent);
            }
        });

//        search.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                adapter.getFilter().filters(s.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
    }

//    @Override
//    protected void onResume() {
//        // TODO Auto-generated method stub
//        super.onResume();
//
//        adapter1 = new MyAdapter(MainActivity.this, mProductArrayList);
//        lvProducts.setAdapter(adapter1);
//    }

    @Override
    public void onListFragmentInteraction(Route route) {
        Toast.makeText(this,"Selected: " + route.getTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ViewList.this, ViewDetails.class);
        intent.putExtra("Route", route.id);
        startActivity(intent);

    }

}
