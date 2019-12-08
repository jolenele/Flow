package comp3074.flow;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RouteRepository {

    private RouteDao routeDao;
    private LiveData<List<Route>> allRoute;

    RouteRepository(Application application){
        RoomDatabase db = RoomDatabase.getDatabase(application);
        routeDao = db.routeDao();
        allRoute = routeDao.getAll();
    }

    LiveData<List<Route>> getAllRoute(){ return allRoute; }

    LiveData<Route> getRouteLive(int id){ return routeDao.getRouteLive(id);}

    void insertRoute(Route route){ new InsertAsyc(routeDao).execute(route); }

    void delete(int id) { new DeleteAsyc(routeDao).execute(id);}

    public void deleteAll()  {
        new deleteAllWordsAsyncTask(routeDao).execute();
    }

    void update(Route route){ new UpdateAsyc(routeDao).execute(route);}

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

        DeleteAsyc (RouteDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            dao.deleteTest(integers[0]);
            return null;
        }
    }

    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private RouteDao mAsyncTaskDao;

        deleteAllWordsAsyncTask(RouteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    private static class UpdateAsyc extends AsyncTask<Route, Void, Void> {
        private RouteDao mAsyncTaskDao;

        UpdateAsyc(RouteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Route... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }
}
