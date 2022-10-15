package ru.mertech.sbpskb.ui.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.mertech.sbpskb.ui.viewModels.HelpViewModel;
import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.databinding.HelpFragmentBinding;

public class HelpFragment extends Fragment {

    private HelpViewModel mViewModel;
    HelpFragmentBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = HelpFragmentBinding.inflate(inflater, container, false);
        TextView textView = (requireActivity()).findViewById(R.id.title);
        textView.setText(R.string.kuayring);

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailSend = "sbp@mertech.ru";
                String emailSubject = "Help";
                String emailBody = "ИНН: "+binding.edittxtInn.getText() + "\n"
                        + "Номер телефона: "+binding.edittxtPhone.getText() + "\n"
                        + "Адрес: "+binding.edittxtAddress.getText() + "\n"
                        + "Комментарии: \n"+binding.edittxtComment.getText() + "\n";

                if (!binding.edittxtInn.getText().toString().isEmpty() && !binding.edittxtPhone.getText().toString().isEmpty() && !binding.edittxtAddress.getText().toString().isEmpty() && !binding.edittxtComment.getText().toString().isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL,
                            new String[]{emailSend});
                    intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                    intent.putExtra(Intent.EXTRA_TEXT, emailBody);
                    intent.setData(Uri.parse("mailto:"));

                    try {
                        startActivity(Intent.createChooser(intent, "Mail with...."));
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(requireActivity(), "Don't", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(requireActivity(), "Please fill all the fields",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.backTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_generate_qr, new BankChoiceFragment()).commit();
            }
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_generate_qr, new SettingsFragment()).commit();
            }
        });

        return binding.getRoot();
    }

}