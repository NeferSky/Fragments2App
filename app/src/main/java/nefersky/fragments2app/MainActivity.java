package nefersky.fragments2app;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.OnSelectedButtonListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean mIsDynamic;

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
        Fragment2 fragment2 = (Fragment2)fragmentManager.findFragmentById(R.id.frInfo);
        if (fragment2 == null || !fragment2.isVisible()) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("buttonIndex", buttonIndex);
            startActivity(intent);
        } else {
            fragment2.showCatInfo(buttonIndex);
        }
    }
}
