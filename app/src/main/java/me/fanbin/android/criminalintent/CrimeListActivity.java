package me.fanbin.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by fanbin on 2017/12/18.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
