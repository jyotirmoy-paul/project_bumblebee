package paul.cipherresfeber.sarwar.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import paul.cipherresfeber.sarwar.R;
import paul.cipherresfeber.sarwar.activities.ProfileUpdateActivity;
import paul.cipherresfeber.sarwar.util.Constants;


public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.profile_fragment,container, false);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);

        TextView profilePicView = view.findViewById(R.id.profile_pic);
        TextView userNameDisplay = view.findViewById(R.id.user_name);
        TextView userEmailDisplay = view.findViewById(R.id.user_email);
        TextView userAddressDisplay = view.findViewById(R.id.user_address);
        TextView userMobileDisplay = view.findViewById(R.id.user_mobile_number);
        FloatingActionButton editProfileDetail = view.findViewById(R.id.edit_profile_detail);

        String userName = sharedPreferences.getString(Constants.USER_NAME, Constants.UNDEFINED);
        String userEmail = sharedPreferences.getString(Constants.USER_EMAIL,Constants.UNDEFINED);
        String userAddress = sharedPreferences.getString(Constants.USER_ADDRESS,Constants.UNDEFINED);
        String userMobile = sharedPreferences.getString(Constants.USER_PHONE_NUMBER,Constants.UNDEFINED);

        userNameDisplay.setText(userName);
        userEmailDisplay.setText(userEmail);
        userMobileDisplay.setText(userMobile);
        userAddressDisplay.setText(userAddress);

        profilePicView.setText(userName.toUpperCase().charAt(0) + "");

        // set an onClick listener for editing the details in profile section
        editProfileDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start a new activity for editing profile
                startActivity(new Intent(getContext(), ProfileUpdateActivity.class));
            }
        });

        return view;
    }
}
