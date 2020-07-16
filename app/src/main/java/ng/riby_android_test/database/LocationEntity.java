package ng.riby_android_test.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import ng.riby_android_test.AppDbTypeConverter;

@Entity
@TypeConverters(AppDbTypeConverter.class)
public class LocationEntity {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "lat_lngs")
    public List<LatLng> latLngs;

    public LocationEntity() {
    }


    public LocationEntity(List<LatLng> list) {
        this.latLngs = list;
    }

    public List<LatLng> getLatLngs() {
        return latLngs;
    }


}
