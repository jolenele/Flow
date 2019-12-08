package comp3074.flow;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteDatabase;
@Database(entities = {Route.class}, version = 1, exportSchema = false)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {
    public abstract RouteDao routeDao();

    private static volatile RoomDatabase INSTANCE = null;

    private static androidx.room.RoomDatabase.Callback callback = new androidx.room.RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        public RouteDao routeDao;

        PopulateDbAsync(RoomDatabase db) {

            this.routeDao = db.routeDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            routeDao.getAll();
            return null;
        }
    }

    static RoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            RoomDatabase.class,
                            "flow_database"
                    ).addCallback(callback).build();
                }
            }
        }
        return INSTANCE;
    }
}
