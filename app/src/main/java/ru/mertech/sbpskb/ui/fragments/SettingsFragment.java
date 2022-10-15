package ru.mertech.sbpskb.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.hilt.android.AndroidEntryPoint;
import ru.mertech.sbpskb.Constants;
import ru.mertech.sbpskb.R;
import ru.mertech.sbpskb.databinding.FragmentSettingsBinding;
import ru.mertech.sbpskb.ui.adapters.SettingsListAdapter;
import ru.mertech.sbpskb.ui.viewModels.SettingsViewModel;
import ru.mertech.sbpskb.utils.GPSUtil;
@AndroidEntryPoint
public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;

    String[] settingNames = {"Подключение дисплея", "Настройки ТСП", "Открыть счет в СБП", "Прочие настройки"};
    int[] settingIcons = {R.drawable.ic_setting_display,
            R.drawable.ic_setting_tsp,
            R.drawable.ic_sbp,
            R.drawable.ic_other_settings
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingsViewModel settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);

        SettingsListAdapter myAdapter = new SettingsListAdapter(getContext(), settingNames, settingIcons);
        binding.listview.setAdapter(myAdapter);
        binding.listview.setOnItemClickListener((adapterView, view, i, l) -> {
            if (adapterView.getPositionForView(view) == 0) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_generate_qr, new SettingDisplayFragment()).commit();
            }

            if (adapterView.getPositionForView(view) == 1) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_generate_qr, new SettingsTspFragment(),"Settings_TSP_Fragment").commit();

            }

            if (adapterView.getPositionForView(view) == 2) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_generate_qr, new BankChoiceFragment()).commit();
            }

            if (adapterView.getPositionForView(view) == 3) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_generate_qr, new OtherSettingsFragment()).commit();
            }
        });

        BottomNavigationView navBar = requireActivity().findViewById(R.id.nav_view);
        if(navBar.getVisibility()==View.INVISIBLE) {
            navBar.setVisibility(View.VISIBLE);
        }
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
       new GPSUtil(requireActivity()).turnGPSOn(isGPSEnable -> Constants.isGPS = isGPSEnable);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}