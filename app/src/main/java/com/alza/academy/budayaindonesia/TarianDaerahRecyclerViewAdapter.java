package com.alza.academy.budayaindonesia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.alza.academy.budayaindonesia.model.TarianDaerah;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ewin on 16/12/17.
 */

public class TarianDaerahRecyclerViewAdapter extends RecyclerView.Adapter<TarianDaerahRecyclerViewAdapter.ViewHolder>
    implements Filterable{

    private final TarianDaerahListActivity mParentActivity;
    private TarianDaerahFilter filter;
    private final List<TarianDaerah> tarianDaerahList;
    private List<TarianDaerah> tarianDaerahListFiltered;
    private final boolean mTwoPane;

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TarianDaerah item = (TarianDaerah) view.getTag();
            if (mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(TarianDaerahDetailFragment.JUDUL_TARIAN, item.getJudulTarian());
                TarianDaerahDetailFragment fragment = new TarianDaerahDetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.tariandaerah_detail_container, fragment)
                        .commit();
            } else {
                Context context = view.getContext();
                Intent intent = new Intent(context, TarianDaerahDetailActivity.class);
                intent.putExtra(TarianDaerahDetailFragment.JUDUL_TARIAN, item.getJudulTarian());

                context.startActivity(intent);
            }
        }
    };

    TarianDaerahRecyclerViewAdapter(TarianDaerahListActivity parent,
                                    List<TarianDaerah> items,
                                    boolean twoPane) {
        tarianDaerahList = items;
        tarianDaerahListFiltered = items;
        mParentActivity = parent;
        mTwoPane = twoPane;
        getFilter();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tariandaerah_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mIdView.setText(tarianDaerahListFiltered.get(position).getJudulTarian());
        holder.mContentView.setText(tarianDaerahListFiltered.get(position).getDaerahAsal());

        holder.itemView.setTag(tarianDaerahListFiltered.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return tarianDaerahListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new TarianDaerahFilter();
        }
        return filter;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mIdView;
        final TextView mContentView;

        ViewHolder(View view) {
            super(view);
            mIdView = (TextView) view.findViewById(R.id.id_text);
            mContentView = (TextView) view.findViewById(R.id.content);
        }
    }

    class TarianDaerahFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint!=null && constraint.length()>0) {
                ArrayList<TarianDaerah> tempList = new ArrayList<TarianDaerah>();

                // search content in friend list
                for (TarianDaerah tarianDaerah : tarianDaerahList) {
                    if (tarianDaerah.getJudulTarian().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(tarianDaerah);
                    } else if (tarianDaerah.getDaerahAsal().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(tarianDaerah);
                    }
                }

                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = tarianDaerahList.size();
                filterResults.values = tarianDaerahList;
            }

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            tarianDaerahListFiltered = (ArrayList<TarianDaerah>) filterResults.values;
            notifyDataSetChanged();
        }
    }

}
