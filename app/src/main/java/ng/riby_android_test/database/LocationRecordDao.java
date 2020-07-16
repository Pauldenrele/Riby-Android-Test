package ng.riby_android_test.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface LocationRecordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveRecord(LocationEntity locationEntity);

    @Query("SELECT * FROM LocationEntity ORDER BY id DESC LIMIT 1")
    LiveData<LocationEntity> getLocationData();
}
