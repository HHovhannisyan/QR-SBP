package ru.mertech.sbpskb.ui.fragments;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.databinding.BankChoiceFragmentBinding;
import ru.mertech.sbpskb.pojo.BankModel;
import ru.mertech.sbpskb.ui.adapters.BankGVAdapter;
import ru.mertech.sbpskb.ui.viewModels.BankChoiceViewModel;


public class BankChoiceFragment extends Fragment {

    private BankChoiceViewModel mViewModel;
    BankChoiceFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = BankChoiceFragmentBinding.inflate(inflater, container, false);
        BottomNavigationView navBar = requireActivity().findViewById(R.id.nav_view);
        navBar.setVisibility(View.INVISIBLE);
        ArrayList<BankModel> bankModelArrayList = new ArrayList<>();
        bankModelArrayList.add(new BankModel("Tinnkoff", R.drawable.ic_account));
        bankModelArrayList.add(new BankModel("Alpha", R.drawable.ic_history));
        bankModelArrayList.add(new BankModel("Gazprom", R.drawable.ic_help));
        bankModelArrayList.add(new BankModel("Gazprom", R.drawable.ic_key));


        BankGVAdapter adapter = new BankGVAdapter(requireContext(), bankModelArrayList);
        binding.idGVbanks.setAdapter(adapter);

        binding.noMyBanks.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);


        binding.continueBtn.setOnClickListener(view -> requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_generate_qr, new HelpFragment()).commit());

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_generate_qr, new SettingsFragment()).commit();
            }
        });

        return binding.getRoot();
    }

}