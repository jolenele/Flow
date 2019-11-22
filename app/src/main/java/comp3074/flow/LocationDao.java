package comp3074.flow;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRoute(Route route);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertLocation(Location location);

    @Query("DELETE FROM locations")
    void deleteAll();

    @Query("DELETE FROM locations WHERE id = :id")
    void delete(int id);

    @Query("SELECT * FROM locations ORDER BY id ASC")
    LiveData<List<Location>> getAll();

    @Query("SELECT * FROM locations WHERE id = :id")
    LiveData<Location> getLocation(int id);

//    @Query("UPDATE routes SET title=:title, start=:start, `End`=:end, rate=:rate, time=:time, tags=:tags WHERE title=:title")
//    void update(String title, String start, String end, int rate, String time, String tags);

//    @Update
//    void update(Route route);
}
