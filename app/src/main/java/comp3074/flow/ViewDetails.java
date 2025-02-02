package comp3074.flow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.Observer;

public class ViewDetails extends AppCompatActivity {

    private ImageButton home;
    private Button save, delete;
//    private TextView start, end, title, tags, time;
    private RatingBar rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        final Intent intent = new Intent(ViewDetails.this, ViewList.class);

        home = findViewById(R.id.btnHome);
        save = findViewById(R.id.btnSave);
        delete = findViewById(R.id.btnDelete);

        final TextView start = findViewById(R.id.txtStart);
        final TextView end = findViewById(R.id.txtEnd);
        final TextView title = findViewById(R.id.txtTitle);
        final TextView tags = findViewById(R.id.txtTags);
        final TextView time = findViewById(R.id.txtTime);

        final RatingBar rate = findViewById(R.id.ratingBarUpdate);

        final RouteViewModel routeViewModel = new ViewModelProvider(this).get(RouteViewModel.class);
        final int routeId = getIntent().getIntExtra("Route", 0);

        routeViewModel.getRouteLive(routeId).observe(this, new Observer<Route>() {
            @Override
            public void onChanged(Route route) {
                start.setText(route.getStart());
                end.setText(route.getEnd());
                title.setText(route.getTitle());
                tags.setText(route.getTags());
                time.setText(route.getTime());
                rate.setRating(route.getRate());
                System.out.println("test xem co start k: "+route.getStart());
                System.out.println(route.toString());
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewDetails.this, ViewList.class);
                startActivity(intent);
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                routeViewModel.update(new Route(routeId, start.getText().toString(),
                        end.getText().toString(), rate.getNumStars(), title.getText().toString(),
                        time.getText().toString(),tags.getText().toString()));
                Toast.makeText(ViewDetails.this, R.string.able_to_update, Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                routeViewModel.delete(routeId);
                Toast.makeText(v.getContext(), "Deleted " + routeId, Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish();
            }
        });


    }
}
