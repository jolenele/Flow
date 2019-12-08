package comp3074.flow;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface RouteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Route route);

    @Query("DELETE FROM routes")
    void deleteAll();

    @Query("DELETE FROM routes WHERE id = :id")
    void deleteItem(int id);

    @Query("SELECT * FROM routes ORDER BY id ASC")
    LiveData<List<Route>> getAll();

    @Query("SELECT * FROM routes WHERE id = :id")
    LiveData<Route> getRoute(int id);

//    @Update(onConflict = OnConflictStrategy.IGNORE)
//    void update(Route route);

    @Query("UPDATE routes SET title=:title, time=:time, rate=:rate, tags=:tags WHERE id = :id")
    void updateRoute(int id, String title, String time, int rate, String tags);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertLocation(Location location);

    @Query("DELETE FROM locations WHERE id = :id")
    void deleteLocation(int id);

    @Query("SELECT * FROM locations ORDER BY id ASC")
    LiveData<List<Location>> getAllLocation();

    @Query("SELECT * FROM locations WHERE id = :id")
    LiveData<Location> getLocation(int id);

    @Query("DELETE FROM locations")
    void deleteAllLocations();
}
