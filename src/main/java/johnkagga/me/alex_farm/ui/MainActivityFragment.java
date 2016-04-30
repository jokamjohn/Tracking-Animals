package johnkagga.me.alex_farm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import johnkagga.me.alex_farm.R;
import johnkagga.me.alex_farm.model.TrackData;
import johnkagga.me.alex_farm.utils.Constants;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    protected TextView mCurrentUid, mArea, mLocation;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mCurrentUid = (TextView) rootView.findViewById(R.id.currentUid);
        mArea = (TextView) rootView.findViewById(R.id.area);
        mLocation = (TextView) rootView.findViewById(R.id.location);

        Firebase firebase = new Firebase(Constants.FIREBASE_URL);

        Firebase farmNode = firebase.child(Constants.FARM_NODE);

        farmNode.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TrackData trackData = dataSnapshot.getValue(TrackData.class);
                mCurrentUid.setText(String.format("%d", trackData.getCapturedTag()));
                mArea.setText(trackData.getArea());
                mLocation.setText(trackData.getLocation());

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        return rootView;
    }
}
