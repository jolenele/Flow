package comp3074.flow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Tracking extends AppCompatActivity {
    public static final String EXTRA_ITEM = "ca.comp3074.flow.Tracking.EXTRA_ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        Button add = findViewById(R.id.btnFinish);
        TextView title = findViewById(R.id.txtTitle);
        TextView tags = findViewById(R.id.txtTags);
        RatingBar rate = findViewById(R.id.ratingBar);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tracking.this, MapsActivity.class);
                if(TextUtils.isEmpty(title.getText())){
                    setResult(RESULT_CANCELED, intent);
                }else{

                    Route newRoute = new Route((int) rate.getRating(), title.getText().toString(), tags.getText().toString());
                    RouteViewModel routeViewModel = new ViewModelProvider(Tracking.this).get(RouteViewModel.class);
                    routeViewModel.insert(newRoute);
                    intent.putExtra(EXTRA_ITEM, newRoute.getTitle());
                    ((Activity)v.getContext()).setResult(Activity.RESULT_OK,intent);
                }
                finish();
            }
        });

    }
}
