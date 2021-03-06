package com.ptkreativatechnologisolusindo.profilekreativa.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.ptkreativatechnologisolusindo.profilekreativa.Data.Berita;
import com.ptkreativatechnologisolusindo.profilekreativa.LinkDatabase;
import com.ptkreativatechnologisolusindo.profilekreativa.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterBerita  extends RecyclerView.Adapter<AdapterBerita .ViewHolder> {
//    private static final String TAG = "AdapterBerita";

    private Context context;
    private List<Berita> mData;
    LinkDatabase linkDatabase;
    public static AdapterBerita ma;
    RequestQueue requestQueue;


    public AdapterBerita(Context context, List<Berita> mData ){
        this.context    =   context;
        this.mData      =   mData;
        linkDatabase = new LinkDatabase();
        ma = this;
    }

//
//    private String[] mDataSet,mDataSet2,mDataSet4;
//    private int[] mDataSet3;

//    public AdapterBerita(String[] mDataset, String[] mDataset2, int[] mDataset3) {
//    }
//
//    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
//    /**
//     * Provide a reference to the type of views that you are using (custom ViewHolder)
//     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView gambar;
        public TextView judul_berita, desk_berita, tanggal_berita;
        public ViewHolder( View v) {
            super(v);
            gambar = v.findViewById(R.id.img_berita_logo);
            judul_berita = v.findViewById(R.id.txt_berita_judul);
            desk_berita = v.findViewById(R.id.txt_berita_desk);
            tanggal_berita = v.findViewById(R.id.txt_berita_tgl);


        }

    }

    @Override
    public AdapterBerita.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_berita, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }
//    // END_INCLUDE(recyclerViewOnCreateViewHolder)
//
//    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
//    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AdapterBerita.ViewHolder holder, final int position) {
        final String id = mData.get(position).getID_BERITA();
        final String judul = mData.get(position).getJUDUL_BERITA();
        final String deskripsi = mData.get(position).getDESK_BERITA();
        final String tanggal = mData.get(position).getTANGGAL();
        final String picture = mData.get(position).getPICTURE_BERITA();
        final String datetime = mData.get(position).getDATETIME_TGL();
        holder.judul_berita.setText(judul);
        holder.desk_berita.setText(deskripsi);
        holder.tanggal_berita.setText(tanggal);
        Picasso.with(context).load(linkDatabase.linkurl()+picture).into(holder.gambar);

    }
//    // END_INCLUDE(recyclerViewOnBindViewHolder)
//
//    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mData.size();
//        return 0;
    }
}