package comp3074.flow;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Route.class, Location.class}, version = 2, exportSchema = false)

public abstract class RouteRoomDatabase extends RoomDatabase {

    public abstract RouteDao routeDao();
    public abstract LocationDao locationDao();
    private static volatile RouteRoomDatabase INSTANCE = null;

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        public RouteDao routeDao;
        public LocationDao locationDao;

        PopulateDbAsync(RouteRoomDatabase db) {

            this.routeDao = db.routeDao();
            this.locationDao = db.locationDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            routeDao.getAll();
//            locationDao.getAll();
            return null;
        }
    }

    static RouteRoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (RouteRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            RouteRoomDatabase.class,
                            "flow_database"
                    ).addCallback(callback).build();
                }
            }
        }
        return INSTANCE;
    }

}
