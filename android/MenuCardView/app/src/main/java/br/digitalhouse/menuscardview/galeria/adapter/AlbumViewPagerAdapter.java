package br.digitalhouse.menuscardview.galeria.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.List;
import br.digitalhouse.menuscardview.galeria.model.Album;

public class AlbumViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Album> listaAlbum;

    public AlbumViewPagerAdapter(@NonNull FragmentManager fm, List<Album> listaAlbum) {
        super(fm);
        this.listaAlbum = listaAlbum;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaAlbum.get(position).getBanda();
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listaAlbum.get(position).getFragment();
    }
    @Override
    public int getCount() {
        return listaAlbum.size();
    }
}
