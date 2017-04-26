package nefersky.fragmentsapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment1.OnSelectedButtonListener {

    /*
    private TextView mCatDescription;
    private ImageView mCatPicture;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mCatDescription = (TextView) findViewById(R.id.tvDescription);
        //mCatPicture = (ImageView) findViewById(R.id.imgCat);
    }

    @Override
    public void onButtonSelected(int buttonIndex) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment2 fragment2 = (Fragment2)fragmentManager.findFragmentById(R.id.fragment2);
        if (fragment2 == null || !fragment2.isVisible()) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("buttonIndex", buttonIndex);
            startActivity(intent);
        } else {
            fragment2.showCatInfo(buttonIndex);
        }
    }

    /*
    public void onClickRedhead(View view) {
        mCatDescription.setText(R.string.RedheadDescription);
        mCatPicture.setImageResource(R.drawable.redhead);
        //mCatPicture.setImageDrawable(getDrawable(R.drawable.redhead)); // API 21
    }

    public void onClickPanther(View view) {
        mCatDescription.setText(R.string.PantherDescription);
        mCatPicture.setImageResource(R.drawable.panther);
    }

    public void onClickMarsh(View view) {
        mCatDescription.setText(R.string.MarshDescription);
        mCatPicture.setImageResource(R.drawable.marsh);
    }
    */
}
