package me.fanbin.android.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.UUID;

/**
 * Created by fanbin on 2017/12/27.
 */

public class PictureFragment extends DialogFragment {

    private ImageView mImageView;

    private static final String ARG_UUID = "uuid";

    public static PictureFragment newInstance(UUID uuid) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_UUID, uuid);
        PictureFragment fragment = new PictureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        UUID id = (UUID) getArguments().getSerializable(ARG_UUID);
        Crime crime = CrimeLab.get(getActivity()).getCrime(id);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_picture, null);

        mImageView = (ImageView) v.findViewById(R.id.dialog_image_view);
        mImageView.setImageBitmap(PictureUtils.getScaleBitmap(CrimeLab.get(getActivity()).getPhotoFile(crime).getPath(), getActivity()));

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }
}
