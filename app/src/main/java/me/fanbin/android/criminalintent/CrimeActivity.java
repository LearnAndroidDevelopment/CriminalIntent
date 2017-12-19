package me.fanbin.android.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    public static final String EXTRA_CREAME_POSITION = "me.fanbin.androidcriminalintent.crime_position";

    public static Intent newIntent(Context packageContext, int position) {
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CREAME_POSITION, position);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        int position = getIntent().getIntExtra(EXTRA_CREAME_POSITION, 0);
        return CrimeFragment.newInstance(position);
    }
}
