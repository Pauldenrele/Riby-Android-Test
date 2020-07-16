package ng.riby_android_test;

import androidx.room.TypeConverter;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class AppDbTypeConverter {
    @TypeConverter
    public static List<LatLng> stringToLatLngs(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<LatLng>>() {}.getType();
        List<LatLng> latLngs = gson.fromJson(json, type);
        return latLngs;
    }

    @TypeConverter
    public static String latLngsToString(List<LatLng> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<LatLng>>() {}.getType();
        String json = gson.toJson(list, type);
        return json;
    }


    @TypeConverter
    public static List<Marker> stringToMarkers(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Marker>>() {}.getType();
        List<Marker> markers = gson.fromJson(json, type);
        return markers;
    }

    @TypeConverter
    public static String markersToString(List<Marker> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Marker>>() {}.getType();
        String json = gson.toJson(list, type);
        return json;
    }


}
