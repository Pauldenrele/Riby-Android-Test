package ng.riby_android_test;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import ng.riby_android_test.database.LocationEntity;
import ng.riby_android_test.repository.LocalDataRepository;

public class MapViewModel extends AndroidViewModel {

    private LocalDataRepository localDataRepository;
    private LiveData<LocationEntity> currentLocationDetail;

    public MapViewModel(@NonNull Application application) {
        super(application);
        localDataRepository = new LocalDataRepository(application);
        currentLocationDetail = localDataRepository.getLocationEntity();
    }

    LiveData<LocationEntity> getCurrentLocationDetail() {
        return currentLocationDetail;
    }

}
