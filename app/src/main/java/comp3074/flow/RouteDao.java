package comp3074.flow;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface RouteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Route route);

    @Query("DELETE FROM routes")
    void deleteAll();

    @Query("DELETE FROM routes WHERE title = :title")
    void deleteItem(String title);

    @Query("SELECT * FROM routes ORDER BY title ASC")
    LiveData<List<Route>> getAll();

    @Query("SELECT * FROM routes WHERE title = :title")
    LiveData<Route> getRoute(String title);

}
