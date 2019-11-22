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

//    @Query("DELETE FROM SQLITE_SEQUENCE where name='routes'")
//    void deleteSequence();


    @Query("DELETE FROM routes WHERE id = :id")
    void deleteItem(int id);

    @Query("SELECT * FROM routes ORDER BY id ASC")
    LiveData<List<Route>> getAll();

    @Query("SELECT * FROM routes WHERE id = :id")
    LiveData<Route> getRoute(int id);

//    @Query("UPDATE routes SET title=:title, start=:start, `End`=:end, rate=:rate, time=:time, tags=:tags WHERE title=:title")
//    void update(String title, String start, String end, int rate, String time, String tags);

    @Update
    void update(Route route);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertLocation(Location location);

    @Query("DELETE FROM locations WHERE id = :id")
    void delete(int id);

    @Query("SELECT * FROM locations ORDER BY id ASC")
    LiveData<List<Location>> getAllLocation();

    @Query("SELECT * FROM locations WHERE id = :id")
    LiveData<Location> getLocation(int id);
}
