package comp3074.flow;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

//@Entity(tableName = "locations")
@Entity(tableName = "locations", foreignKeys = @ForeignKey
        (entity = Route.class, parentColumns = "id", childColumns = "route_id", onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE), indices = @Index(value = "route_id"))
public class Location {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
     public int id;
    @ColumnInfo(name = "route_id")
    public int route_id;
    @ColumnInfo(name= "longitude")
    public float longitude;
    @ColumnInfo(name="latitude")
    public float latitude;
}