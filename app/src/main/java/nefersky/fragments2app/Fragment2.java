package nefersky.fragments2app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    private TextView mDescription;
    private ImageView mCatImage;
    private String[] mCatDescriptions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info, container, false);

        mDescription = (TextView)rootView.findViewById(R.id.lblDescription);
        mCatImage = (ImageView)rootView.findViewById(R.id.imgCat);
        mCatDescriptions = getResources().getStringArray(R.array.cats);

        return rootView;
    }

    public void showCatInfo(int Index){
        mDescription.setText(mCatDescriptions[Index]);

        switch(Index){
            case 1:
                mCatImage.setImageResource(R.drawable.redhead);
                break;
            case 2:
                mCatImage.setImageResource(R.drawable.panther);
                break;
            case 3:
                mCatImage.setImageResource(R.drawable.marsh);
                break;
        }
    }
}
