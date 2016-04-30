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
import johnkagga.me.alex_farm.utils.Constants;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    protected TextView currentUid;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        currentUid = (TextView) rootView.findViewById(R.id.currentUid);

        Firebase firebase = new Firebase(Constants.FIREBASE_URL);

        Firebase farmNode = firebase.child(Constants.FARM_NODE);

        farmNode.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long capturedTag = (long) dataSnapshot.child("CapturedTag").getValue();

                currentUid.setText(String.format("%d", capturedTag));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        return rootView;
    }
}
