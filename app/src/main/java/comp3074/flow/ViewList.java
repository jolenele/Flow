package comp3074.flow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class ViewList extends FragmentActivity implements
        RoutesFragment.OnListFragmentInteractionListener, ViewInfo.OnFragmentInteractionListener {

    private ImageButton home;
    private Button edit, newTracking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        home = findViewById(R.id.btnHome);

        edit = findViewById(R.id.btnEdit);

        newTracking = findViewById(R.id.btnNew);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewList.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewList.this, ViewDetails.class);
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
    }

    @Override
    public void onListFragmentInteraction(Route route) {

        Toast.makeText(this,"Selected: " + route.getTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ViewDetails.class);
        intent.putExtra("Route", route.getTitle());
        startActivity(intent);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
