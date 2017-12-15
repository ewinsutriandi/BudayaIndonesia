package com.alza.academy.budayaindonesia;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alza.academy.budayaindonesia.dummy.TarianContent;
import com.alza.academy.budayaindonesia.model.TarianDaerah;

/**
 * A fragment representing a single TarianDaerah detail screen.
 * This fragment is either contained in a {@link TarianDaerahListActivity}
 * in two-pane mode (on tablets) or a {@link TarianDaerahDetailActivity}
 * on handsets.
 */
public class TarianDaerahDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String JUDUL_TARIAN = "judul_tarian";

    /**
     * The dummy content this fragment is presenting.
     */
    private TarianDaerah mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TarianDaerahDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(JUDUL_TARIAN)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = TarianContent.ITEM_MAP.get(getArguments().getString(JUDUL_TARIAN));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getJudulTarian());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tariandaerah_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.tariandaerah_detail)).setText(mItem.getDeskripsiTarian());
        }

        return rootView;
    }
}
