package ng.riby_android_test.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import ng.riby_android_test.database.AppDatabase;
import ng.riby_android_test.database.LocationEntity;
import ng.riby_android_test.database.LocationRecordDao;


public class LocalDataRepository{
    private LocationRecordDao locationRecordDao;
    private LiveData<LocationEntity> currentLocationDetails;

    public LocalDataRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        locationRecordDao = db.locationRecordDao();
        currentLocationDetails = locationRecordDao.getLocationData();

    }


    public void insertLocationEntity(final LocationEntity locationEntity) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                locationRecordDao.saveRecord(locationEntity);
            }
        });
    }



    public LiveData<LocationEntity> getLocationEntity() {
        return currentLocationDetails;
    }
}
