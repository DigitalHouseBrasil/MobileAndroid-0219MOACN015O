package com.example.googlemapsprojeto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap map;
    public static int REQUEST_LOCATION_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //ADCIONA UM MARCADOR ATRAVÉS DE CODIGO

        // LatLng moema = new LatLng(-23.6020717, -46.6763941);
        // float zoom = 5f;
        // map.addMarker(new MarkerOptions().position(moema).title("Meu bairro =D"));
        // map.moveCamera(CameraUpdateFactory.newLatLng(moema));
        // map.moveCamera(CameraUpdateFactory.newLatLngZoom(moema, zoom));

        //ADCIONA UM MARCADOR ATRAVÉS DE UM CLIQUE LONGO NO MAPA
        //  adicionaUmMarcadorComCliqueLongo(map);

        //ADICIONA UM PONTO DE INTERESSE
        adicionaUmPontoInteresse(map);

        //EXIBE A LOCALIZAÇAO ATUAL
        habilitaExibicaoLocalizacao();
    }

    //Metodo que adiciona um marcador com clique longo
    private void adicionaUmMarcadorComCliqueLongo(final GoogleMap map) {
        map.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {

                String tituloMarcador = String.format(
                        Locale.getDefault(),
                        "Bairro Moema Jess",
                        latLng.latitude,
                        latLng.longitude
                );

                map.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(getString(R.string.dropped_pin))
                        .snippet(tituloMarcador));
            }
        });
    }

    //Metodo que adiciona um ponto de interesse com titulo
    private void adicionaUmPontoInteresse(final GoogleMap map) {
        map.setOnPoiClickListener(new GoogleMap.OnPoiClickListener() {
            @Override
            public void onPoiClick(PointOfInterest pointOfInterest) {

                Marker pontoInteresse = map.addMarker(new MarkerOptions()
                        .position(pointOfInterest.latLng)
                        .title(pointOfInterest.name));

                pontoInteresse.showInfoWindow();
            }
        });
    }

    //Verifica se o usuario concedeu permissao de localizaçao
    private boolean verificaPermissao() {
        return ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    //Habilita o mapa de mostrar a localizaçao atual
    private void habilitaExibicaoLocalizacao() {
        if (verificaPermissao()) {
            map.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION
            );
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.normal_map) {
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        } else if (id == R.id.hybrid_map) {
            map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        } else if (id == R.id.satellite_map) {
            map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        } else if (id == R.id.terrain_map) {
            map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        }

        return super.onOptionsItemSelected(item);
    }
}
