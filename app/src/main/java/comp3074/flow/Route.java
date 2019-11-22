package comp3074.flow;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;


 @Entity(tableName = "routes", indices = {@Index(value = {"id"})})
    public class Route {
     @PrimaryKey(autoGenerate = true)
     @NonNull
     @ColumnInfo(name = "id")
     public int id;
     @ColumnInfo(name= "Title")
     public String title;
     @ColumnInfo(name = "Start")
     public String start;
     @ColumnInfo(name = "End")
     public String end;
     @ColumnInfo(name = "Rate")
     public int rate;
     @ColumnInfo(name = "Time")
     public String time;
     @ColumnInfo(name = "Tags")
     public String tags;

    public Route(String start, String end, int rate, String title, String time, String tags) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.rate = rate;
        this.title = title;
        this.time = time;
        this.tags = tags;
    }
    @Ignore
    public Route(int rate, String title, String tags){
        this.rate = rate;
        this.title = title;
        this.tags = tags;
    }

     public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
 }

