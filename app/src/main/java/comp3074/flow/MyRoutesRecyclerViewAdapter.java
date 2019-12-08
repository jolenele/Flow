package comp3074.flow;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import comp3074.flow.RoutesFragment.OnListFragmentInteractionListener;

import java.util.List;

public class MyRoutesRecyclerViewAdapter extends RecyclerView.Adapter<MyRoutesRecyclerViewAdapter.ViewHolder>{

    private List<Route> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyRoutesRecyclerViewAdapter(OnListFragmentInteractionListener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_routes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(String.valueOf(mValues.get(position).getId()));
        holder.mContentView.setText(mValues.get(position).getTitle());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
//        return mValues.size();
        return mValues!=null?mValues.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Route mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.txtItemNumber);
            mContentView = view.findViewById(R.id.txtContent);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
    void setRoute(List<Route> routes){
        mValues = routes;
        notifyDataSetChanged();
    }

//    @Override
//    public Filter getFilter() {
//        Filter filter = new Filter() {
//
//            @SuppressWarnings("unchecked")
//            @Override
//            protected void publishResults(CharSequence constraint,FilterResults results) {
//
//                mDisplayedValues = (ArrayList<Product>) results.values; // has the filtered values
//                notifyDataSetChanged();  // notifies the data with new filtered values
//            }
//
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
//                ArrayList<Product> FilteredArrList = new ArrayList<Product>();
//
//                if (mOriginalValues == null) {
//                    mOriginalValues = new ArrayList<Product>(mDisplayedValues); // saves the original data in mOriginalValues
//                }
//
//                /********
//                 *
//                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
//                 *  else does the Filtering and returns FilteredArrList(Filtered)
//                 *
//                 ********/
//                if (constraint == null || constraint.length() == 0) {
//
//                    // set the Original result to return
//                    results.count = mOriginalValues.size();
//                    results.values = mOriginalValues;
//                } else {
//                    constraint = constraint.toString().toLowerCase();
//                    for (int i = 0; i < mOriginalValues.size(); i++) {
//                        String data = mOriginalValues.get(i).name;
//                        if (data.toLowerCase().startsWith(constraint.toString())) {
//                            FilteredArrList.add(new Product(mOriginalValues.get(i).name,mOriginalValues.get(i).price));
//                        }
//                    }
//                    // set the Filtered result to return
//                    results.count = FilteredArrList.size();
//                    results.values = FilteredArrList;
//                }
//                return results;
//            }
//        };
//        return filter;
//    }
}
