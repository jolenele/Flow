package comp3074.flow;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RouteRepository {

    private RouteDao routeDao;
    private LiveData<List<Route>> allRoute;
    private LiveData<List<Location>> allLocation;

    RouteRepository(Application application){
        RoomDatabase db = RoomDatabase.getDatabase(application);
        routeDao = db.routeDao();
        allRoute = routeDao.getAll();
        allLocation = routeDao.getAllLocation();
    }

    LiveData<List<Route>> getAllRoute(){ return allRoute; }

    LiveData<Route> getRoute(int id){ return routeDao.getRoute(id);}

    void insertRoute(Route route){
        new InsertAsyc(routeDao).execute(route);
    }

    void deleteRoute(int id) { new DeleteAsyc(routeDao).execute(id);}

    void updateRoute(Route route){ new UpdateAsyc(routeDao).execute(route);}

    private static class InsertAsyc extends AsyncTask<Route, Void, Void> {

        private RouteDao dao;

        InsertAsyc(RouteDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Route... routes) {
            dao.insert(routes[0]);
            return null;
        }
    }
    private static class DeleteAsyc extends AsyncTask<Integer, Void, Void> {

        private RouteDao dao;

        DeleteAsyc(RouteDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            dao.deleteItem(integers[0]);
            return null;
        }
    }
    private static class UpdateAsyc extends AsyncTask<Route, Void, Void>{
        private RouteDao dao;
        UpdateAsyc(RouteDao dao) { this.dao = dao;}
        @Override
        protected Void doInBackground(Route... route) {
            dao.update(route[0]);
            return null;
        }
    }

    LiveData<List<Location>> getAllLocation(){ return allLocation; }

    LiveData<Location> getLocation(int id){ return routeDao.getLocation(id);}

    void insertLocation(Location location){
        new InsertLocationAsyc(routeDao).execute(location);
    }

    void deleteLocation(int id) { new DeleteLocationAsyc(routeDao).execute(id);}

    private static class InsertLocationAsyc extends AsyncTask<Location, Void, Void> {

        private RouteDao dao;

        InsertLocationAsyc(RouteDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Location... locations) {
            dao.insertLocation(locations[0]);
            return null;
        }
    }
    private static class DeleteLocationAsyc extends AsyncTask<Integer, Void, Void> {

        private RouteDao dao;

        DeleteLocationAsyc(RouteDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            dao.deleteLocation(integers[0]);
            return null;
        }
    }

}
