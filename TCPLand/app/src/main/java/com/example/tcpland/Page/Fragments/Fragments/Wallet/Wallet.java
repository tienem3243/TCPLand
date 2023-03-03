package com.example.tcpland.Page.Fragments.Fragments.Wallet;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tcpland.Model.Account;
import com.example.tcpland.R;
import com.example.tcpland.Vi.Vi_Fragment;
import com.example.tcpland.databinding.WalletFragmentBinding;
import com.example.tcpland.Page.Fragments.Duan.DuAnFragment;

import java.util.Objects;


public class Wallet extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Wallet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlgorithmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DuAnFragment newInstance(String param1, String param2) {
        DuAnFragment fragment = new DuAnFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        WalletFragmentBinding binding= WalletFragmentBinding.inflate(inflater,container,false);
        TextView vi1= binding.vi1;
        TextView vi2= binding.vi2;
        TextView vi3= binding.vi3;
        RelativeLayout layout=binding.buttonGoLichsu;
        Account account = (Account) requireActivity().getIntent().getSerializableExtra("userInfo");
        Log.e("testSeri", "onCreateView: "+account.getVi1().getBalance().toString() );
        vi1.setText(account.getVi1().getBalance().toString());
        vi2.setText(account.getVi2().getBalance().toString());
        vi3.setText(account.getVi3().getBalance().toString());
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Vi_Fragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return binding.getRoot();
    }
}
