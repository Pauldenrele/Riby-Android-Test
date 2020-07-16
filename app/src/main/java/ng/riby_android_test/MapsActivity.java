package ng.riby_android_test;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

import ng.riby_android_test.database.LocationEntity;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapViewModel viewModel;
    Polyline polyline = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        viewModel = ViewModelProviders.of(this).get(MapViewModel.class);


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        viewModel.getCurrentLocationDetail().observe(this, new Observer<LocationEntity>() {
            @Override
            public void onChanged(LocationEntity locationEntity) {
                if (locationEntity != null && locationEntity.latLngs.size() > 0) {
                    if (polyline != null) polyline.remove();
                    PolylineOptions polylineOptions = new PolylineOptions()
                            .addAll(locationEntity.latLngs).color(Color.RED);
                    polyline = mMap.addPolyline(polylineOptions);
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locationEntity.latLngs.get(0), 15f));
                }
            }
        });
    }
}