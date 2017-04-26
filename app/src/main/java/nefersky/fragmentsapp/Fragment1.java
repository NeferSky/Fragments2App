package nefersky.fragmentsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment implements View.OnClickListener {

    public interface OnSelectedButtonListener {
        void onButtonSelected(int buttonIndex);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, container, false);

        Button btnRedhead = (Button)rootView.findViewById(R.id.btnRedhead);
        Button btnPanther = (Button)rootView.findViewById(R.id.btnPanther);
        Button btnMarsh = (Button)rootView.findViewById(R.id.btnMarsh);

        btnRedhead.setOnClickListener(this); // "this" available by the interface
        btnPanther.setOnClickListener(this);
        btnMarsh.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        int Index = translateIdToIndex(view.getId());

        OnSelectedButtonListener listener = (OnSelectedButtonListener)getActivity();
        listener.onButtonSelected(Index);
    }

    private int translateIdToIndex(int id){
        int Index;
        switch(id){
            case (R.id.btnRedhead):
                Index = 1;
                break;
            case (R.id.btnPanther):
                Index = 2;
                break;
            case (R.id.btnMarsh):
                Index = 3;
                break;
            default:
                Index = -1;
        }
        return Index;
    }
}
