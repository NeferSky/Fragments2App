package nefersky.fragments3app;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.OnSelectedButtonListener {

    private boolean mIsDynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment2 fragment2 = (Fragment2)fragmentManager.findFragmentById(R.id.frInfo);

        mIsDynamic = fragment2 == null || !fragment2.isInLayout();

        Toast.makeText(getApplicationContext(), mIsDynamic + "", Toast.LENGTH_SHORT).show();

        if (mIsDynamic) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            Fragment1 fragment1 = new Fragment1();
            ft.add(R.id.layPortraitContainer, fragment1);
            ft.commit();
        }
    }

    @Override
    public void onButtonSelected(int buttonIndex) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment2 fragment2;

        if (mIsDynamic){
            FragmentTransaction ft = fragmentManager.beginTransaction();
            fragment2 = new Fragment2();
            Bundle args = new Bundle();
            args.putInt(Fragment2.BUTTON_INDEX, buttonIndex);
            fragment2.setArguments(args);
            ft.replace(R.id.layPortraitContainer, fragment2, "fragment2");
            ft.addToBackStack(null);
            ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
            ft.commit();
        } else {
            fragment2 = (Fragment2)fragmentManager.findFragmentById(R.id.frInfo);
            fragment2.showCatInfo(buttonIndex);
        }
    }
}
