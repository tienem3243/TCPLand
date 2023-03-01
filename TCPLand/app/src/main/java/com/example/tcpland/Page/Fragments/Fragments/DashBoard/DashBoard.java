package com.example.tcpland.Page.Fragments.Fragments.DashBoard;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tcpland.Adapter.DashBoardAdapter;
import com.example.tcpland.View.Account.Tintuc.TinTucFragmt;
import com.example.tcpland.Model.ItemModel;
import com.example.tcpland.R;
import com.example.tcpland.Page.Fragments.Fragments.Contract;
import com.example.tcpland.Page.Fragments.Fragments.Social_Media;
import com.example.tcpland.Page.Fragments.Duan.DuAnFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashBoard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashBoard extends Fragment {
    public GridView getDashboard() {
        return dashboard;
    }

    GridView dashboard;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashBoard() {
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
    public static DashBoard newInstance(String param1, String param2) {
        DashBoard fragment = new DashBoard();
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

    @Override
    public void onResume() {
//        dashboard.setVisibility(View.VISIBLE);
        Log.e("SS", "onResume: ");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("SS", "onPause: ");
        super.onPause();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Log.e("SS", "onAttach: ");
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<ItemModel> dashBoardGridItemList = new ArrayList<>();
        //todo change follow app require
        InitDashBoard(dashBoardGridItemList);
    }

    private void InitDashBoard(ArrayList<ItemModel> dashBoardGridItemList) {
        dashBoardGridItemList.add(new ItemModel("Hợp đồng hợp tác", R.drawable.ic_contract, new Contract()));
        dashBoardGridItemList.add(new ItemModel("Tin tức", R.drawable.ic_news, new TinTucFragmt()));
        dashBoardGridItemList.add(new ItemModel("Dự án", R.drawable.ic_news, new DuAnFragment(getActivity())));
        //set up du an
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.duAn, new DuAnFragment())
                .commit();
        requireActivity()
                .getSupportFragmentManager().beginTransaction()
                .replace(R.id.newsView, new TinTucFragmt())
                .commit();
        dashBoardGridItemList.add(new ItemModel("Liên hệ", R.drawable.ic_social_media, new Social_Media()));
        DashBoardAdapter adapter = new DashBoardAdapter(getActivity(), dashBoardGridItemList);
        //set up menu
        LinearLayout linearLayout = getView().findViewById(R.id.linearLayout1);
        for (int i = 0; i < dashBoardGridItemList.size(); i++) {
            View v = adapter.getView(i, null, linearLayout);
            int finalI = i;
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity()
                            .getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, dashBoardGridItemList.get(finalI).getTargetFragment())
                            .commit();
                }
            });
            linearLayout.addView(v);
        }


    }
}