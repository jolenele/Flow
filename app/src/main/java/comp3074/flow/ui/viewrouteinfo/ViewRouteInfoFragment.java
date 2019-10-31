package comp3074.flow.ui.viewrouteinfo;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comp3074.flow.R;

public class ViewRouteInfoFragment extends Fragment {

    private ViewRouteInfoViewModel mViewModel;

    public static ViewRouteInfoFragment newInstance() {
        return new ViewRouteInfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_route_info_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ViewRouteInfoViewModel.class);
        // TODO: Use the ViewModel
    }

}
