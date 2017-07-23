package io.github.gianpamx.mamadigital.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.gianpamx.mamadigital.R;

public class ScreenSlidePageFragment extends Fragment {


    public static final String IMAGE = "image";
    public static final String TITLE = "title";
    public static final String SUBTITLE = "subtitle";

    public static ScreenSlidePageFragment newInstance(String titles, String subtitles, Integer images) {
        
        Bundle args = new Bundle();
        args.putString(TITLE, titles);
        args.putString(SUBTITLE, subtitles);
        args.putInt(IMAGE, images);
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    public ScreenSlidePageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_category, container, false);;

        TextView title = view.findViewById(R.id.title);
        TextView subtitle = view.findViewById(R.id.subtitle);
        ImageView image = view.findViewById(R.id.image);

        title.setText(getArguments().getString(TITLE));
        subtitle.setText(getArguments().getString(SUBTITLE));
        image.setImageResource(getArguments().getInt(IMAGE));




        return view;
    }
}
