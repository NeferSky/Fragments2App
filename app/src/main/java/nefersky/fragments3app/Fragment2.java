package nefersky.fragments3app;

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

    public static final String BUTTON_INDEX = "button_index";
    private static final int BUTTON_INDEX_DEFAULT = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info, container, false);

        mDescription = (TextView)rootView.findViewById(R.id.lblDescription);
        mCatImage = (ImageView)rootView.findViewById(R.id.imgCat);
        mCatDescriptions = getResources().getStringArray(R.array.cats);

        Bundle args = getArguments();
        int buttonIndex = args != null ? args.getInt(BUTTON_INDEX, BUTTON_INDEX_DEFAULT) : BUTTON_INDEX_DEFAULT;
        if (buttonIndex != BUTTON_INDEX_DEFAULT){
            showCatInfo(buttonIndex);
        }
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
