package ng.riby_android_test;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {


    private SaveRecordListener listener = null;

    public interface SaveRecordListener {
        void onSaveClicked();
    }

    public void setOnSaveRecordListener(SaveRecordListener listener) {
        this.listener = listener;
    }

    private View v;
    private RecordLocationActivity activity;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        v = inflater.inflate(R.layout.custom_dialog_layout, null);

        activity = new RecordLocationActivity();
        builder.setView(v);

        Button save_mapping = v.findViewById(R.id.save_mapping);
        Button continue_mapping = v.findViewById(R.id.continue_mapping);
        ImageView exit_dialog = v.findViewById(R.id.exit_dialog);


        save_mapping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onSaveClicked();
                }
            }
        });

        continue_mapping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "You want to continue", Toast.LENGTH_SHORT).show();
                getDialog().hide();

            }
        });

        exit_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "You want to exit the dialog button", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });


        return builder.create();

    }
}
