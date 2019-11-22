package comp3074.flow;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RouteViewModel extends AndroidViewModel {

    private RouteRepository repository;

    private LiveData<List<Route>> allRoutes;

    private LiveData<List<Location>> allLocations;


    public RouteViewModel(@NonNull Application application) {
        super(application);
        repository = new RouteRepository(application);
        allRoutes = repository.getAllRoute();
        allLocations = repository.getAllLocation();
    }
    public LiveData<List<Route>> getAllRoutes(){
        return allRoutes;
    }
    public LiveData<Route> getRoute(int id){
        return repository.getRoute(id);
    }

    public void insert(Route route){
        repository.insertRoute(route);
    }
    public void deleteRoute(int id) { repository.deleteRoute(id); }
    public void update(Route route) { repository.updateRoute(route);}

    public LiveData<List<Location>> getAllLocations(){
        return allLocations;
    }
    public LiveData<Location> getLocation(int id){
        return repository.getLocation(id);
    }

    public void insertLocation(Location location){
        repository.insertLocation(location);
    }
    public void deleteLocation(int id) { repository.deleteLocation(id); }
//    public void update(Route route) { repository.updateRoute(route);}
}
