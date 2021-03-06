package com.olgav.android.sentences;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.olgav.android.sentences.R;

/**
 * Created by olga on 4/3/17.
 */

public class NoInternetDialogFragment extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            builder.setMessage(R.string.dialog_internet_eng_text).setPositiveButton
                    (R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            System.exit(1);
                        /*
                        Intent homeIntent= new Intent(getContext(), MainCardActivity.class);
                        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(homeIntent);
                        */
                        }
                    });
            return builder.create();
        }
}
