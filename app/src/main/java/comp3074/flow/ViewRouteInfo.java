package comp3074.flow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import comp3074.flow.ui.viewrouteinfo.ViewRouteInfoFragment;

public class ViewRouteInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_route_info_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ViewRouteInfoFragment.newInstance())
                    .commitNow();
        }
    }
}
