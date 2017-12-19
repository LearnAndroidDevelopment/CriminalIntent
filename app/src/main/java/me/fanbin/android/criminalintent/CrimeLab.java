package me.fanbin.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by fanbin on 2017/12/18.
 */

public class CrimeLab {

    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;
    private Map<UUID, Integer> mIndex;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        mIndex = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            mCrimes.add(crime);
            mIndex.put(crime.getId(), i);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Map<UUID, Integer> getIndex() {
        return mIndex;
    }

    public Crime getCrime(UUID id) {
        return mCrimes.get(mIndex.get(id));
    }

}
