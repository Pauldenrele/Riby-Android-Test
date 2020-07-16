package ng.riby_android_test;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import ng.riby_android_test.database.LocationEntity;
import ng.riby_android_test.repository.LocalDataRepository;

public class RecordLocationViewModel extends AndroidViewModel {

    private LocalDataRepository localDataRepository;

    public RecordLocationViewModel(@NonNull Application application) {
        super(application);
        localDataRepository = new LocalDataRepository(application);
    }


    public void insert(LocationEntity locationEntity) {
        localDataRepository.insertLocationEntity(locationEntity);
    }
}
