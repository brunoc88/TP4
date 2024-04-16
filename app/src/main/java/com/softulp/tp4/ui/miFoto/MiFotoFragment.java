package com.softulp.tp4.ui.miFoto;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.tp4.R;
import com.softulp.tp4.databinding.FragmentGalleryBinding;

public class MiFotoFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MiFotoViewModel miFotoViewModelViewModel =
                new ViewModelProvider(this).get(MiFotoViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ImageView imageView = binding.ivFoto;
        imageView.setImageResource(R.drawable.messi);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}