package comp3074.flow;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RouteRepository {

    private RouteDao routeDao;
    private LiveData<List<Route>> allRoute;

    RouteRepository(Application application){
        RouteRoomDatabase db = RouteRoomDatabase.getDatabase(application);
        routeDao = db.routeDao();
        allRoute = routeDao.getAll();
    }

    LiveData<List<Route>> getAllRoute(){ return allRoute; }

    LiveData<Route> getRoute(String title){ return routeDao.getRoute(title);}

    void insert(Route route){
        new InsertAsyc(routeDao).execute(route);
    }

    void deleteRoute(String route) { new DeleteAsyc(routeDao).execute(route);}

    void update(Route route){ new UpdateAsyc(routeDao).execute(route);}

//    void update(String title, String start, String end, int rate, String time, String tags) { new UpdateAsyc(routeDao).execute(route);}

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
    private static class DeleteAsyc extends AsyncTask<String, Void, Void> {

        private RouteDao dao;

        DeleteAsyc(RouteDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(String... routes) {
            dao.deleteItem(routes[0]);
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

}
