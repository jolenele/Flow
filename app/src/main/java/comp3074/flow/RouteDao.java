package comp3074.flow;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
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

    @Delete
    void deleteRoute(Route route);

    @Query("DELETE FROM routes WHERE id = :id")
    void deleteTest(int id);

    @Query("SELECT * FROM routes ORDER BY id ASC")
    LiveData<List<Route>> getAll();

    @Query("SELECT * FROM routes WHERE id = :id")
    LiveData<Route> getRouteLive(int id);

    @Update
    void update(Route... route);
}
