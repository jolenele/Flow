package comp3074.flow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ViewDetails extends AppCompatActivity {

    private ImageButton home;
    private Button save, delete;
    private TextView start, end, title, tags, time;
    private RatingBar rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        Intent intent = new Intent(ViewDetails.this, ViewList.class);
        startActivity(intent);

        home = findViewById(R.id.btnHome);
        save = findViewById(R.id.btnSave);
        delete = findViewById(R.id.btnDelete);

        start = findViewById(R.id.txtStart);
        end = findViewById(R.id.txtEnd);
        title = findViewById(R.id.txtTitle);
        tags = findViewById(R.id.txtTag);
        time = findViewById(R.id.txtTime);

        rate = findViewById(R.id.ratingBarUpdate);

        final String routeName = getIntent().getStringExtra("Route");

        title.setText(routeName);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewDetails.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewDetails.this, ViewList.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouteViewModel routeViewModel = new ViewModelProvider(ViewDetails.this).get(RouteViewModel.class);
                routeViewModel.deleteRoute(title.getText().toString());
                Toast.makeText(v.getContext(),"Deleted "+ routeName, Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish();
            }
        });
    }
}
