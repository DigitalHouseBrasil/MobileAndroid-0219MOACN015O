package br.digitalhouse.menuscardview.galeria.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import br.digitalhouse.menuscardview.R;
import br.digitalhouse.menuscardview.galeria.adapter.AlbumViewPagerAdapter;
import br.digitalhouse.menuscardview.galeria.model.Album;

/**
 * A simple {@link Fragment} subclass.
 */
public class GaleriaFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AlbumViewPagerAdapter adapter;

    public GaleriaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_galeria, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPagerAlbum);

        adapter = new AlbumViewPagerAdapter(getActivity().getSupportFragmentManager(), listaAlbum());

        viewPager.setAdapter(adapter);

        viewPager.setOffscreenPageLimit(listaAlbum().size());

        tabLayout.setupWithViewPager(viewPager);

    return view;
    }

    private List<Album> listaAlbum(){
        List<Album> listaAlbum = new ArrayList<>();

        listaAlbum.add(new Album("Aerosmith",
                AlbumFragment.newInstance("Aerosmith", R.drawable.aerosmith)));

        listaAlbum.add(new Album("Led",
                AlbumFragment.newInstance("Led", R.drawable.led)));

        listaAlbum.add(new Album("Queen",
                AlbumFragment.newInstance("Queen", R.drawable.queen)));

        return listaAlbum;
    }

}
