package com.android.mr_paul.sarwar.UtilityPackage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.mr_paul.sarwar.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class DonorDataAdapter extends ArrayAdapter<DonorData> {

    public DonorDataAdapter(Context c, int r, ArrayList<DonorData> l){
        super(c,r,l);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.donor_contribution_data_layout, parent, false);
        }

        DonorData donorData = getItem(position);

        TextView donorNameDisplay = convertView.findViewById(R.id.donor_name);
        TextView numDonationDisplay = convertView.findViewById(R.id.num_donations);
        CardView parentLayout = convertView.findViewById(R.id.parent_layout);

        if(FirebaseAuth.getInstance().getCurrentUser().getUid().equals(donorData.getUid())){
            parentLayout.setCardBackgroundColor(getContext().getResources().getColor(R.color.lightGreen));
        }
        else{
            parentLayout.setCardBackgroundColor(getContext().getResources().getColor(R.color.lightRed));
        }

        donorNameDisplay.setText(donorData.getName());
        numDonationDisplay.setText(Long.toString(donorData.getNumber()));

        return convertView;

    }
}
