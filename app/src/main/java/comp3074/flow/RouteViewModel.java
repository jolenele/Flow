package comp3074.flow;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RouteViewModel extends AndroidViewModel {

    private RouteRepository repository;

    private LiveData<List<Route>> allRoutes;


    public RouteViewModel(@NonNull Application application) {
        super(application);
        repository = new RouteRepository(application);
        allRoutes = repository.getAllRoute();
    }
    public LiveData<List<Route>> getAllRoutes(){
        return allRoutes;
    }
    public LiveData<Route> getRouteLive(int id){
        return repository.getRouteLive(id);
    }

    public void insert(Route route){
        repository.insertRoute(route);
    }
    public void delete(int id) { repository.delete(id); }
    public void deleteAll() { repository.deleteAll(); }
    public void update(Route route) { repository.update(route);}


}
